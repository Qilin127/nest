package com.nest.renting.web.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.*;
import com.nest.renting.model.enums.ItemType;
import com.nest.renting.web.admin.mapper.*;
import com.nest.renting.web.admin.service.*;
import com.nest.renting.web.admin.vo.apartment.ApartmentSubmitVo;
import com.nest.renting.web.admin.vo.graph.GraphVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @description The implementation of the database operation Service for the table [apartment_info(Apartment information table)]
 */
@Service
public class ApartmentInfoServiceImpl extends ServiceImpl<ApartmentInfoMapper, ApartmentInfo>
        implements ApartmentInfoService {

    @Autowired
    private GraphInfoService graphInfoService;
    @Autowired
    private ApartmentFacilityService apartmentFacilityService;
    @Autowired
    private ApartmentLabelService apartmentLabelService;
    @Autowired
    private ApartmentFeeValueService apartmentFeeValueService;

    /**
     * Update logic: Delete all the original data and then add all the data returned by the front end
     * @param apartmentSubmitVo All the information of the apartment sent back from the front end
     */
    @Override
    public void saveOrUpdateApartment(ApartmentSubmitVo apartmentSubmitVo) {
        // Determine whether the front end passes an id (if there is an id, it means modification; if not, it means addition).
        boolean isUpdate = apartmentSubmitVo.getId() != null; // mp will automatically echo the primary key. First, it is necessary to determine whether the id is empty

        // Save the ordinary ApartmentInfo information (both updates and insertions need to be performed)
        super.saveOrUpdate(apartmentSubmitVo); // Can directly send  VO and it will handle it automatically

        if (isUpdate) { // If there is an id, perform the modification operation
            // Delete the original picture
            LambdaQueryWrapper<GraphInfo> graphInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
            graphInfoLambdaQueryWrapper.eq(GraphInfo::getItemType, ItemType.APARTMENT)
                    .eq(GraphInfo::getItemId, apartmentSubmitVo.getId());
            graphInfoService.remove(graphInfoLambdaQueryWrapper);

            // Delete the original supporting information
            LambdaQueryWrapper<ApartmentFacility> facilityLambdaQueryWrapper = new LambdaQueryWrapper<>();
            facilityLambdaQueryWrapper.eq(ApartmentFacility::getApartmentId, apartmentSubmitVo.getId());
            apartmentFacilityService.remove(facilityLambdaQueryWrapper);

            // Delete the original tag list
            LambdaQueryWrapper<ApartmentLabel> labelLambdaQueryWrapper = new LambdaQueryWrapper<>();
            labelLambdaQueryWrapper.eq(ApartmentLabel::getApartmentId, apartmentSubmitVo.getId());
            apartmentLabelService.remove(labelLambdaQueryWrapper);

            // Delete the original list of miscellaneous charges
            LambdaQueryWrapper<ApartmentFeeValue> feeValueLambdaQueryWrapper = new LambdaQueryWrapper<>();
            feeValueLambdaQueryWrapper.eq(ApartmentFeeValue::getApartmentId, apartmentSubmitVo.getId());
            apartmentFeeValueService.remove(feeValueLambdaQueryWrapper);

        }

        // Insert a new picture
        List<GraphVo> graphVoList = apartmentSubmitVo.getGraphVoList();
        if (graphVoList != null && !graphVoList.isEmpty()) {
            List<GraphInfo> graphInfoList = new ArrayList<>();
            for (GraphVo graphVo : graphVoList) {
                GraphInfo graphInfo = new GraphInfo();
                graphInfo.setItemType(ItemType.APARTMENT);
                graphInfo.setItemId(apartmentSubmitVo.getId());
                graphInfo.setName(graphVo.getName());
                graphInfo.setUrl(graphVo.getUrl());
                graphInfoList.add(graphInfo);
            }
            graphInfoService.saveBatch(graphInfoList);
        }

        // Insert the new facility information
        List<Long> facilityInfoIdsList = apartmentSubmitVo.getFacilityInfoIds();
        if (facilityInfoIdsList != null && !facilityInfoIdsList.isEmpty()) {
            List<ApartmentFacility> apartmentFacilityList = new ArrayList<>();
            for (Long facilityInfoId : facilityInfoIdsList) {
                ApartmentFacility apartmentFacility = new ApartmentFacility();
                apartmentFacility.setApartmentId(apartmentSubmitVo.getId());
                apartmentFacility.setFacilityId(facilityInfoId);
                apartmentFacilityList.add(apartmentFacility);
            }
            apartmentFacilityService.saveBatch(apartmentFacilityList);
        }

        // Insert a new list of tags
        List<Long> labelIds = apartmentSubmitVo.getLabelIds();
        if (labelIds != null && !labelIds.isEmpty()) {
            List<ApartmentLabel> apartmentLabelList = new ArrayList<>();
            for (Long labelId : labelIds) {
                ApartmentLabel apartmentLabel = new ApartmentLabel();
                apartmentLabel.setApartmentId(apartmentSubmitVo.getId());
                apartmentLabel.setLabelId(labelId);
                apartmentLabelList.add(apartmentLabel);
            }
            apartmentLabelService.saveBatch(apartmentLabelList);
        }

        // Insert a new list of miscellaneous charges
        List<Long> feeValueIds = apartmentSubmitVo.getFeeValueIds();
        if (feeValueIds != null && !feeValueIds.isEmpty()) {
            List<ApartmentFeeValue> apartmentFeeValueList = new ArrayList<>();
            for (Long feeValueId : feeValueIds) {
                ApartmentFeeValue apartmentFeeValue = new ApartmentFeeValue();
                apartmentFeeValue.setApartmentId(apartmentSubmitVo.getId());
                apartmentFeeValue.setFeeValueId(feeValueId);
                apartmentFeeValueList.add(apartmentFeeValue);
            }
            apartmentFeeValueService.saveBatch(apartmentFeeValueList);
        }

    }
}





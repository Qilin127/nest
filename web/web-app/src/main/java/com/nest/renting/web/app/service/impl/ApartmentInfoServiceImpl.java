package com.nest.renting.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.ApartmentInfo;
import com.nest.renting.model.entity.FacilityInfo;
import com.nest.renting.model.entity.LabelInfo;
import com.nest.renting.model.enums.ItemType;
import com.nest.renting.web.app.mapper.ApartmentInfoMapper;
import com.nest.renting.web.app.mapper.FacilityInfoMapper;
import com.nest.renting.web.app.mapper.GraphInfoMapper;
import com.nest.renting.web.app.mapper.LabelInfoMapper;
import com.nest.renting.web.app.mapper.RoomInfoMapper;
import com.nest.renting.web.app.service.ApartmentInfoService;
import com.nest.renting.web.app.vo.apartment.ApartmentDetailVo;
import com.nest.renting.web.app.vo.apartment.ApartmentItemVo;
import com.nest.renting.web.app.vo.graph.GraphVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ApartmentInfoServiceImpl extends ServiceImpl<ApartmentInfoMapper, ApartmentInfo>
        implements ApartmentInfoService {

    @Autowired
    private ApartmentInfoMapper apartmentInfoMapper;
    @Autowired
    private LabelInfoMapper labelInfoMapper;
    @Autowired
    private GraphInfoMapper graphInfoMapper;
    @Autowired
    private RoomInfoMapper roomInfoMapper;
    @Autowired
    private FacilityInfoMapper facilityInfoMapper;

    @Override
    public ApartmentItemVo getApartmentItemVoById(Long apartmentId) {
        // Delegate to the main implementation
        return selectApartmentItemVoById(apartmentId);
    }

    /**
     * Retrieve a simplified apartment item view object by apartment ID.
     *
     * Steps:
     * 1) Query apartment basic information.
     * 2) Query associated labels.
     * 3) Query associated images.
     * 4) Query the minimum rent value among all rooms under this apartment.
     * 5) Assemble and return an {@link ApartmentItemVo} object.
     *
     * @param apartmentId the apartment ID
     * @return an {@link ApartmentItemVo} representing the apartment summary
     */
    @Override
    public ApartmentItemVo selectApartmentItemVoById(Long apartmentId) {
        ApartmentInfo apartmentInfo = apartmentInfoMapper.selectById(apartmentId);
        List<LabelInfo> labelInfoList = labelInfoMapper.selectListByApartmentId(apartmentId);
        List<GraphVo> graphVoList = graphInfoMapper.selectListByItemTypeAndId(ItemType.APARTMENT, apartmentId);
        BigDecimal minRent = roomInfoMapper.selectMinRentByApartmentId(apartmentId);

        ApartmentItemVo apartmentItemVo = new ApartmentItemVo();
        BeanUtils.copyProperties(apartmentInfo, apartmentItemVo);
        apartmentItemVo.setGraphVoList(graphVoList);
        apartmentItemVo.setLabelInfoList(labelInfoList);
        apartmentItemVo.setMinRent(minRent);
        return apartmentItemVo;
    }

    /**
     * Retrieve detailed information about an apartment by its ID.
     *
     * Steps:
     * 1) Query apartment basic information.
     * 2) Query associated images.
     * 3) Query associated labels.
     * 4) Query associated facilities.
     * 5) Query the minimum rent value among rooms under this apartment.
     * 6) Assemble and return an {@link ApartmentDetailVo} object.
     *
     * @param id the apartment ID
     * @return an {@link ApartmentDetailVo} containing full apartment details
     */
    @Override
    public ApartmentDetailVo getDetailById(Long id) {
        ApartmentInfo apartmentInfo = apartmentInfoMapper.selectById(id);
        List<GraphVo> graphVoList = graphInfoMapper.selectListByItemTypeAndId(ItemType.APARTMENT, id);
        List<LabelInfo> labelInfoList = labelInfoMapper.selectListByApartmentId(id);
        List<FacilityInfo> facilityInfoList = facilityInfoMapper.selectListByApartmentId(id);
        BigDecimal minRent = roomInfoMapper.selectMinRentByApartmentId(id);

        ApartmentDetailVo apartmentDetailVo = new ApartmentDetailVo();
        BeanUtils.copyProperties(apartmentInfo, apartmentDetailVo);
        apartmentDetailVo.setGraphVoList(graphVoList);
        apartmentDetailVo.setLabelInfoList(labelInfoList);
        apartmentDetailVo.setMinRent(minRent);
        apartmentDetailVo.setFacilityInfoList(facilityInfoList);
        return apartmentDetailVo;
    }
}








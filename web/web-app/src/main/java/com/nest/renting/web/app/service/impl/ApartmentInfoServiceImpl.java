package com.nest.renting.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.model.entity.ApartmentInfo;
import com.nest.renting.model.entity.FacilityInfo;
import com.nest.renting.model.entity.LabelInfo;
import com.nest.renting.model.enums.ItemType;
import com.nest.renting.web.app.mapper.*;
import com.nest.renting.web.app.service.ApartmentInfoService;

import com.nest.renting.web.app.vo.apartment.ApartmentDetailVo;
import com.nest.renting.web.app.vo.apartment.ApartmentItemVo;
import com.nest.renting.web.app.vo.graph.GraphVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.nest.renting.web.app.vo.apartment.ApartmentItemVo;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * ApartmentInfoServiceImpl
 *
 * Service implementation for performing database operations
 * on the {@link ApartmentInfo} entity (apartment information table).
 * Provides functionality to query apartment items and detailed apartment information.
 *
 * Author: Yuze Wang
 * Date: September 22, 2025
 */
@Service
public class ApartmentInfoServiceImpl extends ServiceImpl<ApartmentInfoMapper, ApartmentInfo> implements ApartmentInfoService {

    @Override
    public ApartmentItemVo getApartmentItemVoById(Long apartmentId) {
        // Delegate to the main implementation
        return selectApartmentItemVoById(apartmentId);
    }

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

    /**
     * Retrieve a simplified apartment item view object by apartment ID.
     * <p>
     * Steps:
     * <ul>
     *     <li>Query apartment basic information.</li>
     *     <li>Query associated labels.</li>
     *     <li>Query associated images.</li>
     *     <li>Query the minimum rent value among all rooms under this apartment.</li>
     *     <li>Assemble and return an {@link ApartmentItemVo} object.</li>
     * </ul>
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
     * <p>
     * Steps:
     * <ul>
     *     <li>Query apartment basic information.</li>
     *     <li>Query associated images.</li>
     *     <li>Query associated labels.</li>
     *     <li>Query associated facilities.</li>
     *     <li>Query the minimum rent value among rooms under this apartment.</li>
     *     <li>Assemble and return an {@link ApartmentDetailVo} object.</li>
     * </ul>
     *
     * @param id the apartment ID
     * @return an {@link ApartmentDetailVo} containing full apartment details
     */
    @Override
    public ApartmentDetailVo getDetailById(Long id) {
        // Query basic apartment info
        ApartmentInfo apartmentInfo = apartmentInfoMapper.selectById(id);

        // Query additional information
        List<GraphVo> graphVoList = graphInfoMapper.selectListByItemTypeAndId(ItemType.APARTMENT, id);
        List<LabelInfo> labelInfoList = labelInfoMapper.selectListByApartmentId(id);
        List<FacilityInfo> facilityInfoList = facilityInfoMapper.selectListByApartmentId(id);
        BigDecimal minRent = roomInfoMapper.selectMinRentByApartmentId(id);

        // Assemble VO object
        ApartmentDetailVo apartmentDetailVo = new ApartmentDetailVo();
        BeanUtils.copyProperties(apartmentInfo, apartmentDetailVo);
        apartmentDetailVo.setGraphVoList(graphVoList);
        apartmentDetailVo.setLabelInfoList(labelInfoList);
        apartmentDetailVo.setMinRent(minRent);
        apartmentDetailVo.setFacilityInfoList(facilityInfoList);

        return apartmentDetailVo;
    }
}






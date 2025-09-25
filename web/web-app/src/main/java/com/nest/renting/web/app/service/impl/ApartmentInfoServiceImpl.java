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
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ApartmentInfoServiceImpl extends ServiceImpl<ApartmentInfoMapper, ApartmentInfo> implements ApartmentInfoService {

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
        return null;
    }

    @Override
    public ApartmentDetailVo getDetailById(Long id) {
        // 查询普通公寓信息
        ApartmentInfo apartmentInfo = apartmentInfoMapper.selectById(id);

        // 查询Vo中额外信息
        // 查询图片列表
        List<GraphVo> graphVoList = graphInfoMapper.selectListByItemTypeAndId(ItemType.APARTMENT, id);

        // 查询标签列表
        List<LabelInfo> labelInfoList = labelInfoMapper.selectListByApartmentId(id);

        // 查询配套列表
        List<FacilityInfo> facilityInfoList = facilityInfoMapper.selectListByApartmentId(id);

        // 查询租金最小值
        BigDecimal minRent = roomInfoMapper.selectMinRentByApartmentId(id);

        // 打包 Vo 数据
        ApartmentDetailVo apartmentDetailVo = new ApartmentDetailVo();
        BeanUtils.copyProperties(apartmentInfo, apartmentDetailVo);
        apartmentDetailVo.setGraphVoList(graphVoList);
        apartmentDetailVo.setLabelInfoList(labelInfoList);
        apartmentDetailVo.setMinRent(minRent);
        apartmentDetailVo.setFacilityInfoList(facilityInfoList);

        return apartmentDetailVo;
    }

}





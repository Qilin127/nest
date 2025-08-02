package com.nest.renting.web.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.common.constant.RedisConstant;
import com.nest.renting.model.entity.*;
import com.nest.renting.model.enums.ItemType;
import com.nest.renting.web.admin.mapper.*;
import com.nest.renting.web.admin.service.*;

import com.nest.renting.web.admin.vo.attr.AttrValueVo;
import com.nest.renting.web.admin.vo.graph.GraphVo;
import com.nest.renting.web.admin.vo.room.RoomDetailVo;
import com.nest.renting.web.admin.vo.room.RoomItemVo;
import com.nest.renting.web.admin.vo.room.RoomQueryVo;
import com.nest.renting.web.admin.vo.room.RoomSubmitVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description The implementation of the database operation Service for the table [room_info(Room Information Table)]
 */
@Service
public class RoomInfoServiceImpl extends ServiceImpl<RoomInfoMapper, RoomInfo>
        implements RoomInfoService {

    @Autowired
    private GraphInfoService graphInfoService;
    @Autowired
    private RoomAttrValueService roomAttrValueService;
    @Autowired
    private RoomFacilityService roomFacilityService;
    @Autowired
    private RoomLabelService roomLabelService;
    @Autowired
    private RoomPaymentTypeService roomPaymentTypeService;
    @Autowired
    private RoomLeaseTermService roomLeaseTermService;
    @Autowired
    private RoomInfoMapper roomInfoMapper;
    @Autowired
    private ApartmentInfoMapper apartmentInfoMapper;
    @Autowired
    private GraphInfoMapper graphInfoMapper;
    @Autowired
    private AttrValueMapper attrValueMapper;
    @Autowired
    private FacilityInfoMapper facilityInfoMapper;
    @Autowired
    private LabelInfoMapper labelInfoMapper;
    @Autowired
    private PaymentTypeMapper paymentTypeMapper;
    @Autowired
    private LeaseTermMapper leaseTermMapper;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void saveOrUpdateRoom(RoomSubmitVo roomSubmitVo) {
        // 判断前端是否传id（有id就是修改，没有就是新增）
        boolean isUpdate = roomSubmitVo.getId() != null; // mp会自动进行主键回显，要先判断id是否为空
        // 保存普通RoomInfo信息（更新或者插入都要执行）
        super.saveOrUpdate(roomSubmitVo);

        // 如果传入id，则更新
        if (isUpdate) {
            // 删除图片列表
            LambdaQueryWrapper<GraphInfo> graphVoLambdaQueryWrapper = new LambdaQueryWrapper<>();
            graphVoLambdaQueryWrapper.eq(GraphInfo::getItemType, ItemType.ROOM)
                    .eq(GraphInfo::getItemId, roomSubmitVo.getId());
            graphInfoService.remove(graphVoLambdaQueryWrapper);

            // 删除属性信息列表
            LambdaQueryWrapper<RoomAttrValue> labelVoLambdaQueryWrapper = new LambdaQueryWrapper<>();
            labelVoLambdaQueryWrapper.eq(RoomAttrValue::getRoomId, roomSubmitVo.getId());
            roomAttrValueService.remove(labelVoLambdaQueryWrapper);

            // 删除配套信息列表
            LambdaQueryWrapper<RoomFacility> facilityVoLambdaQueryWrapper = new LambdaQueryWrapper<>();
            facilityVoLambdaQueryWrapper.eq(RoomFacility::getRoomId, roomSubmitVo.getId());
            roomFacilityService.remove(facilityVoLambdaQueryWrapper);

            // 删除标签信息列表
            LambdaQueryWrapper<RoomLabel> roomLabelVoLambdaQueryWrapper = new LambdaQueryWrapper<>();
            roomLabelVoLambdaQueryWrapper.eq(RoomLabel::getRoomId, roomSubmitVo.getId());
            roomLabelService.remove(roomLabelVoLambdaQueryWrapper);

            // 删除支付方式列表
            LambdaQueryWrapper<RoomPaymentType> roomPaymentTypeLambdaQueryWrapper = new LambdaQueryWrapper<>();
            roomPaymentTypeLambdaQueryWrapper.eq(RoomPaymentType::getRoomId, roomSubmitVo.getId());
            roomPaymentTypeService.remove(roomPaymentTypeLambdaQueryWrapper);

            // 删除可选租期列表
            LambdaQueryWrapper<RoomLeaseTerm> roomLeaseTermLambdaQueryWrapper = new LambdaQueryWrapper<>();
            roomLeaseTermLambdaQueryWrapper.eq(RoomLeaseTerm::getRoomId, roomSubmitVo.getId());
            roomLeaseTermService.remove(roomLeaseTermLambdaQueryWrapper);

            // 还要删除缓存
            String key = RedisConstant.APP_ROOM_PREFIX + roomSubmitVo.getId();
            redisTemplate.delete(key);
        }

        // 更新图片列表
        List<GraphVo> graphVoList = roomSubmitVo.getGraphVoList();
        if (graphVoList != null && !graphVoList.isEmpty()) {
            // 将GraphVo信息转移到GraphInfo，从而使配mp自动给出的saveBatch方法
            List<GraphInfo> graphInfoList = new ArrayList<>();
            for (GraphVo graphVo : graphVoList) {
                GraphInfo graphInfo = new GraphInfo();
                graphInfo.setItemType(ItemType.ROOM);
                graphInfo.setItemId(roomSubmitVo.getId());
                graphInfo.setUrl(graphVo.getUrl());
                graphInfo.setName(graphVo.getName());
                graphInfoList.add(graphInfo);
            }
            graphInfoService.saveBatch(graphInfoList);
        }

        // 更新属性信息列表
        List<Long> attrValueIds = roomSubmitVo.getAttrValueIds();
        if (attrValueIds != null && !attrValueIds.isEmpty()) {
            List<RoomAttrValue> roomAttrValueList = new ArrayList<>();
            for (Long attrValueId : attrValueIds) {
                RoomAttrValue roomAttrValue = new RoomAttrValue();
                roomAttrValue.setRoomId(roomSubmitVo.getId());
                roomAttrValue.setAttrValueId(attrValueId);
                roomAttrValueList.add(roomAttrValue);
            }
            roomAttrValueService.saveBatch(roomAttrValueList);
        }

        // 更新配套信息列表
        List<Long> facilityInfoIds = roomSubmitVo.getFacilityInfoIds();
        if (facilityInfoIds != null && !facilityInfoIds.isEmpty()) {
            List<RoomFacility> roomFacilityList = new ArrayList<>();
            for (Long facilityInfoId : facilityInfoIds) {
                RoomFacility roomFacility = new RoomFacility();
                roomFacility.setRoomId(roomSubmitVo.getId());
                roomFacility.setFacilityId(facilityInfoId);
                roomFacilityList.add(roomFacility);
            }
            roomFacilityService.saveBatch(roomFacilityList);
        }

        // 更新标签信息列表
        List<Long> labelInfoIds = roomSubmitVo.getLabelInfoIds();
        if (labelInfoIds != null && !labelInfoIds.isEmpty()) {
            List<RoomLabel> roomLabelList = new ArrayList<>();
            for (Long labelInfoId : labelInfoIds) {
                RoomLabel roomLabel = new RoomLabel();
                roomLabel.setRoomId(roomSubmitVo.getId());
                roomLabel.setLabelId(labelInfoId);
                roomLabelList.add(roomLabel);
            }
            roomLabelService.saveBatch(roomLabelList);
        }

        // 更新支付方式列表
        List<Long> paymentTypeIds = roomSubmitVo.getPaymentTypeIds();
        if (paymentTypeIds != null && !paymentTypeIds.isEmpty()) {
            List<RoomPaymentType> roomPaymentTypeList = new ArrayList<>();
            for (Long paymentTypeId : paymentTypeIds) {
                RoomPaymentType roomPaymentType = new RoomPaymentType();
                roomPaymentType.setRoomId(roomSubmitVo.getId());
                roomPaymentType.setPaymentTypeId(paymentTypeId);
                roomPaymentTypeList.add(roomPaymentType);
            }
            roomPaymentTypeService.saveBatch(roomPaymentTypeList);
        }

        // 更新可选租期列表
        List<Long> leaseTermIds = roomSubmitVo.getLeaseTermIds();
        if (leaseTermIds != null && !leaseTermIds.isEmpty()) {
            List<RoomLeaseTerm> roomLeaseTermList = new ArrayList<>();
            for (Long leaseTermId : leaseTermIds) {
                RoomLeaseTerm roomLeaseTerm = new RoomLeaseTerm();
                roomLeaseTerm.setRoomId(roomSubmitVo.getId());
                roomLeaseTerm.setLeaseTermId(leaseTermId);
                roomLeaseTermList.add(roomLeaseTerm);
            }
            roomLeaseTermService.saveBatch(roomLeaseTermList);
        }
    }

    @Override
    public IPage<RoomItemVo> pageRoomItemByQuery(IPage<RoomItemVo> itemVoIPage, RoomQueryVo queryVo) {
        return roomInfoMapper.pageRoomItemByQuery(itemVoIPage, queryVo);
    }

    @Override
    public RoomDetailVo getDetailById(Long id) {
        // 1. 获得Room基本信息(RoomInfo)
        RoomInfo roomInfo = roomInfoMapper.selectById(id);

        // 2. 获得VO额外信息
        // 2.1 获得所属公寓信息(ApartmentInfo)
        ApartmentInfo apartmentInfo = apartmentInfoMapper.selectById(roomInfo.getApartmentId());

        // 2.2 获得图片列表(graphVoList)
        List<GraphVo> graphVo = graphInfoMapper.selectListByItemTypeAndId(ItemType.ROOM, id);

        // 2.3 获得属性信息列表(attrValueVoList)
        List<AttrValueVo> attrValueVoList = attrValueMapper.selectListByRoomId(id);

        // 2.4 获得配套信息列表(facilityInfoList)
        List<FacilityInfo> facilityInfoList = facilityInfoMapper.selectListByRoomId(id);

        // 2.5 获得标签信息列表(labelInfoList)
        List<LabelInfo> labelInfoList = labelInfoMapper.selectListByRoomId(id);

        // 2.6 获得支付方式列表(paymentTypeList)
        List<PaymentType> paymentTypeList = paymentTypeMapper.selectListByRoomId(id);

        // 2.7 获得可选租期列表(leaseTermList)
        List<LeaseTerm> leaseTermList = leaseTermMapper.selectListByRoomId(id);

        RoomDetailVo roomDetailVo = new RoomDetailVo();
        // 使用BeanUtils工具类复制属性
        BeanUtils.copyProperties(roomInfo, roomDetailVo);

        roomDetailVo.setApartmentInfo(apartmentInfo);
        roomDetailVo.setGraphVoList(graphVo);
        roomDetailVo.setAttrValueVoList(attrValueVoList);
        roomDetailVo.setFacilityInfoList(facilityInfoList);
        roomDetailVo.setLabelInfoList(labelInfoList);
        roomDetailVo.setPaymentTypeList(paymentTypeList);
        roomDetailVo.setLeaseTermList(leaseTermList);

        return roomDetailVo;
    }

}





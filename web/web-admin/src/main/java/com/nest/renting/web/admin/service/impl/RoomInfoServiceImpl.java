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
        // Determine if the front end passed an id (if there is an id, it is an update; if not, it is a new insert)
        boolean isUpdate = roomSubmitVo.getId() != null; // mp will automatically echo the primary key, so check if id is null first
        // Save general RoomInfo information (execute both update and insert)
        super.saveOrUpdate(roomSubmitVo);

        // Delete image list
        if (isUpdate) {
            // Delete attribute information list
            LambdaQueryWrapper<RoomAttrValue> labelVoLambdaQueryWrapper = new LambdaQueryWrapper<>();
            labelVoLambdaQueryWrapper.eq(RoomAttrValue::getRoomId, roomSubmitVo.getId());
            roomAttrValueService.remove(labelVoLambdaQueryWrapper);

            // Delete facility information list
            LambdaQueryWrapper<RoomFacility> facilityVoLambdaQueryWrapper = new LambdaQueryWrapper<>();
            facilityVoLambdaQueryWrapper.eq(RoomFacility::getRoomId, roomSubmitVo.getId());
            roomFacilityService.remove(facilityVoLambdaQueryWrapper);

            // Delete label information list
            LambdaQueryWrapper<RoomLabel> roomLabelVoLambdaQueryWrapper = new LambdaQueryWrapper<>();
            roomLabelVoLambdaQueryWrapper.eq(RoomLabel::getRoomId, roomSubmitVo.getId());
            roomLabelService.remove(roomLabelVoLambdaQueryWrapper);

            // Delete payment method list
            LambdaQueryWrapper<RoomPaymentType> roomPaymentTypeLambdaQueryWrapper = new LambdaQueryWrapper<>();
            roomPaymentTypeLambdaQueryWrapper.eq(RoomPaymentType::getRoomId, roomSubmitVo.getId());
            roomPaymentTypeService.remove(roomPaymentTypeLambdaQueryWrapper);

            // Delete optional lease term list
            LambdaQueryWrapper<RoomLeaseTerm> roomLeaseTermLambdaQueryWrapper = new LambdaQueryWrapper<>();
            roomLeaseTermLambdaQueryWrapper.eq(RoomLeaseTerm::getRoomId, roomSubmitVo.getId());
            roomLeaseTermService.remove(roomLeaseTermLambdaQueryWrapper);

            // Also delete cache
            String key = RedisConstant.APP_ROOM_PREFIX + roomSubmitVo.getId();
            redisTemplate.delete(key);
        }

        // Update the picture list
        List<GraphVo> graphVoList = roomSubmitVo.getGraphVoList();
        if (graphVoList != null && !graphVoList.isEmpty()) {
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

        // Update the attribute information list
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

        // Update the list of tag information
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

        // Update the list of payment methods
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

        // Update the list of available lease terms
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
        // 1. Get basic Room information (RoomInfo)
        RoomInfo roomInfo = roomInfoMapper.selectById(id);

        // 2. Get additional VO information
        // 2.1 Get the apartment information (ApartmentInfo)
        ApartmentInfo apartmentInfo = apartmentInfoMapper.selectById(roomInfo.getApartmentId());

        // 2.2 Get image list (graphVoList)
        List<GraphVo> graphVo = graphInfoMapper.selectListByItemTypeAndId(ItemType.ROOM, id);

        // 2.3 Get attribute information list (attrValueVoList)
        List<AttrValueVo> attrValueVoList = attrValueMapper.selectListByRoomId(id);

        // 2.4 Get facility information list (facilityInfoList)
        List<FacilityInfo> facilityInfoList = facilityInfoMapper.selectListByRoomId(id);

        // 2.5 Get label information list (labelInfoList)
        List<LabelInfo> labelInfoList = labelInfoMapper.selectListByRoomId(id);

        // 2.6 Get payment method list (paymentTypeList)
        List<PaymentType> paymentTypeList = paymentTypeMapper.selectListByRoomId(id);

        // 2.7 Get optional lease term list (leaseTermList)
        List<LeaseTerm> leaseTermList = leaseTermMapper.selectListByRoomId(id);

        RoomDetailVo roomDetailVo = new RoomDetailVo();
        // Use BeanUtils to copy properties
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

    @Override
    public void removeRoomById(Long id) {
        // 1. Delete basic Room information (RoomInfo)
        super.removeById(id);

        // 2. Delete other VO information
        // 2.1 Delete room-lease term relations
        LambdaQueryWrapper<RoomLeaseTerm> roomLeaseTermLambdaQueryWrapper = new LambdaQueryWrapper<>();
        roomLeaseTermLambdaQueryWrapper.eq(RoomLeaseTerm::getRoomId, id);
        roomLeaseTermService.remove(roomLeaseTermLambdaQueryWrapper);

        // 2.2 Delete room-payment method relations
        LambdaQueryWrapper<RoomPaymentType> roomPaymentTypeLambdaQueryWrapper = new LambdaQueryWrapper<>();
        roomPaymentTypeLambdaQueryWrapper.eq(RoomPaymentType::getRoomId, id);
        roomPaymentTypeService.remove(roomPaymentTypeLambdaQueryWrapper);

        // 2.3 Delete room-attribute value relations
        LambdaQueryWrapper<RoomAttrValue> roomAttrValueLambdaQueryWrapper = new LambdaQueryWrapper<>();
        roomAttrValueLambdaQueryWrapper.eq(RoomAttrValue::getRoomId, id);
        roomAttrValueService.remove(roomAttrValueLambdaQueryWrapper);

        // 2.4 Delete room-label relations
        LambdaQueryWrapper<RoomLabel> roomLabelLambdaQueryWrapper = new LambdaQueryWrapper<>();
        roomLabelLambdaQueryWrapper.eq(RoomLabel::getRoomId, id);
        roomLabelService.remove(roomLabelLambdaQueryWrapper);

        // 2.5 Delete room-facility relations
        LambdaQueryWrapper<RoomFacility> roomFacilityLambdaQueryWrapper = new LambdaQueryWrapper<>();
        roomFacilityLambdaQueryWrapper.eq(RoomFacility::getRoomId, id);
        roomFacilityService.remove(roomFacilityLambdaQueryWrapper);

        // 2.6 Delete images of the room
        LambdaQueryWrapper<GraphInfo> graphInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        graphInfoLambdaQueryWrapper.eq(GraphInfo::getItemType, ItemType.ROOM).eq(GraphInfo::getItemId, id);
        graphInfoService.remove(graphInfoLambdaQueryWrapper);

        // Delete cache
        String key = RedisConstant.APP_ROOM_PREFIX + id;
        redisTemplate.delete(key);
    }
}





package com.nest.renting.web.app.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nest.renting.common.constant.RedisConstant;
import com.nest.renting.common.login.LoginUserHolder;
import com.nest.renting.model.entity.*;
import com.nest.renting.model.enums.ItemType;
import com.nest.renting.web.app.mapper.*;
import com.nest.renting.web.app.service.ApartmentInfoService;
import com.nest.renting.web.app.service.BrowsingHistoryService;
import com.nest.renting.web.app.service.RoomInfoService;
import com.nest.renting.web.app.vo.apartment.ApartmentItemVo;
import com.nest.renting.web.app.vo.attr.AttrValueVo;
import com.nest.renting.web.app.vo.fee.FeeValueVo;
import com.nest.renting.web.app.vo.graph.GraphVo;
import com.nest.renting.web.app.vo.room.RoomDetailVo;
import com.nest.renting.web.app.vo.room.RoomItemVo;
import com.nest.renting.web.app.vo.room.RoomQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * RoomInfoServiceImpl
 *
 * Service implementation for performing database operations
 * on the {@link RoomInfo} entity (room information table).
 * Provides functionality to query room lists, retrieve room details,
 * and apply caching and browsing history tracking.
 *
 * Author: Yuze Wang
 * Date: September 22, 2025
 */
@Service
@Slf4j
public class RoomInfoServiceImpl extends ServiceImpl<RoomInfoMapper, RoomInfo>
        implements RoomInfoService {

    @Autowired
    private RoomInfoMapper roomInfoMapper;
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
    private FeeValueMapper feeValueMapper;
    @Autowired
    private LeaseTermMapper leaseTermMapper;
    @Autowired
    private ApartmentInfoService apartmentInfoService;
    @Autowired
    private BrowsingHistoryService browsingHistoryService;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * Retrieve a paginated list of rooms based on query conditions.
     *
     * @param roomItemVoIPage pagination parameters (current page and page size)
     * @param queryVo query conditions for filtering room results
     * @return a paginated list of {@link RoomItemVo}
     */
    @Override
    public IPage<RoomItemVo> pageItem(IPage<RoomItemVo> roomItemVoIPage, RoomQueryVo queryVo) {
        return roomInfoMapper.pageItem(roomItemVoIPage, queryVo);
    }

    /**
     * Retrieve detailed room information by room ID.
     *
     * Steps:
     * <ul>
     *     <li>Check Redis cache first to avoid repeated DB queries.</li>
     *     <li>If cache miss, query multiple data sources: room info, images, attributes, facilities, labels, payment types, fees, lease terms, and apartment info.</li>
     *     <li>Assemble data into {@link RoomDetailVo} and store it in Redis with TTL of 10 minutes.</li>
     *     <li>Record the browsing history of the logged-in user.</li>
     * </ul>
     *
     * @param id the room ID
     * @return detailed room information as {@link RoomDetailVo}
     */
    @Override
    public RoomDetailVo getDetailById(Long id) {
        // Check Redis cache first
        String key = RedisConstant.APP_ROOM_PREFIX + id;
        RoomDetailVo roomDetailVo = (RoomDetailVo) redisTemplate.opsForValue().get(key);

        // If not found in Redis, query from database
        if (roomDetailVo == null) {
            // Basic room information
            RoomInfo roomInfo = roomInfoMapper.selectById(id);

            // Additional room-related details
            List<GraphVo> graphVoList = graphInfoMapper.selectListByItemTypeAndId(ItemType.ROOM, id);
            List<AttrValueVo> attrValueVoList = attrValueMapper.selectListByRoomId(id);
            List<FacilityInfo> facilityInfoList = facilityInfoMapper.selectListByRoomId(id);
            List<LabelInfo> labelInfoList = labelInfoMapper.selectListByRoomId(id);
            List<PaymentType> paymentTypeList = paymentTypeMapper.selectListByRoomId(id);
            List<FeeValueVo> feeValueVoList = feeValueMapper.selectListByApartmentId(roomInfo.getApartmentId());
            List<LeaseTerm> leaseTermList = leaseTermMapper.selectListByRoomId(id);
            ApartmentItemVo apartmentItemVo = apartmentInfoService.selectApartmentItemVoById(roomInfo.getApartmentId());

            // Assemble into VO
            roomDetailVo = new RoomDetailVo();
            BeanUtils.copyProperties(roomInfo, roomDetailVo);

            roomDetailVo.setGraphVoList(graphVoList);
            roomDetailVo.setAttrValueVoList(attrValueVoList);
            roomDetailVo.setFacilityInfoList(facilityInfoList);
            roomDetailVo.setLabelInfoList(labelInfoList);
            roomDetailVo.setPaymentTypeList(paymentTypeList);
            roomDetailVo.setFeeValueVoList(feeValueVoList);
            roomDetailVo.setLeaseTermList(leaseTermList);
            roomDetailVo.setApartmentItemVo(apartmentItemVo);

            // Cache in Redis (expire in 10 minutes)
            redisTemplate.opsForValue().set(key, roomDetailVo, 10L, TimeUnit.MINUTES);
        }

        // Save browsing history for the logged-in user
        browsingHistoryService.saveHistory(LoginUserHolder.getLoginUser().getUserId(), id);

        return roomDetailVo;
    }

    /**
     * Retrieve a paginated list of rooms under a specific apartment.
     *
     * @param roomItemVoIPage pagination parameters (current page and page size)
     * @param id the apartment ID
     * @return a paginated list of {@link RoomItemVo} belonging to the apartment
     */
    @Override
    public IPage<RoomItemVo> pageItemByApartmentId(IPage<RoomItemVo> roomItemVoIPage, Long id) {
        return roomInfoMapper.pageItemByApartmentId(roomItemVoIPage, id);
    }
}





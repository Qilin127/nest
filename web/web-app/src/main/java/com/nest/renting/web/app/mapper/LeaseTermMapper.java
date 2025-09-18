package com.nest.renting.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nest.renting.model.entity.LeaseTerm;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaseTermMapper extends BaseMapper<LeaseTerm> {
    LeaseTerm selectLeaseTermById(Long id);

    List<LeaseTerm> selectListByRoomId(Long id);
}





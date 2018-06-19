package com.hexun.pointQuartz.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.hexun.pointQuartz.entity.PointSend;

@Component
public interface PointSendMapper {
    int deleteByPrimaryKey(String id);

    int insert(PointSend record);

    int insertSelective(PointSend record);

    PointSend selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PointSend record);

    int updateByPrimaryKey(PointSend record);
    
    /**
     * 查询分享引入的用户并参加昨天的模拟活动的原分享人的id，统计数量
     * @return
     */
    List<Map<String,String>> selectShareList();
    /**
     * 查询昨日参加活动用户
     * @return
     */
    List<Map<String,String>> yesterdayLoginList();
}
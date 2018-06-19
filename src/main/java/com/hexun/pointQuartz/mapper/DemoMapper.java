package com.hexun.pointQuartz.mapper;

import com.hexun.pointQuartz.entity.Demo;
import org.springframework.stereotype.Component;

@Component
public interface DemoMapper {
    int deleteByPrimaryKey(String id);

    int insert(Demo record);

    int insertSelective(Demo record);

    Demo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Demo record);

    int updateByPrimaryKey(Demo record);
}
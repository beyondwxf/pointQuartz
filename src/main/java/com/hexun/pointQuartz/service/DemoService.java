package com.hexun.pointQuartz.service;

import com.hexun.pointQuartz.entity.Demo;

public interface DemoService {
    int deleteByPrimaryKey(String id);

    int insert(Demo record);

    int insertSelective(Demo record);

    Demo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Demo record);

    int updateByPrimaryKey(Demo record);
}

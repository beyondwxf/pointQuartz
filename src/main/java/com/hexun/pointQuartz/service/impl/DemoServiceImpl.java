package com.hexun.pointQuartz.service.impl;

import com.hexun.pointQuartz.entity.Demo;
import com.hexun.pointQuartz.mapper.DemoMapper;
import com.hexun.pointQuartz.service.DemoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DemoServiceImpl implements DemoService {

    @Resource
    private DemoMapper demoMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return demoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Demo record) {
        return demoMapper.insert(record);
    }

    @Override
    public int insertSelective(Demo record) {
        return demoMapper.insertSelective(record);
    }

    @Override
    public Demo selectByPrimaryKey(String id) {
        return demoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Demo record) {
        return demoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Demo record) {
        return demoMapper.updateByPrimaryKey(record);
    }
}

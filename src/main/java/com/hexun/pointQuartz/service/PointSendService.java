package com.hexun.pointQuartz.service;

import java.util.List;

import com.hexun.pointQuartz.entity.PointSend;

public interface PointSendService {
//	 int deleteByPrimaryKey(String id);

//	    int insert(PointSend record);

//	    int insertSelective(PointSend record);

	    PointSend selectByPrimaryKey(String id);

//	    int updateByPrimaryKeySelective(PointSend record);

	    int updateByPrimaryKey(PointSend record);
	    
	    int insertShareList();
	    
	    int insertYesterdayLoginList();
}

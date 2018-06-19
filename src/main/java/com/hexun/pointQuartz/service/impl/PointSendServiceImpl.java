package com.hexun.pointQuartz.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.hexun.framework.core.utils.StringUtils;
import com.hexun.pointQuartz.common.enums.PointTypeEnum;
import com.hexun.pointQuartz.entity.PointSend;
import com.hexun.pointQuartz.mapper.PointSendMapper;
import com.hexun.pointQuartz.service.PointSendService;

@Service
public class PointSendServiceImpl implements PointSendService {
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource
	private PointSendMapper pointSendMapper;
	
	@Resource
	private JdbcTemplate jdbcTemplate;

//	@Override
//	public int deleteByPrimaryKey(String id) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

//	@Override
//	public int insert(PointSend record) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

//	@Override
//	public int insertSelective(PointSend record) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	@Override
	public PointSend selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return pointSendMapper.selectByPrimaryKey(id);
	}

//	@Override
//	public int updateByPrimaryKeySelective(PointSend record) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	@Override
	public int updateByPrimaryKey(PointSend record) {
		// TODO Auto-generated method stub
		return pointSendMapper.updateByPrimaryKey(record);
	}

	/**
	 * 查询昨日分享数据，计算应该增加的数量插入定时发送表
	 */
	@Override
	public int insertShareList() {
		List<Map<String,String>> sharlList =  pointSendMapper.selectShareList();
		List<Object[]> params = new ArrayList<>();
		Object[] os = null;
	      for(Map<String,String> map : sharlList){
	    	  String count = map.get("count");
	    	  String userid = map.get("userid");
	    	  if(StringUtils.isNotBlank(count) && StringUtils.isNotBlank(userid)) {
	    		  if(Integer.parseInt(count)>0) {
	    			  os = new Object [9];
	    			  os[0]=UUID.randomUUID().toString().replaceAll("-","");
	    			  os[1]=userid;
	    			  if(Integer.parseInt(count)==1) {
	    				  os[2]=25000;
	    			  }else {
	    				  os[2]=50000;
	    			  }
	    			  os[3]=PointTypeEnum.BULL_MONEY.getCode();
	    			  os[4]="邀请分享获得";
	    			  os[5]="pointQuartz";
	    			  os[6]=new Date();
	    			  os[7]="pointQuartz";
	    			  os[8]="0";
	    			  log.info("邀请分享需要插入定时发送表的数据"+os.toString());
	    		  }
	    	  }
	           params.add(os);
	      }
	    if(params.size()>0) {
	    	try {
	    		long startTime = System.currentTimeMillis();
	    		String sql = "INSERT INTO `match_db`.`pointsend` (`id`, `useid`, `amount`, `pointtype`, `sendnote`, `source`, `creattime`, `founder`, `sendflag`) VALUES (?, ?, ?, ?,?, ?, ?, ?,?)";
			    jdbcTemplate.batchUpdate(sql, params);
			    log.info("邀请分享插入定时发送表的数据"+os.toString());
			    log.info(" ** 邀请分享批量插入完成,耗时：{}秒",(System.currentTimeMillis()-startTime)/1000);
			    return params.size();
			} catch (Exception e) {
				e.printStackTrace();
				log.info(e.getMessage());
				  log.info("邀请分享插入定时发送表的数据插入失败");
				return -1;
			}
	    }else {
	    	return 0;
	    }
	}

	/**
	 * 插入查询昨日参加活动用户
	 */
	@Override
	public int insertYesterdayLoginList() {
		List<Map<String,String>> yesterdayLoginList =  pointSendMapper.selectShareList();
		List<Object[]> params = new ArrayList<>();
		Object[] os = null;
		 for(Map<String,String> map : yesterdayLoginList){
			 String userid = map.get("hexun_id");
			 String mu_account_start_date = map.get("mu_account_start_date");
			 os = new Object [9];
			  os[0]=UUID.randomUUID().toString().replaceAll("-","");
			  os[1]=userid;
			  os[2]=10000;
			  os[3]=PointTypeEnum.BULL_MONEY.getCode();
			  os[4]="参加每日活动";
			  os[5]="pointQuartz";
			  os[6]=new Date();
			  os[7]="pointQuartz";
			  os[8]="0";
			  params.add(os);
			  log.info("参加每日活动需要插入定时发送表的数据"+os.toString());
		 }
		   if(params.size()>0) {
		    	try {
		    		long startTime = System.currentTimeMillis();
		    		String sql = "INSERT INTO `match_db`.`pointsend` (`id`, `useid`, `amount`, `pointtype`, `sendnote`, `source`, `creattime`, `founder`, `sendflag`) VALUES (?, ?, ?, ?,?, ?, ?, ?,?)";
				    jdbcTemplate.batchUpdate(sql, params);
				    log.info("参加每日活动插入定时发送表的数据"+os.toString());
				    log.info(" ** 参加每日活动批量插入完成,耗时：{}秒",(System.currentTimeMillis()-startTime)/1000);
				    return params.size();
				} catch (Exception e) {
					e.printStackTrace();
					log.info(e.getMessage());
					  log.info("参加每日活动插入定时发送表的数据插入失败");
					return -1;
				}
		    }else {
		    	return 0;
		    }
	}

}

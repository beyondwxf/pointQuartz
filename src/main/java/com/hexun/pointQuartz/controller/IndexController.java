package com.hexun.pointQuartz.controller;

import com.alibaba.fastjson.JSON;
import com.hexun.pointQuartz.config.Config;
import com.hexun.pointQuartz.entity.Demo;
import com.hexun.pointQuartz.service.DemoService;
//import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author zhoudong
 */
@Controller
public class IndexController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private DemoService demoService;
    @Autowired
    private Config config;

    /**
     * 根路径
     * @return
     */
    @GetMapping("")
    public @ResponseBody
    String home(){
        return "Start UP ..";
    }

    /**
     * 测试读取配置文件
     * @return
     */
    @GetMapping("/config")
    public @ResponseBody String config(){
        return "当前环境：" + config.getNowProfile();
    }

    /**
     * 页面测试
     * @return
     */
    @GetMapping("/index")
    public String index(ModelMap modelMap, @RequestParam String code){

        modelMap.put("code",code);
        modelMap.put("name","和讯");

        return "index";
    }

//    @PostMapping("/add")
//    @ApiOperation(value="保存数据测试")
//    public @ResponseBody Map<String,Object> add(@RequestBody Demo demo){
//        Map<String,Object> map = new HashMap<>();
//        log.info(" ** 接收到请求信息：{}", JSON.toJSONString(demo));
//        demo.setId(UUID.randomUUID().toString().replaceAll("-",""));
//        try {
//            demoService.insert(demo);
//            map.put("respCode","T");
//        }catch (Exception e){
//            map.put("respCode","T");
//            e.printStackTrace();
//        }
//        return map;
//    }
}

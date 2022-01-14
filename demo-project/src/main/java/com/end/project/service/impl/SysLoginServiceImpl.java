package com.end.project.service.impl;

import com.end.project.entity.ResultSet;
import com.end.project.service.SysLoginService;
import com.end.project.utils.CaptchaUtils;
import com.end.project.utils.CommonUtil;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * (SysLogin)表服务实现类
 *
 * @author makejava
 * @since 2021-12-03 14:45:55
 */

public class SysLoginServiceImpl {
//
//
//    @Resource
//    private RedisTemplate<String, String> redisTemplate;
//
//    @Resource
//    private  DefaultKaptcha captchaProducer;
//
//    @Override
//    public ResultSet login(Map<String, String> map) {
//        try {
//            String capText =  redisTemplate.opsForValue().get(map.get("uuid"));
//            if (StringUtils.equals(capText,map.get("uuid"))) {
//
//            }
//            return  ResultSet.success(HttpStatus.OK.value(),CommonUtil.getCurrTimeStamp());
//        } catch (Exception e) {
//            e.printStackTrace();
//            return  ResultSet.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage(), CommonUtil.getCurrTimeStamp());
//        }
//    }
//
//    @Override
//    public ResultSet getCaptCha(HttpServletRequest request, HttpServletResponse response) {
//        try {
//            Map<String,String> map = CaptchaUtils.validateCode(request,response,captchaProducer);
//            String uuid = CommonUtil.getUUID();
//            redisTemplate.opsForValue().set(CommonUtil.getUUID(), map.get("capText"),60, TimeUnit.SECONDS);
//            map.put("uuid",uuid);
//            return  ResultSet.success(HttpStatus.OK.value(), map,CommonUtil.getCurrTimeStamp());
//        } catch (IOException e) {
//            e.printStackTrace();
//            return  ResultSet.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage(), CommonUtil.getCurrTimeStamp());
//        }
//
//    }

}
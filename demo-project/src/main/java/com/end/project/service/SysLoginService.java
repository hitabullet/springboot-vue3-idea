package com.end.project.service;


import com.end.project.entity.ResultSet;
import com.google.code.kaptcha.impl.DefaultKaptcha;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * (SysLogin)表服务接口
 *
 * @author makejava
 * @since 2021-12-03 14:45:54
 */
public interface SysLoginService {

   ResultSet login(Map<String,String> map);


}
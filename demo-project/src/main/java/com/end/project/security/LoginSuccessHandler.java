package com.end.project.security;

import cn.hutool.json.JSONUtil;
import com.end.project.entity.ResultSet;
import com.end.project.utils.JWTUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author root
 * @version 1.0
 * @description: TODO
 * @date 2021/12/8 16:38
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

  @Resource private JWTUtils jwtUtils;

  @Override
  public void onAuthenticationSuccess(
      HttpServletRequest request, HttpServletResponse response, Authentication authentication)
      throws IOException, ServletException {
    response.setContentType("application/json;charset=utf-8");
    ServletOutputStream outputStream = response.getOutputStream();

    String jwt = jwtUtils.generateToken(authentication.getName());
    response.setHeader(jwtUtils.getHeader(), jwt);

    ResultSet resultSet = ResultSet.success(jwt);

    outputStream.write(JSONUtil.toJsonStr(resultSet).getBytes(StandardCharsets.UTF_8));

    outputStream.flush();
    outputStream.close();
  }
}

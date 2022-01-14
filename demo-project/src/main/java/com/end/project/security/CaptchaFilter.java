package com.end.project.security;

import com.end.project.common.exception.CaptchaException;
import com.end.project.common.exception.TokenException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author root
 * @version 1.0
 * @description: TODO
 * @date 2021/12/9 13:15
 */
@Component
public class CaptchaFilter extends OncePerRequestFilter {

    @Resource
    private RedisTemplate<String, CharSequence> redisTemplate;

    @Resource
    private  LoginFailureHandler loginFailureHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (StringUtils.equals(url,"/login") && StringUtils.equals(request.getMethod(),"POST")) {
          try{
              validate(request);
          } catch (CaptchaException  | TokenException e) {
              loginFailureHandler.onAuthenticationFailure(request,response,e);
          }
        }
        filterChain.doFilter(request,response);
    }

    private void validate(HttpServletRequest request) throws CaptchaException {
        String code = request.getParameter("code");
        String key = request.getParameter("uuid");
        if (StringUtils.isBlank(code) || StringUtils.isBlank(key)) {
            throw new CaptchaException("验证码错误");
        }
       String s = String.valueOf(redisTemplate.opsForValue().get(key));

        if (!StringUtils.equals(s,code)) {
            throw new CaptchaException("验证码错误");
        }

        redisTemplate.delete(key);
    }


}

package com.end.project.security;

import cn.hutool.core.util.StrUtil;
import com.end.project.common.exception.TokenException;
import com.end.project.utils.JWTUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

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
 * @date 2021/12/9 16:51
 */
public class JwtAuthenticationFilter extends BasicAuthenticationFilter
{
     @Resource
     private JWTUtils jwtUtils;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String jwt = request.getHeader(jwtUtils.getHeader());
        if (StrUtil.isBlankOrUndefined(jwt)) {
            chain.doFilter(request,response);
            return;
        }
        String requestURI = request.getRequestURI();

        if (!"/getCaptcha".equals(requestURI)) {
            Claims claims = jwtUtils.getClaimsByToken(jwt);

            if (claims == null) {
                throw new TokenException("token 异常");
            }

            if (jwtUtils.isTokenExpired(claims)) {
                throw new TokenException("token 已过期");
            }

            String username = claims.getSubject();

            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, null, null);

            SecurityContextHolder.getContext().setAuthentication(token);

        }
        chain.doFilter(request,response);


    }
}

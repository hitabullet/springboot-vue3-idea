package com.end.project.controller.sys;


import com.end.project.entity.ResultSet;
import com.end.project.service.SysUserService;
import com.end.project.utils.JWTUtils;
import io.jsonwebtoken.Claims;
import org.apache.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author zsh
 * @since 2021-12-07
 */
@RestController
@RequestMapping("/sys-user")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    @RequestMapping("/getMenuList")
    public ResultSet getMenuList(HttpServletRequest request){
        String jwt = request.getHeader("Authorization");

        return sysUserService.getMenuList(jwt);
    }

}

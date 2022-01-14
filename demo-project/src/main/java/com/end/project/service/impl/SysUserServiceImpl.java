package com.end.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.end.project.entity.ResultSet;
import com.end.project.entity.sys.SysMenu;
import com.end.project.entity.sys.SysUser;
import com.end.project.mapper.SysUserMapper;
import com.end.project.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.end.project.utils.CaptchaUtils;
import com.end.project.utils.CommonUtil;
import com.end.project.utils.JWTUtils;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import io.jsonwebtoken.Claims;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author zsh
 * @since 2021-12-07
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Resource
    private RedisTemplate<Object,Object> redisTemplate;

    @Resource
    private DefaultKaptcha captchaProducer;

    @Resource
    private SysUserMapper userMapper;

    @Override
    public ResultSet getCaptCha() {
        try {
            Map<String,String> map = CaptchaUtils.validateCode(captchaProducer);
            String uuid = CommonUtil.getUUID();
            redisTemplate.opsForValue().set(uuid, map.get("capText"),60, TimeUnit.SECONDS);
            map.put("uuid",uuid);
            return  ResultSet.success(map);
        } catch (IOException e) {
            e.printStackTrace();
            return  ResultSet.fail(e.getMessage());
        }
    }

    @Override
    public ResultSet queryAllUser() {
        try {
            return  ResultSet.success(userMapper.queryAllUser());
        } catch (Exception e) {
            e.printStackTrace();
            return  ResultSet.fail(e.getMessage());
        }
    }

    @Override
    public SysUser getByUsername(String username) {
        return getOne(new QueryWrapper<SysUser>().eq("username",username));
    }


    @Resource
    private JWTUtils jwtUtils;

    @Override
    public  ResultSet getMenuList(String jwt) {
        try {
            List<SysMenu> sysMenuList = userMapper.queryMenuList(jwtUtils.getClaimsByToken(jwt).getSubject());
            return  ResultSet.success(sysMenuList);
        } catch (Exception e) {
            e.printStackTrace();
            return  ResultSet.fail(e.getMessage());
        }
    }


}

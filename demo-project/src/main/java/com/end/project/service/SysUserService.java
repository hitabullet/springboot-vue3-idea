package com.end.project.service;

import com.end.project.entity.ResultSet;
import com.baomidou.mybatisplus.extension.service.IService;
import com.end.project.entity.sys.SysUser;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author zsh
 * @since 2021-12-07
 */
public interface SysUserService extends IService<SysUser> {
    ResultSet getCaptCha();

    ResultSet queryAllUser();

    SysUser getByUsername(String username);

    ResultSet getMenuList(String jwt);

}

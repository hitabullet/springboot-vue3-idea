package com.end.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.end.project.entity.sys.SysMenu;
import com.end.project.entity.sys.SysUser;

import java.util.List;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author zsh
 * @since 2021-12-07
 */

public interface SysUserMapper extends BaseMapper<SysUser> {

    List<SysUser> queryAllUser() throws Exception;

    List<SysMenu> queryMenuList(String username) throws  Exception;

}

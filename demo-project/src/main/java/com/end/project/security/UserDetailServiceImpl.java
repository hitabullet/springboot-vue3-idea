package com.end.project.security;

import com.end.project.entity.sys.SysUser;
import com.end.project.service.SysUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author root
 * @version 1.0
 * @description: TODO
 * @date 2021/12/10 9:34
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

     @Resource
     private SysUserService sysUserService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      SysUser sysUser =  sysUserService.getByUsername(username);
       if (sysUser == null) {
           throw new UsernameNotFoundException("用户名或密码错误");
       }

       return  new AccountUser(sysUser.getId(), sysUser.getUsername(), sysUser.getPassword(), getUserAuthority(sysUser.getId()));
    }

    /**
     * @description: 获取用户权限
     * @author root
     * @date  9:52
     * @version 1.0
     */
    private List<GrantedAuthority> getUserAuthority(Long userId) {
       return  null;
    }


}

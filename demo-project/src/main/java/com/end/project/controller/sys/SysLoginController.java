package com.end.project.controller.sys;

import com.end.project.entity.ResultSet;
import com.end.project.service.SysUserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (SysLogin)表控制层
 *
 * @author makejava
 * @since 2021-12-03 14:45:55
 */
@RestController
public class SysLoginController {

    @Resource
    private SysUserService sysUserService;

    @GetMapping("/getCaptcha")
    public ResultSet getCaptcha(){
        return sysUserService.getCaptCha();
    }

    @GetMapping("/queryAllUser")
    public ResultSet queryAllUser(){
        return sysUserService.queryAllUser();
    }


    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("getPassword")
    public ResultSet getPassword(){

        String encode = bCryptPasswordEncoder.encode("123456");

        boolean matches = bCryptPasswordEncoder.matches("123456",encode);

        System.out.println(matches);

        return ResultSet.success(encode);
    }



//    /**
//     * 服务对象
//     */
//    @Resource
//    private SysLoginService sysLoginService;
//

//
//    @Autowired
//    private DefaultKaptcha captchaProducer;
//
//    @GetMapping(value = {"/getCaptcha"})
//    public ResultSet loginValidateCode(HttpServletRequest request, HttpServletResponse response) throws Exception{
//       return sysLoginService.getCaptCha(request,response);
//    }

    /**
     * 检查验证码是否正确
     */
//    @RequestMapping("/checkLoginValidateCode")
//    @ResponseBody
//    public HashMap checkLoginValidateCode(HttpServletRequest request,@RequestParam("validateCode")String validateCode) {
//
//    }

}
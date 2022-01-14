package com.end.project.controller.conmon;

import com.end.project.entity.ResultSet;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author root
 * @version 1.0
 * @description: TODO
 * @date 2021/12/24 15:19
 */
@RestController("/common")
public class UploadController {

    @PostMapping("/upload")
    public ResultSet upload(HttpServletRequest request, HttpServletResponse response){

        return new ResultSet();
    }

}

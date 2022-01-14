package com.end.project.entity;

import com.end.project.utils.CommonUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultSet implements Serializable {
  private static final long serialVersionUID = 1905122041950251207L;

  private Integer code;

  private String msg;

  private Object data;

  private Long timer;

  public static ResultSet success(Object data) {
    ResultSet resultSet = new ResultSet();
    resultSet.setCode(HttpStatus.OK.value());
    resultSet.setTimer(CommonUtil.getCurrTimeStamp());
    resultSet.setData(data);
    return resultSet;
  }

  public static ResultSet success(Integer code, String msg, Object data, Long timer) {
    ResultSet resultSet = new ResultSet();
    resultSet.setCode(code);
    resultSet.setMsg(msg);
    resultSet.setData(data);
    resultSet.setTimer(timer);
    return resultSet;
  }

  public static ResultSet success(Integer code, Object data, Long timer) {
    ResultSet resultSet = new ResultSet();
    resultSet.setCode(code);
    resultSet.setData(data);
    resultSet.setTimer(timer);
    return resultSet;
  }

  public static ResultSet fail(String msg) {
    ResultSet resultSet = new ResultSet();
    resultSet.setCode(HttpStatus.BAD_REQUEST.value());
    resultSet.setMsg(msg);
    resultSet.setTimer(CommonUtil.getCurrTimeStamp());
    return resultSet;
  }

  public static ResultSet fail(Integer code, String msg, Long timer) {
    ResultSet resultSet = new ResultSet();
    resultSet.setCode(code);
    resultSet.setMsg(msg);
    resultSet.setTimer(timer);
    return resultSet;
  }
}

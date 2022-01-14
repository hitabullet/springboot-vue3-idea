package com.end.project;

import com.baomidou.mybatisplus.extension.api.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.regex.MatchResult;

/**
 * @author root
 * @version 1.0
 * @description: TODO
 * @date 2021/12/17 15:54
 */
public class Main {


  public  static void main(String[] args) {

      List<Object> list = new ArrayList<>();

    for (int i = 0; i < 11; i++){
        list.add(i);

    }
    System.out.println(list);
  }



}

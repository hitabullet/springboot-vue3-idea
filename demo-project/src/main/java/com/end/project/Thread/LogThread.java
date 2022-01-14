package com.end.project.Thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author root
 * @version 1.0
 * @description: TODO
 * @date 2022/1/12 14:26
 */
@Slf4j
public class LogThread {
  public static void main(String[] args) {
      Thread thread = new Thread() {
          @Override
          public void run() {
              log.debug("running");
          }
      };

      thread.start();
      log.debug("running");

  }
}

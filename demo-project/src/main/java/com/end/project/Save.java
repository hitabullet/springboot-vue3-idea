package com.end.project;

/**
 * @author root
 * @version 1.0
 * @description: TODO
 * @date 2021/12/17 16:27
 */
public class Save implements Runnable{
    private Integer num;


    public Save(Integer num) {
        super();
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 0; i < 90; i++) {
            num++;
            System.out.println(Thread.currentThread().getName()+"余额是："+num);
        }
    }
}

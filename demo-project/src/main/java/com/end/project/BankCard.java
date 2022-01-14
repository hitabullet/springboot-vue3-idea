package com.end.project;

/**
 * @author root
 * @version 1.0
 * @description: TODO
 * @date 2021/12/17 16:48
 */
public class BankCard {
    private int balance;//余额
    public BankCard(int balance) {
        super();
        this.balance = balance;
    }
    public BankCard(){

    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    public int getBalance(){
        return balance;
    }
}

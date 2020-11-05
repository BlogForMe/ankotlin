package com.john.kot.pattern.chain.java;

public class Director extends  Leader {
    @Override
    protected void handle(int money) {
        System.out.println("主管批负保修 " + money + '元');
    }

    @Override
    protected int limit() {
        return 5000;
    }
}

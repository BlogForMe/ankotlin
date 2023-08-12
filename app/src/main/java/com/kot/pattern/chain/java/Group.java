package com.kot.pattern.chain.java;

public class Group extends  Leader {
    @Override
    protected void handle(int money) {
        System.out.println("组长批负保修 " + money + '元');
    }

    @Override
    protected int limit() {
        return 1000;
    }
}

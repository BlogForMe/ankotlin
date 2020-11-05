package com.john.kot.pattern.chain.java;

public class Boss extends  Leader {
    @Override
    protected void handle(int money) {
        System.out.println("老板批负保修 " + money + '元');
    }

    @Override
    protected int limit() {
        return Integer.MAX_VALUE;
    }
}

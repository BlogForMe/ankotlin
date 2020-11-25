package com.john.kot.pattern.chain.java;

public abstract class Leader {
    protected  Leader nextHandler;

    public  final  void  handleRequest(int money){
        if (money <= limit()){
            handle(money);
        }else {
            System.out.println( getClass().getSimpleName() + " 无法批复杂 交给上级 ");

            if (null!= nextHandler)
                nextHandler.handleRequest(money);
        }
    }

    protected abstract void handle(int money);

    protected abstract int limit();
}

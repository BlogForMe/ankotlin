package com.john.kot.pattern.chain.java;

public abstract class Leader {
    protected  Leader nextHandler;

    public  final  void  handleRequest(int money){
        if (money <= limit()){
            handle(money);
        }else {
            if (null!= nextHandler)
                nextHandler.handleRequest(money);
        }
    }

    protected abstract void handle(int money);

    protected abstract int limit();
}

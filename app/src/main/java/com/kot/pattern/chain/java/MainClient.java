package com.kot.pattern.chain.java;

public class MainClient {
    public static void main(String[] args) {
        Group group = new Group();
        Director director = new Director();
        Manager manager = new Manager();
        Boss boss= new Boss();

        group.nextHandler = director;
        director.nextHandler = manager;
        manager.nextHandler = boss;

        //发起报账
        group.handleRequest(50000);
    }
}

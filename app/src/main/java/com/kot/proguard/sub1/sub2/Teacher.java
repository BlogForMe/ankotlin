package com.kot.proguard.sub1.sub2;

public class Teacher {
    @Override
    public void doSomething() {
        System.out.println("teaching ...");
    }

    @MethodLevel(value = 1)
    private void waking() {

    }

//    作者：萌娃瑜宝爸比
//    链接：https://juejin.cn/post/7104539442739838983
//    来源：稀土掘金
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}

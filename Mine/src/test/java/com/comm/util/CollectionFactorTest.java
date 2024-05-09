package com.comm.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * ClassName:      CollectionTest
 * Description:    Description
 * Author:         zh
 * CreateDate:     24/04/2024 17:25
 * UpdateUser:     zh
 * UpdateRemark:   Modify the description
 */
public class CollectionFactorTest {

    @Test
    public void testff() {
        List<String> list = new ArrayList<>();
        list.add("令狐冲");
        list.add("风清扬");
        list.add("任我行");

        //获取迭代器对象
        Iterator<String> it = list.iterator();
        //使用迭代器遍历
        while (it.hasNext()) {
            String ele = it.next();
            System.out.println(ele);
        }

        List<String> Linkedlist = new LinkedList<>();
        Linkedlist.add("令狐冲");
        Linkedlist.add("风清扬");
        Linkedlist.add("任我行");

        //获取迭代器对象
        Iterator<String> itLinked = Linkedlist.iterator();
        //使用迭代器遍历
        while (itLinked.hasNext()) {
            String ele = itLinked.next();
            System.out.println(ele);
        }
    }
}

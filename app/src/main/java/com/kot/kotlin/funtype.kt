package com.kot.kotlin

fun main() {

    val a: Int
    val b: String

    val d: (String, Int) -> Unit // 函数类型 (String,Int) 接收参数 ，  Unit 返回类型


    fun plus(num1: Int, num2: Int): Int {
        return num1 + num2
    }

    fun minus(num1: Int, num2: Int): Int {
        return num1 + num2
    }


    val num1 = 10
    val num2 = 20

    fun num1AndNum2(num1: Int, num2: Int, operations: (Int, Int) -> Int): Int {
        return operations(num1, num2)
    }

    // 1
//    val result1 = num1AndNum2(num1, num2, ::plus)
//    val result2 = num1AndNum2(num1, num2, ::minus)


    //2 匿名函数
//    val result2 = num1AndNum2(num1, num2, fun minus(num1: Int, num2: Int): Int {
//        return num1 + num2
//    })

//    val result2 = num1AndNum2(num1, num2, fun (num1: Int, num2: Int): Int {
//        return num1 + num2
//    })


    // 3  传一个lambda最后一个参数， lambda最后一个参数 可以放在括号外面
//    val result1 = num1AndNum2(num1, num2,{ a:Int,b:Int -> a+b})
//    val result1 = num1AndNum2(num1, num2){ a:Int,b:Int -> a+b}
    val result1 = num1AndNum2(num1, num2){ a,b -> a+b}  //类型推导机制

        println(result1)
//    println(result2)


}


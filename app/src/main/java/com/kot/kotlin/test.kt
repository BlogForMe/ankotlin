package com.kot.kotlin

fun main() {

    val list = listOf("apple", "pear", "banana", "watermelon")

//    val result = list.maxBy { it.length }

    val lambda = { fruit: String ->
        fruit.length
    }




    //推导1
//    val result = list.maxBy(lambda)

    //推导2
//    val result = list.maxBy({fruit:String->
//        fruit.length
//    })


    //推导3
//    val result = list.maxBy({ fruit: String ->
//        fruit.length
//    })           //如果一个函数， 他接收的最后一个参数是lambda表达式，那么这最后一个参数可以移到括号外面

    //推导4
//    val result = list.maxBy{ fruit: String ->
//        fruit.length         //如果一个函数 ,括号可以省略
//    }

    //推导4
//    val result = list.maxBy{ fruit ->
//        fruit.length         //kotlin类型推导机制，参数类型可以省略
//    }

    //推导5
//    val result = list.maxBy{
//        it.length         // lmbda表达式只有一个参数，参数可以省略 改用it替代
//    }
//
//    println(result)




//    val clickLambda = {btListener:ButtonClickListener->{}}
    val clickLambda = object : com.kot.kotlin.ButtonClickListener {
        override fun onClick() {
            println("button is clicked")
        }
    }

//    val button = Button().setOnClickListener{
//        println("button is clicked")
//    }
    val button = com.kot.kotlin.Button().setOnClickListener(clickLambda)




//    val result = list.findMax(lambda)
    val result = list.findMax{it.length}

    println(result)
}

fun <T,R:Comparable<R>> List<T>.findMax(block: (T) -> R):T?{
    if (isEmpty()) return null
    var maxElement =get(0) //获取List上下文的 第一个元素
    var maxValue = block(maxElement) //block() 走到了 lambda方法中
    for(element in this){
        var value = block(element)
        if (value> maxValue){
            maxElement = element
            maxValue = value
        }
    }
    return maxElement

}






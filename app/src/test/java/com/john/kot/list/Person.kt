package com.john.kot.list

//open class Animal {
//    var name: String? = null
//
//    init {
//        println("heh")
//    }
//}

class Person {
    var age: Int? = null
    var title: String? = null

    init {
        println("init func")
    }

    constructor(age: Int?, title: String?)  {
        this.age = age
        this.title = title
    }
}
package com.john.ankotlin

class  Client(val name: String,val postalCode: Int){
    override  fun toString()="Client(name=$name, postalCode = $postalCode)"
}

fun main() {
//    val client1  = Client("ALICE",342562)
//    val client2  = Client("ALICE",342562)
//    println(client1==client2)
    val s1 ="ffm"
    val s2 ="ffm"
    println(s1==s2)
}
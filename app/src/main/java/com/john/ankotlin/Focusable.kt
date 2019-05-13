package com.john.ankotlin

interface  Focusable{
    fun  setFocus(b:Boolean){
        println("I $b")
    }
    fun showOff()= println("I m Focusable")
}
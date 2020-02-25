package com.comm.util

class MessageEvent {
    var type: Int = 0
    var position: Int = 0
    var message: String = ""

    constructor(type:Int){
        this.type = type
    }

    constructor(type: Int, position: Int, message: String) {
        this.type = type
        this.position = position
        this.message = message
    }


}


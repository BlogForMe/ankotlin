package com.john.kot.util

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


/**
 * @author xiaofei_dev
 * @desc <p>读写 SP 存储项的轻量级委托类，如下，
 * 读 SP 的操作委托给该类对象的 getValue 方法，
 * 写 SP 操作委托给该类对象的 setValue 方法，
 * 注意这两个方法不用你显式调用，把一切交给编译器就行（还是语法糖）
 * 具体使用此类定义 SP 存储项的代码请参考 SpBase 文件</p>
 */

/**
 * @author xiaofei_dev
 * @desc 定义的 SP 存储项
 */
object SpBase{
    //SP 存储项的键
    private const val CONTENT_SOMETHING = "CONTENT_SOMETHING"


    // 这就定义了一个 SP 存储项
    // 把 SP 的读写操作委托给 SPDelegates 类的一个实例（使用 by 关键字，by 是 Kotlin 语言层面的一个原语），
    // 此时访问 SpBase 的 contentSomething (你可以简单把其看成 Java 里的一个静态变量)属性即是在读取 SP 的存储项，
    // 给 contentSomething 属性赋值即是写 SP 的操作，就这么简单
    // 这里用到的 SPDelegates 对象的 getValue 方法的 thisRef（见上文） 参数的类型正是外层的 SpBase
    var contentSomething: String by SPDelegates(CONTENT_SOMETHING, "我是一个 SP 存储项，点击编辑我")
}



class SPDelegates<T>(private val key: String, private val default: T) : ReadWriteProperty<Any?, T> {
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return SpUtil.getValue(key, default)
    }
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        SpUtil.putValue(key, value)
    }
}
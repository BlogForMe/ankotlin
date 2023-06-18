package com.john.kot.list

import org.junit.Test

class ListFilter {
    @Test
    fun listFilterList() {
//        var people: List<Person> = listOf(
//            Person("Adam Asshat", "dontinviteme", 21),
//            Person("Bob Bowyer", "bob", 37),
//            Person("Emily Eden", "emily", 22)
//        )
//        var invitedList = listOf("bob", "emily")
//
//        var pList = people.filter { p -> invitedList.any { it == p.nickname } }
//
//        var nList = people.filter { invitedList.contains(it.nickname) }
//        println(nList)

        val listOf = listOf(1, 2, 3)
        val list = (listOf.takeIf { it.size > 5 }?.subList(0, 5) ?: listOf)
        println(list)
//        println(listOf.subList(1,6))


    }
}
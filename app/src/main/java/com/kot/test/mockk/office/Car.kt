/**
 *
 * ClassName:      Car
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/9/8 11:46 AM
 * UpdateUser:     zh
 * UpdateDate:     2021/9/8 11:46 AM
 * UpdateRemark:   Modify the description
 */

package com.kot.test.mockk.office

class Car {
    fun drive(direction: Direction): Outcome {
        return Outcome.OK
    }

    fun recordTelemetry(speed: Double, direction: Direction, lat: Double=0.0, long: Double=0.0):Outcome {
        return Outcome.OK;
    }

    fun recordTelemetry(speed: List<Double>, direction: Direction, lat: Double=0.0, long: Double=0.0):Outcome {
        return Outcome.OK;
    }

    fun door(doorType: DoorType):Car{
        return this
    }

    fun windowState():WindowState{
        return WindowState.BOTTOM
    }

    fun accelerate(fromSpeed: Int, toSpeed: Int) {

    }

    fun drive() = accelerate()

    private fun accelerate() = "going faster"
}

enum class Direction {
    NORTH, SOUTH, EAST, WEST
}



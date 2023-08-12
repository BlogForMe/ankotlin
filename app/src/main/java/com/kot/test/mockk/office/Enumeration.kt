/**
 *
 * ClassName:      Enumeration
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/9/8 5:02 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/9/8 5:02 PM
 * UpdateRemark:   Modify the description
 */

package com.kot.test.mockk.office

enum class Enumeration(val goodInt: Int) {
    CONSTANT(35),
    OTHER_CONSTANT(45);
}

enum class DoorType{
    FRONT_LEFT,DOOR_RIGHT
}

enum class WindowState{
    UP,BOTTOM
}

enum class Outcome{
    RECORDED,OK
}
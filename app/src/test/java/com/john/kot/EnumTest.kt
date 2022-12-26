package com.john.kot

import androidx.lifecycle.Lifecycle.*
import org.junit.Test

/**
 *
 * ClassName:      EnumTest
 * Description:    Description
 * Author:         zh
 * CreateDate:     2022/12/11
 * UpdateUser:     zh
 * UpdateDate:     2022/12/11
 * UpdateRemark:   Modify the description
 */

class EnumTest {
    @Test
    fun compareTest(){
//        println("DESTROYED "+  State.DESTROYED.isAtLeast(State.STARTED))
//        println("INITIALIZED "+  State.INITIALIZED.isAtLeast(State.STARTED))
//        println("CREATED "+  State.CREATED.isAtLeast(State.STARTED))
//        println("STARTED "+  State.STARTED.isAtLeast(State.STARTED))
//        println("RESUMED "+  State.RESUMED.isAtLeast(State.STARTED))

        println("DESTROYED "+  State.DESTROYED.isAtLeast(State.INITIALIZED))
        println("DESTROYED "+  State.CREATED.isAtLeast(State.INITIALIZED))
        println("DESTROYED "+  State.STARTED.isAtLeast(State.INITIALIZED))
        println("DESTROYED "+  State.RESUMED.isAtLeast(State.INITIALIZED))
        println("DESTROYED "+  State.INITIALIZED.isAtLeast(State.INITIALIZED))

    }

}

//enum class State {
//    /**
//     * Destroyed state for a LifecycleOwner. After this event, this Lifecycle will not dispatch
//     * any more events. For instance, for an [android.app.Activity], this state is reached
//     * **right before** Activity's [onDestroy][android.app.Activity.onDestroy] call.
//     */
//    DESTROYED,
//
//    /**
//     * Initialized state for a LifecycleOwner. For an [android.app.Activity], this is
//     * the state when it is constructed but has not received
//     * [onCreate][android.app.Activity.onCreate] yet.
//     */
//    INITIALIZED,
//
//    /**
//     * Created state for a LifecycleOwner. For an [android.app.Activity], this state
//     * is reached in two cases:
//     *
//     *  * after [onCreate][android.app.Activity.onCreate] call;
//     *  * **right before** [onStop][android.app.Activity.onStop] call.
//     *
//     */
//    CREATED,
//
//    /**
//     * Started state for a LifecycleOwner. For an [android.app.Activity], this state
//     * is reached in two cases:
//     *
//     *  * after [onStart][android.app.Activity.onStart] call;
//     *  * **right before** [onPause][android.app.Activity.onPause] call.
//     *
//     */
//    STARTED,
//
//    /**
//     * Resumed state for a LifecycleOwner. For an [android.app.Activity], this state
//     * is reached after [onResume][android.app.Activity.onResume] is called.
//     */
//    RESUMED;
//
//    /**
//     * Compares if this State is greater or equal to the given `state`.
//     *
//     * @param state State to compare with
//     * @return true if this State is greater or equal to the given `state`
//     */
//    fun isAtLeast(state: State): Boolean {
//        return compareTo(state) >= 0
//    }
//}
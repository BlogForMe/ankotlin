package com.kot.compose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.kot.compose.model.LayoutStudy

/**
 *
 * ClassName:      ComponentActivity01
 * Description:    Description
 * Author:         zh
 * CreateDate:     8/20/23 21:19
 * UpdateUser:     zh
 * UpdateDate:     8/20/23 21:19
 * UpdateRemark:   Modify the description
 */

class ComponentActivity01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            PhotographerCard()
            LayoutStudy()
        }

    }
}

package com.john.kot.activity.activityresult

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.john.kot.R

/**
 * Created by A on 2018/3/20.
 */

class ResultOkFragment : Fragment(R.layout.fragment_ok) {


    companion object {
        fun newInstance() = ResultOkFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<android.widget.Button>(R.id.bt_fragment).setOnClickListener {
            val intent = Intent(context, SecondResultActivity::class.java)
            intentLauncher.launch(intent)
        }
    }

    private val intentLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
//        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data?.getStringExtra(SecondResultActivity.sData)
            Log.i("ResultOkFragment", "$data ")
//        }
        }

}

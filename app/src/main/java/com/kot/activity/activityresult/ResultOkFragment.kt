package com.kot.activity.activityresult

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import com.android.util.base.BaseFragment
import com.kot.R
import com.kot.mvvm.demo.UserDemo

/**
 * Created by A on 2018/3/20.
 */

class ResultOkFragment : BaseFragment(R.layout.fragment_ok) {


    companion object {
        fun newInstance() = ResultOkFragment()
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button = view.findViewById(R.id.bt_fragment)
        view.findViewById<Button>(R.id.bt_fragment).setOnClickListener {
            val intent = Intent(context, SecondResultActivity::class.java)
            intentLauncher.launch(intent)
        }
    }

    private var button: Button? = null

    private val intentLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
//        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data?.getSerializableExtra(SecondResultActivity.sData)
            Log.i("ResultOkFragment", "$data ")
            val userDemo = data as ArrayList<UserDemo>
            button?.text = userDemo[0].name

//        }
        }


}

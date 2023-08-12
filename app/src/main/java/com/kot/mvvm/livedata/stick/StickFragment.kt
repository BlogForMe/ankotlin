package com.kot.mvvm.livedata.stick

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.john.kot.R

/**
 *
 * ClassName:      StickFragment
 * Description:    Description
 * Author:         zh
 * CreateDate:     2022/8/17 7:18 AM
 * UpdateUser:     zh
 * UpdateDate:     2022/8/17 7:18 AM
 * UpdateRemark:   Modify the description
 */

private const val TAG = "StickFragment"

class StickFragment : Fragment() {
    companion object {
        fun newInstance() = StickFragment()
    }

    private lateinit var messageContent: View
    private lateinit var viewModel: StickViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        messageContent = view.findViewById(R.id.message_content)

        viewModel = ViewModelProvider(this)[StickViewModel::class.java]
        Log.i(TAG, "onViewCreated: $viewModel")
        val text1 = "初始文字被改变"
        val message = requireView().findViewById<TextView>(R.id.message)
        messageContent.visibility = View.VISIBLE
        message.setOnClickListener {
//            未使用LiveData
//            message.text = text1
//            message.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
            //使用LiveData
            Log.i(TAG, "onViewCreated: ")
            viewModel.textLiveData.value = text1
        }
        //使用LiveData
        viewModel.textLiveData.observe(viewLifecycleOwner,object :Observer<String>{
            override fun onChanged(t: String?) {
                message.text = t
                message.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
            }
        })

//        viewModel.textLiveData.observe(viewLifecycleOwner) {
//            message.text = it
//            message.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
//        }
    }
}

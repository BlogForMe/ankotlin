package com.john.kot.mvvm.dongnao.viewmodel

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.android.util.viewbind.viewBinding
import com.john.kot.R
import com.john.kot.databinding.FragmentViewModelBinding


class ViewModelFragment : Fragment(R.layout.fragment_view_model) {
    val TAG = "ViewModelFragment"

    val binding by viewBinding<FragmentViewModelBinding>()
    val viewModel by activityViewModels<ShareViewModel>()

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.fragment_view_model, container, false)
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btNumber.setOnClickListener {
            Log.i(TAG, "onViewCreated: ${viewModel.number} ")
            binding.myTextView.mText = "测试"
        }

        val transferMain: ViewGroup = view.findViewById(R.id.transfer_main)
        transferMain.visibility = View.INVISIBLE

    }


}
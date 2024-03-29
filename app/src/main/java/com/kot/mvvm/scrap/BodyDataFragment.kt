package com.kot.mvvm.scrap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kot.R
import timber.log.Timber

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BodyDataFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BodyDataFragment : Fragment() {
    private var mBodyDataModel: BodyDataModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

//        val binding: FragmentBodyDataBinding = DataBindingUtil.inflate(
//            inflater,
//            R.layout.fragment_body_data, container, false
//        )
        mBodyDataModel = ViewModelProvider(requireActivity()).get(BodyDataModel::class.java)
//        binding.vmBodyFragment = mBodyDataModel
//        binding.lifecycleOwner = this.viewLifecycleOwner
        return inflater.inflate(R.layout.fragment_body_data, null)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mBodyDataModel?.activityTime?.observe(requireActivity(),
            Observer{ Timber.i("activityTime $it") })

//        tv_sport_title.setOnClickListener {
////            mBodyDataModel?.activityTime?.value = 28
//            Timber.i("mBodyDataModel.activityTime.value ${mBodyDataModel?.activityTime?.value}")
//        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BodyDataFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            BodyDataFragment()
    }
}

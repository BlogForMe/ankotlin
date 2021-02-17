package com.john.kot.mvvm.fragment


/**
 * mvvm应用
 */
//class MvvmFragment : BaseFragment() {
//
//    companion object {
//        fun newInstance() = MvvmFragment()
//    }
//
//    private var mvvmViewModel: MvvmViewModel? = null
//
//
//    override fun initViewModel() {
//        mvvmViewModel = getFragmentViewModel(MvvmViewModel::class.java)
//    }
//
//    override fun getDataBindingConfig(): DataBindingConfig {
//        return DataBindingConfig(R.layout.fragment_mvvm, mvvmViewModel)
//    }
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//        var num = 1
//        bt_show.setOnClickListener {
//            mvvmViewModel?.numData?.value = num++
//        }
//    }
//}
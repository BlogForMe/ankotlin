package com.android.util.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.util.R
import timber.log.Timber

/**
 * @author : John
 * @date : 2018/7/15
 */
abstract class BaseActivity : AppCompatActivity() {
    private val TAG = javaClass.simpleName
    private var mToolBarTitle: TextView? = null
//    protected var mBinding: ViewDataBinding? = null

    private var mActivityProvider: ViewModelProvider? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViewModel()

        val dataBindingConfig: DataBindingConfig = getDataBindingConfig()

//        var binding: ViewDataBinding = DataBindingUtil.setContentView(this,dataBindingConfig.layout)
//        binding.lifecycleOwner=this
//        binding.setVariable(BR.viewModel, dataBindingConfig.stateViewModel)
//        var bindParam = dataBindingConfig.bindingParams
//        for (i in 0 until bindParam.size()){
//            binding.setVariable(bindParam.keyAt(i),bindParam.valueAt(i))
//        }
//        mBinding = binding

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_NOSENSOR
        var mToolbar: Toolbar? = findViewById(R.id.toolbar)
        mToolbar?.let {
            setSupportActionBar(it)
        }
        mToolBarTitle = findViewById(R.id.tv_title)
        val mActionBar = supportActionBar
        //设置默认标题不显示
        if (mToolBarTitle != null && mActionBar != null) {
            mActionBar.setDisplayShowTitleEnabled(false)
        }
        if (mActionBar != null) {
            if (mToolbar != null && isShowBack) {
                mActionBar.setDisplayHomeAsUpEnabled(true) //是否显示返回
            } else {
                mActionBar.setDisplayHomeAsUpEnabled(false)
            }
        }
    }


    abstract fun initViewModel()
    protected abstract fun getDataBindingConfig(): DataBindingConfig

    /**
     * 导航栏是否显示后退按钮
     *
     * @return
     */
    protected val isShowBack: Boolean
        protected get() = true

    protected fun setToolBarTitle(title: CharSequence?) {
        if (mToolBarTitle != null && title != null) {
            mToolBarTitle!!.text = title
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }


    protected fun <T : ViewModel> getActivityViewModel(modelClass: Class<T>): T {
        if (mActivityProvider == null)
            mActivityProvider = ViewModelProvider(this)
        return mActivityProvider!!.get(modelClass)
    }


    override fun onStart() {
        super.onStart()
        Timber.tag(TAG).i("onStart()")
    }

    companion object {
        const val PARAMS_01 = "PARAMS_01"
        const val PARAMS_02 = "PARAMS_02"
        const val PARAMS_03 = "PARAMS_03"
    }
}
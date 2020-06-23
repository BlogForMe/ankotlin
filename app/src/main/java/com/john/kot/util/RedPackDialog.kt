package com.john.kot.util

import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.john.kot.R

const val TAG_RED_FRAGMENT = "RedPackDialog"

class RedPackDialog : DialogFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setStyle(STYLE_NO_FRAME, R.style.PauseDialog)
    }

    override fun onStart() {
        super.onStart()
        val window = dialog?.window
        val layoutParams = window?.attributes
        layoutParams?.gravity = Gravity.CENTER; //居中显示
//        layoutParams?.x = 300
        window?.setWindowAnimations(R.style.DialogAnimation)
        window?.attributes = layoutParams
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_red_pack, container)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        hideBar()
    }

    companion object {
        fun newIntance(like: Int): RedPackDialog {
            val bundle = Bundle()
            bundle.putInt(TAG_RED_FRAGMENT, like)
            val showHide = RedPackDialog()
            showHide.arguments = bundle
            return showHide
        }
    }

    //    private void hideSystemUI() {
    //        // Enables regular immersive mode.
    //        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
    //        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
    //        View decorView = getWindow().getDecorView();
    //        decorView.setSystemUiVisibility(
    //
    //                        // Set the content to appear under the system bars so that the
    //                        // content doesn't resize when the system bars hide and show.
    //                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    //                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
    //                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    //                        // Hide the nav bar and status bar
    //                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
    //                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    //    }
    private fun hideBar() {
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
            val v: View? = activity?.window?.getDecorView()
            v?.systemUiVisibility = View.GONE
        } else if (Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            val decorView: View? = activity?.window?.getDecorView()
            val uiOptions = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_FULLSCREEN)
            decorView?.systemUiVisibility = uiOptions
        }
    }
}
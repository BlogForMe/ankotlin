package com.kot.ui

import android.app.Dialog
import android.content.res.Resources
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.android.util.window.util.dp
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.kot.R
import com.kot.databinding.PaymentLayoutBottomSheetBinding

/**
 *
 * ClassName:      BottomSheetReview
 * Description:    Description
 * Author:         zh
 * CreateDate:     07/04/2024
 * UpdateUser:     zh
 * UpdateDate:     07/04/2024
 * UpdateRemark:   Modify the description
 */


class BottomSheetReview : BottomSheetDialogFragment() {


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setStyle(
//            BottomSheetDialogFragment.STYLE_NORMAL,
//            R.style.CustomBottomSheetDialogTheme
//        )
//    }
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        (view?.parent as? ViewGroup)?.setBackgroundColor(Color.TRANSPARENT)
//    }


    override fun onStart() {
        super.onStart()
        dialog?.window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val bottomSheet = super.onCreateDialog(savedInstanceState)

        val bi = PaymentLayoutBottomSheetBinding.inflate(LayoutInflater.from(context))
        bottomSheet.setContentView(bi.root)
        val bottomSheetBehavior = BottomSheetBehavior.from(bi.root.parent as View)
        bottomSheetBehavior.peekHeight = 200.dp
        bi.extraSpace.setMinimumHeight(screenHeight / 3)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        bottomSheetBehavior.isHideable = false

        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(view: View, i: Int) {
                if (BottomSheetBehavior.STATE_EXPANDED == i) {
                    showView(bi.appBarLayout, getActionBarSize())
                    hideAppBar(bi.profileLayout)
                }
                if (BottomSheetBehavior.STATE_COLLAPSED == i) {
                    hideAppBar(bi.appBarLayout)
                    showView(bi.profileLayout, getActionBarSize())
                }
                if (BottomSheetBehavior.STATE_HIDDEN == i) {
                    dismiss()
                }
            }

            override fun onSlide(view: View, v: Float) {}
        })
//        bi.cancelBtn.setOnClickListener(View.OnClickListener { dismiss() })
//        bi.editBtn.setOnClickListener(View.OnClickListener {
//            Toast.makeText(
//                context,
//                "Edit button clicked",
//                Toast.LENGTH_SHORT
//            ).show()
//        })
//        bi.moreBtn.setOnClickListener(View.OnClickListener {
//            Toast.makeText(
//                context,
//                "More button clicked",
//                Toast.LENGTH_SHORT
//            ).show()
//        })
//        hideAppBar(bi.appBarLayout)

        return bottomSheet
    }


    private fun hideAppBar(view: View) {
        val params = view.layoutParams
        params.height = 0
        view.setLayoutParams(params)
    }

    private fun showView(view: View, size: Int) {
        val params = view.layoutParams
        params.height = size
        view.setLayoutParams(params)
    }

    private fun getActionBarSize(): Int {
//        val styledAttributes =
//            context!!.theme.obtainStyledAttributes(intArrayOf(R.attr.actionBarSize))
//        return styledAttributes.getDimension(0, 0f).toInt()
        return 40.dp
    }

    companion object {
        val screenHeight: Int
            get() = Resources.getSystem().displayMetrics.heightPixels
    }
}

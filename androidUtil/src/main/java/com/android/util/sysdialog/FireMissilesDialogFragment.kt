package com.android.util.sysdialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData

class FireMissilesDialogFragment : DialogFragment() {
    companion object {
        fun newInstance(): FireMissilesDialogFragment {
            return FireMissilesDialogFragment()
        }
    }

    private var showWithLifecycleLiveData: MutableLiveData<Boolean>? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            builder.setMessage("使用测量设备前,请打开蓝牙权限")
                .setPositiveButton(
                    "确定",
                    DialogInterface.OnClickListener { dialog, id ->
                        // FIRE ZE MISSILES!
                        mListener?.positiveBt()
                    })
                .setNegativeButton("取消",
                    DialogInterface.OnClickListener { dialog, id ->
                        // User cancelled the dialog
                        mListener?.negativeBt()
                    })
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }


    fun showWithLifecycle(fragmentActivity: FragmentActivity, tag: String? = null) {
        val liveData = showWithLifecycleLiveData ?: MutableLiveData<Boolean>().also {
            it.observe(fragmentActivity) { this.show(fragmentActivity.supportFragmentManager, tag) }
            showWithLifecycleLiveData = it
        }
        liveData.value = true
    }

    interface IConfirmListener {
        fun positiveBt()
        fun negativeBt()
    }

    var mListener: IConfirmListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (parentFragment is IConfirmListener) {
            mListener = parentFragment as IConfirmListener
        } else if (context is IConfirmListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement IConfirmListener")
        }
    }


}
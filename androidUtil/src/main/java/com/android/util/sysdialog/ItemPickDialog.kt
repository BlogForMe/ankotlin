package com.android.util.sysdialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.util.R
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 * 弹出选择dialog
 */
class ItemPickDialog : DialogFragment() {
    companion object {
        const val PARAMS_PICK_TITLE = "item_pick_title"
        const val PARAMS_PICK_CONTENT = "item_pick_content"
        fun newInstance(title: String, resArr: ArrayList<String>) = ItemPickDialog().apply {
            arguments = Bundle().apply {
                putString(PARAMS_PICK_TITLE, title)
                putStringArrayList(PARAMS_PICK_CONTENT, resArr)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = LayoutInflater.from(context).inflate(R.layout.dialog_alert, null)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val title = arguments?.getString(PARAMS_PICK_TITLE)
        val contentArr = arguments?.getStringArrayList(PARAMS_PICK_CONTENT)
//        var recycleView = view.findViewById<RecyclerView>(R.id.recycle_view)
        val mAdapter = DialogAdapter(
            R.layout.dialog_item_content,
            contentArr
        )
        val recycle_view = view?.findViewById<RecyclerView>(R.id.recycle_view)
        recycle_view?.layoutManager = LinearLayoutManager(context)
        recycle_view?.adapter = mAdapter
        val tvTitle = view?.findViewById<TextView>(R.id.tv_title)
        tvTitle?.text = "请选择测量项"
        mAdapter.setOnItemClickListener { adapter, view, position ->
//            Toast.makeText(context," $position ",Toast.LENGTH_SHORT).show()
            mListener?.let {
                it.getItemPosition(position)
                dismiss()
            }
        }
    }


    interface ISelectListener {
        fun getItemPosition(position: Int)
    }

    var mListener: ISelectListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (parentFragment is ISelectListener) {
            mListener = parentFragment as ISelectListener
        } else if (context is ISelectListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement ISelectListener")
        }
    }

    class DialogAdapter(layoutResId: Int, data: ArrayList<String>?) :
        BaseQuickAdapter<String, BaseViewHolder>(layoutResId, data) {
        override fun convert(helper: BaseViewHolder, item: String) {
            helper.setText(R.id.tv_content, item)
        }

    }

}

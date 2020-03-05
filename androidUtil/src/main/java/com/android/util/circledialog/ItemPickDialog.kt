package com.android.util.circledialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.util.R
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import kotlinx.android.synthetic.main.dialog_alert.*

/**
 * 弹出选择dialog
 */
class ItemPickDialog : DialogFragment() {
    companion object {
        val PARAMS_PICK_TITLE = "item_pick_title"
        val PARAMS_PICK_CONTENT = "item_pick_content"
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
//        val builder = activity?.let { AlertDialog.Builder(it) }
//        builder!!.setTitle(title)
//            .setView(view)
//        var alert = builder.create()
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val title = arguments?.getString(PARAMS_PICK_TITLE)
        val contentArr = arguments?.getStringArrayList(PARAMS_PICK_CONTENT)
//        var recycleView = view.findViewById<RecyclerView>(R.id.recycle_view)
        val mAdapter = DialogAdapter(R.layout.dialog_item_content, contentArr)
        recycle_view.layoutManager = LinearLayoutManager(context)
        recycle_view.adapter = mAdapter
        tv_title.text = "请选择测量项"
        mAdapter.setOnItemClickListener { adapter, view, position ->
//            Toast.makeText(context," $position ",Toast.LENGTH_SHORT).show()
            mListener?.let {
                it.getItemPosition(position)
            }
        }
    }


    interface ISelectListener {
        fun getItemPosition(position: Int)
    }

    var mListener: ISelectListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ISelectListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement ISelectListener")
        }
    }

    class DialogAdapter(layoutResId:Int, data: ArrayList<String>?) : BaseQuickAdapter<String, BaseViewHolder>(layoutResId,data) {
        override fun convert(helper: BaseViewHolder, item: String) {
            helper.setText(R.id.tv_content,item)
        }

    }

}

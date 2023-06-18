package com.comm.util.component.fragment.stack;

import android.widget.Button;
import com.android.util.base.BaseFragment;

/**
 * @author : John
 * @date : 2018/9/5
 */
public class Stack1Fragment extends BaseFragment implements Stack2Fragment.ICallback {

    private Button mBtn;

    @Override
    public void back(String msg) {

    }

    //@Override
    //public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    //    super.onActivityCreated(savedInstanceState);
    //    String param1 = getArguments().getString("param1");
    //    Timber.d("param1 " + param1);
    //}
    //
    //@Override
    //protected void initView(View view) {
    //    mBtn = view.findViewById(R.id.id_fragment_one_btn);
    //    mBtn.setOnClickListener(v -> {
    //        Stack2Fragment fTwo = new Stack2Fragment();
    //        FragmentManager fm = getChildFragmentManager();
    //        FragmentTransaction tx = fm.beginTransaction();
    //        tx.replace(R.id.fl_content, fTwo, "TWO");
    //        tx.addToBackStack(null);
    //        tx.commit();
    //    });
    //    //        mBtn.setOnClickListener(v -> {
    //    ////            final Intent intent = new Intent(getContext(), SecondActivity.class);
    //    ////            startActivityForResult(intent, 1);
    //    //            ARouter.getInstance().build(ACTIVITY_SECOND).navigation(getActivity(),1000);
    //    //        });
    //}
    //
    //@Override
    //protected int setLayoutId() {
    //    return R.layout.fragment_stack_one;
    //}
    //
    //@Override
    //public void back(String msg) {
    //    Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    //}

    //    @Override
    //     public void onActivityResult(int requestCode, int resultCode, Intent data) {
    ////        super.onActivityResult(requestCode, resultCode, data);
    //        switch (resultCode) {
    //            case 21:
    //                String datas = data.getStringExtra(sData);
    //                Timber.d(datas);
    //                break;
    //        }
    //    }

}

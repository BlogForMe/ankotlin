package com.john.kot.mvvm.dongnao.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.john.kot.R;

public class VIewModel1Activity extends AppCompatActivity {

    private TextView textView;
    private MyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model1);

        viewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(MyViewModel.class);
        textView = (TextView) findViewById(R.id.textview);
        textView.setText(String.valueOf(viewModel.number));
    }

    public void plusNumber(View view) {
        textView.setText(String.valueOf(++viewModel.number));
    }
}
package com.example.nicodemos.kamba_test.Acitivitys;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.nicodemos.kamba_test.DadosAPIModelo.KambaModel;
import com.example.nicodemos.kamba_test.R;

/**
 * Created by Nicodemos on 28/09/2018.
 */

public class UserKambasMore extends AppCompatActivity {

    private KambaModel kambaModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_show_more);

        kambaModel= getIntent().getParcelableExtra(UserKambaTest.EXTRA_ITEM_REFERENCE);
        System.out.println("email é "+kambaModel.getEmail_from());


    }
}

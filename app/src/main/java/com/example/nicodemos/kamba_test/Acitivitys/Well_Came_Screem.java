package com.example.nicodemos.kamba_test.Acitivitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.nicodemos.kamba_test.R;

/**
 * Created by Nicodemos on 27/09/2018.
 */

public class Well_Came_Screem extends AppCompatActivity {
    private Button verKambaUser;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_kamba_frst_screem);

        verKambaUser= findViewById(R.id.kamba_test_button);
        verKambaUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent userkambatest= new Intent(getBaseContext(), UserKambaTest.class);
                startActivity(userkambatest);
            }
        });

    }
}

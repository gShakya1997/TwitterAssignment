package com.study.twitter.activities.registerActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.study.twitter.R;

public class RegisterActivityFourthStep extends AppCompatActivity {
    private ImageView imgBtnBackFourthStep;
    private EditText etRegPassword;
    private Button btnNext4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_fourth_step);
        binding();
        actionButtons();
    }

    private void actionButtons(){
        btnNext4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivityFourthStep.this,RegisterActivityFifthStep.class);
                startActivity(intent);
                finish();
            }
        });

        imgBtnBackFourthStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivityFourthStep.this,RegisterActivityThirdStep.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void binding(){
        btnNext4 = findViewById(R.id.btnNext4);
        etRegPassword = findViewById(R.id.etRegPassword);
        imgBtnBackFourthStep = findViewById(R.id.imgBtnBackFourthStep);
    }
}

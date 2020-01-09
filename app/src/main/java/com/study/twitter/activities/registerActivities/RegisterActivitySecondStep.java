package com.study.twitter.activities.registerActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.study.twitter.R;
import com.study.twitter.activities.webviewActivities.WebViewHelp;

public class RegisterActivitySecondStep extends AppCompatActivity {
    private TextView tvHelp;
    private Button btnNext2;
    private ImageView imgBtnBackSecondStep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_second_step);
        binding();
        actionButtons();
    }

    private void actionButtons(){
        tvHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivitySecondStep.this, WebViewHelp.class);
                startActivity(intent);
                finish();
            }
        });

        btnNext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivitySecondStep.this, RegisterActivityThirdStep.class);
                startActivity(intent);
                finish();
            }
        });

        imgBtnBackSecondStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivitySecondStep.this, RegisterActivityEmail.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void binding(){
        tvHelp = findViewById(R.id.tvHelp);
        btnNext2 = findViewById(R.id.btnNext2);
        imgBtnBackSecondStep = findViewById(R.id.imgBtnBackSecondStep);
    }
}

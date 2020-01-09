package com.study.twitter.activities.registerActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.study.twitter.R;
import com.study.twitter.activities.GettingStartedActivity;

public class RegisterActivityEmail extends AppCompatActivity {
    private ImageView imgBtnBack;
    private TextView tvSignUpTypePhone;
    private EditText etRegName, etRegEmail;
    private Button btnNextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_email);
        binding();
        actionButtons();
    }

    private void actionButtons(){
        imgBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGSA = new Intent(RegisterActivityEmail.this, GettingStartedActivity.class);
                startActivity(intentGSA);
                finish();
            }
        });

        tvSignUpTypePhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRP = new Intent(RegisterActivityEmail.this, RegisterActivityPhone.class);
                startActivity(intentRP);
                finish();
            }
        });

        btnNextEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRSS = new Intent(RegisterActivityEmail.this, RegisterActivitySecondStep.class);
                startActivity(intentRSS);
                finish();
            }
        });
    }

    private void binding() {
        imgBtnBack = findViewById(R.id.imgBtnBack);
        tvSignUpTypePhone = findViewById(R.id.tvSignUpTypePhone);
        etRegName = findViewById(R.id.etRegName);
        etRegEmail = findViewById(R.id.etRegEmail);
        btnNextEmail = findViewById(R.id.btnNextEmail);
    }
}
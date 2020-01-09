package com.study.twitter.activities.registerActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.study.twitter.R;
import com.study.twitter.activities.GettingStartedActivity;

public class RegisterActivityPhone extends AppCompatActivity {
    private ImageView imgBtnBack;
    private TextView tvSignUpTypeEmail;
    private EditText etRegNameP, etRegPhone;
    private Button btnNextPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_phone);
        binding();
        actionButtons();
    }

    private void actionButtons() {
        imgBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGSA = new Intent(RegisterActivityPhone.this, GettingStartedActivity.class);
                startActivity(intentGSA);
                finish();
            }
        });

        tvSignUpTypeEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRP = new Intent(RegisterActivityPhone.this, RegisterActivityEmail.class);
                startActivity(intentRP);
                finish();
            }
        });

        btnNextPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateName() | !validateEmail()){
                    return;
                }
                Intent intentRSS = new Intent(RegisterActivityPhone.this, RegisterActivitySecondStep.class);
                startActivity(intentRSS);
                finish();
            }
        });
    }

    private void binding() {
        imgBtnBack = findViewById(R.id.imgBtnBack);
        tvSignUpTypeEmail = findViewById(R.id.tvSignUpTypeEmail);
        etRegNameP = findViewById(R.id.etRegNameP);
        etRegPhone = findViewById(R.id.etRegPhone);
        btnNextPhone = findViewById(R.id.btnNextPhone);
    }

    private boolean validateEmail() {
        String regPhone = etRegPhone.getText().toString().trim();
        if (regPhone.isEmpty()) {
            etRegPhone.setError("Please enter a valid phone number");
            return false;
        } else if (regPhone.length() < 10 | regPhone.length() > 14) {
            etRegPhone.setError("Please enter a valid phone number");
            return false;
        } else {
            etRegPhone.setError(null);
            return true;
        }
    }

    private boolean validateName() {
        String regName = etRegNameP.getText().toString().trim();

        if (regName.isEmpty()) {
            etRegNameP.setError("What's your name");
            return false;
        } else if (regName.length() > 50) {
            etRegNameP.setError("Name too long");
            return false;
        } else {
            etRegNameP.setError(null);
            return true;
        }
    }
}

package com.study.twitter.activities.registerActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputLayout;
import com.study.twitter.R;
import com.study.twitter.model.DataTransfer;

import java.util.regex.Pattern;

public class RegisterActivityFourthStep extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=<>])" +    //at least 1 special character
                    ".{6,}" +               //at least 6 characters
                    "$");
    private ImageView imgBtnBackFourthStep;
    private TextInputLayout etRegPassword;
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
                if (!validatePassword()){
                    return;
                }
                DataTransfer.password = etRegPassword.getEditText().getText().toString().trim();
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

    private boolean validatePassword() {
        String regPassword = etRegPassword.getEditText().getText().toString().trim();
        if (regPassword.isEmpty()) {
            etRegPassword.setError("Please enter password");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(regPassword).matches()) {
            etRegPassword.setError("Password is too weak");
            return false;
        } else {
            etRegPassword.setError(null);
            return true;
        }
    }

    private void binding(){
        btnNext4 = findViewById(R.id.btnNext4);
        etRegPassword = findViewById(R.id.etRegPassword);
        imgBtnBackFourthStep = findViewById(R.id.imgBtnBackFourthStep);
    }
}

package com.study.twitter.activities.registerActivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.study.twitter.R;
import com.study.twitter.activities.webviewActivities.WebViewCookie;
import com.study.twitter.activities.webviewActivities.WebViewPO;
import com.study.twitter.activities.webviewActivities.WebViewPP;
import com.study.twitter.activities.webviewActivities.WebViewTerms;
import com.study.twitter.model.DataTransfer;

public class RegisterActivityThirdStep extends AppCompatActivity {
    private TextView textView3, etRegNameFinal, etRegEmailFinal;
    private Button btnSignUp;
    private ImageView imgBtnBackThirdStep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_third_step);
        binding();
        actionButtons();

        etRegNameFinal.setText(DataTransfer.name);
        if (DataTransfer.email != null){
            etRegEmailFinal.setText(DataTransfer.email);
        } else {
            etRegEmailFinal.setText(DataTransfer.phone);
        }


        String text = "By signing up, you agree to the Terms of service and Privacy Policy, including Cookie Use. Others will be able to find you by email or phone number when provided Privacy Options";
        SpannableString ss = new SpannableString(text);

        ClickableSpan clickableSpanTerms = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent intent = new Intent(RegisterActivityThirdStep.this, WebViewTerms.class);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
                ds.setUnderlineText(false);
            }
        };

        ClickableSpan clickableSpanPP = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent intent = new Intent(RegisterActivityThirdStep.this, WebViewPP.class);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
                ds.setUnderlineText(false);
            }
        };

        ClickableSpan clickableSpanCookie = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent intent = new Intent(RegisterActivityThirdStep.this, WebViewCookie.class);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
                ds.setUnderlineText(false);
            }
        };

        ClickableSpan clickableSpanPO = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent intent = new Intent(RegisterActivityThirdStep.this, WebViewPO.class);
                startActivity(intent);
            }
        };

        ss.setSpan(clickableSpanTerms, 32, 48, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(clickableSpanPP, 53, 67, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(clickableSpanCookie, 79, 89, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(clickableSpanPO, 162, 177, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView3.setText(ss);
        textView3.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void actionButtons(){
        imgBtnBackThirdStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivityThirdStep.this, RegisterActivitySecondStep.class);
                startActivity(intent);
                finish();
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivityThirdStep.this,RegisterActivityFourthStep.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void binding() {
        textView3 = findViewById(R.id.textView3);
        btnSignUp = findViewById(R.id.btnSignUp);
        imgBtnBackThirdStep = findViewById(R.id.imgBtnBackThirdStep);
        etRegEmailFinal = findViewById(R.id.etRegEmailFinal);
        etRegNameFinal = findViewById(R.id.etRegNameFinal);
    }
}

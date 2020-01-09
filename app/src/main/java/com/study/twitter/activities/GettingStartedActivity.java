package com.study.twitter.activities;

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
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.study.twitter.R;
import com.study.twitter.activities.registerActivities.RegisterActivityEmail;

public class GettingStartedActivity extends AppCompatActivity {
    private Button btnCreateAccount;
    private TextView textLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getting_started);

        btnCreateAccount = findViewById(R.id.btnCreateAccount);
        textLogIn = findViewById(R.id.textLogIn);
        String text = "Have an account already? Log in";
        SpannableString ss = new SpannableString(text);

        ClickableSpan clickableSpanLogin = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent intent = new Intent(GettingStartedActivity.this,LoginActivity.class);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
                ds.setColor(Color.BLUE);
            }
        };

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GettingStartedActivity.this, RegisterActivityEmail.class);
                startActivity(intent);
                finish();
            }
        });

        ss.setSpan(clickableSpanLogin,26,31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textLogIn.setText(ss);
        textLogIn.setMovementMethod(LinkMovementMethod.getInstance());
    }
}

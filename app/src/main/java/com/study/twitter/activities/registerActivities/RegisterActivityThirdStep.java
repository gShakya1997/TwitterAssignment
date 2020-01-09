package com.study.twitter.activities.registerActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.TextView;

import com.study.twitter.R;

public class RegisterActivityThirdStep extends AppCompatActivity {
    private TextView textView3;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_third_step);
        binding();
        String text = "By signing up, you agree to the Terms of service and Privacy Policy, including Cookie Use. Others will be able to find you by email or phone number when provided Privacy Options";
        SpannableString ss = new SpannableString(text);


//
//        ss.setSpan(clickableSpanTerms, 32, 48, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        ss.setSpan(clickableSpanPP, 53, 67, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        ss.setSpan(clickableSpanCookie, 79, 89, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        ss.setSpan(clickableSpanPO, 162, 177, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView3.setText(ss);
        textView3.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void binding(){
        textView3 = findViewById(R.id.textView3);
        btnSignUp = findViewById(R.id.btnSignUp);
    }
}

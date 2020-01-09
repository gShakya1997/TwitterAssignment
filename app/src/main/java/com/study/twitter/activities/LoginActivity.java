package com.study.twitter.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.study.twitter.R;
import com.study.twitter.activities.registerActivities.RegisterActivityEmail;

public class LoginActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private Button btnLoginSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Binding();
        btnLoginSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivityEmail.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemAbout:
                Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itemProxy:
                Toast.makeText(this, "Proxy", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }

    public void showPopup(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.menu);
        popup.show();
    }

    private void Binding() {
        btnLoginSignup = findViewById(R.id.btnLoginSignup);
    }
}

package com.study.twitter.activities.registerActivities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.study.twitter.R;

public class RegisterActivityFifthStep extends AppCompatActivity {
    private ImageView imgBtnBackFifthStep;
    private ImageButton imgBtnUpload;
    private Button btnSignUpFinal;
    private String imgPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_fifth_step);
        binding();
        actionButtons();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            if (data == null){
                Toast.makeText(this, "Please select and image", Toast.LENGTH_SHORT).show();
            }
        }
        Uri uri = data.getData();
        imgBtnUpload.setImageURI(uri);
        imgPath = getRealPathFromUri(uri);
    }

    private String getRealPathFromUri(Uri uri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        CursorLoader loader = new CursorLoader(getApplicationContext(),
                uri, projection, null, null, null);
        Cursor cursor = loader.loadInBackground();
        int colIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result = cursor.getString(colIndex);
        cursor.close();
        return result;
    }

    private void actionButtons(){
        imgBtnBackFifthStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivityFifthStep.this,RegisterActivityFourthStep.class);
                startActivity(intent);
                finish();
            }
        });

        imgBtnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                browseImg();
            }
        });
    }

    private void browseImg() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 0);
    }

    private void binding(){
        imgBtnBackFifthStep = findViewById(R.id.imgBtnBackFifthStep);
        imgBtnUpload = findViewById(R.id.imgBtnUpload);
        btnSignUpFinal = findViewById(R.id.btnSignUpFinal);
    }
}

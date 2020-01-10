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
import com.study.twitter.activities.LoginActivity;
import com.study.twitter.api.UsersAPI;
import com.study.twitter.model.DataTransfer;
import com.study.twitter.model.Users;
import com.study.twitter.serverResponse.ImageResponse;
import com.study.twitter.serverResponse.RegisterResponse;
import com.study.twitter.strictMode.StrictModeClass;
import com.study.twitter.url.Url;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegisterActivityFifthStep extends AppCompatActivity {
    private ImageView imgBtnBackFifthStep;
    private ImageButton imgBtnUpload;
    private Button btnSignUpFinal;
    String imgPath;
    private String imgName = "";

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
        if (resultCode == RESULT_OK) {
            if (data == null) {
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

    private void actionButtons() {
        imgBtnBackFifthStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivityFifthStep.this, RegisterActivityFourthStep.class);
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


        btnSignUpFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveImgOnly();
                register();
                Intent intent = new Intent(RegisterActivityFifthStep.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void browseImg() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 0);
    }

    private void saveImgOnly() {
        File file = new File(imgPath);
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("imageFile", file.getName(), requestBody);
        UsersAPI usersAPI = Url.getInstance().create(UsersAPI.class);
        Call<ImageResponse> responseCall = usersAPI.uploadImage(body);
        StrictModeClass.StrictMode(); //from StrictModeClass
        try {
            Response<ImageResponse> imageResponseResponse = responseCall.execute();
            imgName = imageResponseResponse.body().getFilename();
            Toast.makeText(this, "Image inserted " + imgName, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, "Error " + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private void register() {
        String username = DataTransfer.name;
        String password = DataTransfer.password;
        String email = DataTransfer.email;
        String phone = DataTransfer.phone;

        Users users = new Users(username, password, email, phone, imgName);
        UsersAPI usersAPI = Url.getInstance().create(UsersAPI.class);
        Call<RegisterResponse> registerResponseCall = usersAPI.registerUser(users);

        registerResponseCall.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(RegisterActivityFifthStep.this, "Code " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(RegisterActivityFifthStep.this, "Successfully registered", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Toast.makeText(RegisterActivityFifthStep.this, "Error " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void binding() {
        imgBtnBackFifthStep = findViewById(R.id.imgBtnBackFifthStep);
        imgBtnUpload = findViewById(R.id.imgBtnUpload);
        btnSignUpFinal = findViewById(R.id.btnSignUpFinal);
    }
}

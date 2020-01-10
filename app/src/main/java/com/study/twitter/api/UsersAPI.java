package com.study.twitter.api;

import com.study.twitter.model.Users;
import com.study.twitter.serverResponse.ImageResponse;
import com.study.twitter.serverResponse.RegisterResponse;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface UsersAPI {
    @POST("users/register")
    Call<RegisterResponse> registerUser(@Body Users users);

    @FormUrlEncoded
    @POST("users/login")
    Call<RegisterResponse> checkUser(@Field("username") String username, @Field("password") String password);

    @Multipart
    @POST("upload")
    Call<ImageResponse> uploadImage(@Part MultipartBody.Part image);

    @GET("users/me")
    Call<Users> getUserDetails(@Header("Authorization")String token);
}

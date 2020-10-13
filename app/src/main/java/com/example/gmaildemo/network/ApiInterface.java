package com.example.gmaildemo.network;

import java.util.List;

import com.example.gmaildemo.model.Message;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("inbox.json")
    Call<List<Message>> getInbox();

}

package com.my.jerrychan.httpManager;

import com.my.jerrychan.constant.ApiConstant;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by linchen on 16/2/21.
 * github:https://github.com/JerryChan123
 * e-mail:linchen0922@163.com
 */
public class BaseApi {
    private static  Retrofit retrofit;

    protected static  Retrofit getRetrofit(){
        if (retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(ApiConstant.API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }
        return  retrofit;
    }
}

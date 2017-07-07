package com.apple.sampleretrofit.retorfit1.api;


import com.apple.sampleretrofit.retorfit1.bean.Movie;
import com.apple.sampleretrofit.retorfit1.bean.MovieResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
*主要用来对接口又进行了一次封装，不让用户直接接触Retrofit的接口
 *  1 有BaseUrl
 *  2 实例 Retaofit
 *  3 实例 Service
 *  4 在Retrofit网络调用接口上再封装一层
**/
public class ApiManager {
    /**
     * 基础地址
     */
    private static final String Base_Url = "https://api.douban.com/v2/movie/";

    private static final Retrofit sRetrofit = new Retrofit.Builder()
            .baseUrl(Base_Url)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 使用RxJava作为回调适配器
            .build();

    private static final ApiService apiManager = sRetrofit.create(ApiService.class);

    public static Call<MovieResponse<List<Movie>>> getMovies(int start, int end){
        return apiManager.getMovices(start,end);
    }

}

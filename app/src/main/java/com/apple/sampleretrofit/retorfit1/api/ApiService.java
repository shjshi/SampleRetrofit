package com.apple.sampleretrofit.retorfit1.api;

import com.apple.sampleretrofit.retorfit1.bean.Movie;
import com.apple.sampleretrofit.retorfit1.bean.MovieResponse;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by apple on 17/7/6.
 */

public interface ApiService {

    @GET("top250")
    Call<MovieResponse<List<Movie>>> getMovices(@Query("start") int start, @Query("count") int count);

    @GET("top250")
    Call<MovieResponse<List<Movie>>> getMovices2(@QueryMap Map<String,String> map);
}

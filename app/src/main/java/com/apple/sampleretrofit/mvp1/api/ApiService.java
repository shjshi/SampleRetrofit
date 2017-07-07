package com.apple.sampleretrofit.mvp1.api;

import com.apple.sampleretrofit.retorfit1.bean.Movie;
import com.apple.sampleretrofit.retorfit1.bean.MovieResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by apple on 17/7/6.
 */

public interface ApiService {
    @GET("top250")
    Call<MovieResponse<List<Movie>>> getMovices(@Query("start") int start, @Query("count") int count);
}

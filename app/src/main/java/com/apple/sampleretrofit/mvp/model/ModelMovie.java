package com.apple.sampleretrofit.mvp.model;

import com.apple.sampleretrofit.bean.Movie;
import com.apple.sampleretrofit.bean.MovieResponse;
import com.apple.sampleretrofit.mvp.presenter.PresenterListener;
import com.apple.sampleretrofit.mvp.api.ApiManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by apple on 17/7/7.
 * 在model层调用Retrofit接口
 */

public class ModelMovie {
    PresenterListener<MovieResponse<List<Movie>>> listener;
    public ModelMovie(PresenterListener<MovieResponse<List<Movie>>> listener){
        this.listener = listener;
    }
    public void getMovies(int start, int end) {
        ApiManager.getMovies(start, end).enqueue(new Callback<MovieResponse<List<Movie>>>() {
            @Override
            public void onResponse(Call<MovieResponse<List<Movie>>> call, Response<MovieResponse<List<Movie>>> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<MovieResponse<List<Movie>>> call, Throwable t) {
                listener.onFialer(t);
            }
        });
    }
}
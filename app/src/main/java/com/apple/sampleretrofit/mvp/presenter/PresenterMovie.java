package com.apple.sampleretrofit.mvp.presenter;

import com.apple.sampleretrofit.bean.Movie;
import com.apple.sampleretrofit.bean.MovieResponse;
import com.apple.sampleretrofit.mvp.view.ViewData;
import com.apple.sampleretrofit.mvp.model.ModelMovie;

import java.util.List;

/**
 * Created by apple on 17/7/7.
 */

public class PresenterMovie implements PresenterListener<MovieResponse<List<Movie>>>{
    private final ModelMovie modelMovie;
    ViewData<MovieResponse<List<Movie>>> viewData;

    public PresenterMovie(ViewData<MovieResponse<List<Movie>>> viewData){
        modelMovie = new ModelMovie(this);
        this.viewData = viewData;

    }
    public void getMovies(int start,int end){
        viewData.showProgress();
        modelMovie.getMovies(start,end);
    }
    @Override
    public void onSuccess(MovieResponse<List<Movie>> response) {
        viewData.hideProgress();
        viewData.loadData(response);
    }

    @Override
    public void onFialer(Throwable e) {
        viewData.hideProgress();
    }
}

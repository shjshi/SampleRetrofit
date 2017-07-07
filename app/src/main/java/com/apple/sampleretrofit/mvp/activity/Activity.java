package com.apple.sampleretrofit.mvp.activity;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.apple.sampleretrofit.R;
import com.apple.sampleretrofit.bean.Movie;
import com.apple.sampleretrofit.bean.MovieResponse;
import com.apple.sampleretrofit.mvp.presenter.PresenterMovie;
import com.apple.sampleretrofit.mvp.view.ViewData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 17/7/7.
 */

public class Activity extends ListActivity implements ViewData<MovieResponse<List<Movie>>> {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PresenterMovie presenterMovie = new PresenterMovie(this);
        presenterMovie.getMovies(0,10);

    }

    @Override
    public void showProgress() {
        Toast.makeText(this,"showProgress",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideProgress() {
        Toast.makeText(this,"hideProgress",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadData(MovieResponse<List<Movie>> data) {
        List<String> titles = new ArrayList<>();
        for (Movie m: data.getSubjects()){
            titles.add(m.getTitle());
        }


        ArrayAdapter aa = new ArrayAdapter(this, R.layout.main,titles);
        setListAdapter(aa);
    }
}

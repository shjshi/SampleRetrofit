package com.apple.sampleretrofit.retorfit1.activity;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.apple.sampleretrofit.R;
import com.apple.sampleretrofit.retorfit1.api.ApiManager;
import com.apple.sampleretrofit.retorfit1.bean.Movie;
import com.apple.sampleretrofit.retorfit1.bean.MovieResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by apple on 17/7/6.
 */

public class Activity3 extends ListActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMovies();
    }

    private void getMovies() {
        Map<String,String> map = new HashMap<String,String>();
        map.put("start","0");
        map.put("end","10");
        Call<MovieResponse<List<Movie>>> call = ApiManager.getMovies2(map);
        call.enqueue(new Callback<MovieResponse<List<Movie>>>() {
            @Override
            public void onResponse(Call<MovieResponse<List<Movie>>> call, Response<MovieResponse<List<Movie>>> response) {
                MovieResponse movieResponse = response.body();
                List<Movie> list = (List<Movie>) movieResponse.getSubjects();
                Log.d("shj--",list.toString());
                setData(list);
            }

            @Override
            public void onFailure(Call<MovieResponse<List<Movie>>> call, Throwable t) {
                Log.d("shj--","error"+t.getMessage());
            }
        });
    }

    private void setData(List<Movie> list) {
        List<String> titles = new ArrayList<>();
        for (Movie m:list){
            titles.add(m.getTitle());
        }

        ArrayAdapter aa = new ArrayAdapter(Activity3.this, R.layout.main,titles);
        setListAdapter(aa);
    }
}

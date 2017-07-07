package com.apple.sampleretrofit.activity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import com.apple.sampleretrofit.R;
import com.apple.sampleretrofit.api.ApiManager;
import com.apple.sampleretrofit.api.HttpCallBack;
import com.apple.sampleretrofit.bean.Movie;
import com.apple.sampleretrofit.bean.MovieResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

/**
 * Created by apple on 17/7/6.
 * 自定义Callback数据回调方式
 */

public class Activity2 extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMovies();
    }

    private void getMovies() {
        //不能进行测试，这个json没有错误码，但是思路是这样的，封装起来统一去处理
        ApiManager.getMovies(0, 10)
                .enqueue(new HttpCallBack<MovieResponse<List<Movie>>>() {
                    @Override
                    public void onSuc(Response<MovieResponse<List<Movie>>> response) {
                        setData(response.body().getSubjects());
                    }

                    @Override
                    public void onFail(String message) {

                    }

                    @Override
                    public void onAutoLogin() {

                    }
                });
    }

    private void setData(List<Movie> list) {
        List<String> titles = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Movie m = list.get(i);
            titles.add(m.getTitle());
        }
        BaseAdapter aa = new ArrayAdapter<String>(Activity2.this, R.layout.main, titles);
        setListAdapter(aa);
    }
}
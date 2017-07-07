package com.apple.sampleretrofit.mvp.view;

/**
 * Created by apple on 17/6/1.
 * view是一个接口
 * 这个接口是activity来实现的，也就是他将数据给activity
 * view自己的数据从p 来的
 */
public interface ViewData<T> {
    void showProgress();
    void hideProgress();
    void loadData(T data);
}

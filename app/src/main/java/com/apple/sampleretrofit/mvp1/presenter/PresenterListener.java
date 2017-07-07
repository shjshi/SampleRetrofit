package com.apple.sampleretrofit.mvp1.presenter;

/**
 * Created by apple on 17/6/1.
 * 这个是自定义的关于请求数据后的接口回调，用泛型，就不用每个接口都写一个回调接口了
 */
public interface PresenterListener<T> {
    void onSuccess(T response);
    void onFialer(Throwable e);
}

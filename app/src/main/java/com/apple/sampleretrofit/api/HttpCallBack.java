package com.apple.sampleretrofit.api;


import com.apple.sampleretrofit.bean.BaseCallModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by apple on 17/7/6.
 * 0-请求成功
   1-请求失败，登录过期
   2-请求失败，无权限
   3-请求失败-余额不足
 */

public abstract class HttpCallBack<T extends BaseCallModel> implements Callback<T> {
    @Override
    public void onFailure(Call<T> call, Throwable t) {

    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.raw().code() == 200) {//200是服务器有合理响应
            if(response.body().errno == 0){
                onSuc(response);
            }
            else if (response.body().errno == 1){

            }
            else if (response.body().errno == 2){
                onAutoLogin();
            }
            else {
                onFail(response.body().msg);
            }

        } else {//失败响应
            onFailure(call, new RuntimeException("response error,detail = " + response.raw().toString()));
        }

    }

    public abstract void onSuc(Response<T> response);

    public abstract void onFail(String message);

    public abstract void onAutoLogin();
}

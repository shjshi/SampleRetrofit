package com.apple.sampleretrofit.bean;

/**
 * Created by apple on 17/7/6.
 */

public class BaseCallModel<T> {

    public int errno;
    public String msg;
    public T data;

}

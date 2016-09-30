package com.tistory.lky1001.airkoreasdk.listener;

/**
 * Created by lee on 2016. 8. 19..
 */
public interface OnResponseListener<T> {

    public void onResult(T response);
    public void onError(Throwable e);
}

package com.vivo11084921.network;

public interface HttpCallbackListener {

    void onFinish(String response);

    void onError(Exception e);

}

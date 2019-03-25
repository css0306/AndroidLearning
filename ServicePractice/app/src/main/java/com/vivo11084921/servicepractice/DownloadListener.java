package com.vivo11084921.servicepractice;

//定义回调方法
public interface DownloadListener {
    void onProgress(int progress);

    void onSuccess();

    void onFailed();

    void onPaused();

    void onCanceled();
}

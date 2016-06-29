package com.hackathonandroidos2016fatecipiranga_smartmeeting;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by eliete on 29/06/2016.
 */
public class DownloadService extends IntentService {

    public static final String TAG = DownloadService.class.getSimpleName();

    public DownloadService() {
        super(TAG);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "Service On Create");

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.e(TAG, "Service started");
        //downloadDoc
    }
}

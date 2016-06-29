package com.hackathonandroidos2016fatecipiranga_smartmeeting;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

/**
 * Created by eliete on 29/06/2016.
 */
public class DownloadActivity extends BaseActivity {

    private static final int TIME = 300;
    Handler handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        handler = new Handler();
        handler.post(new DownloadThread());
    }

    class DownloadThread extends Thread{
        @Override
        public void run() {
            super.run();

            Intent intent = new Intent(DownloadActivity.this, DownloadService.class);
            startService(intent);

            handler.postDelayed(new DownloadThread(), TIME);
        }
    }
}

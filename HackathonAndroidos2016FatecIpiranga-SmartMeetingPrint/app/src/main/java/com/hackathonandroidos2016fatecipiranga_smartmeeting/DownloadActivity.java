package com.hackathonandroidos2016fatecipiranga_smartmeeting;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by eliete on 29/06/2016.
 */
public class DownloadActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, DownloadService.class);
        startService(intent);
    }
}

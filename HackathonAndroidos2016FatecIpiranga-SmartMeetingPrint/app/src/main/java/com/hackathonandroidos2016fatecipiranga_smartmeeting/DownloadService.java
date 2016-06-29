package com.hackathonandroidos2016fatecipiranga_smartmeeting;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

/**
 * Created by eliete on 29/06/2016.
 */
public class DownloadService extends IntentService {

    public static final String TAG = DownloadService.class.getSimpleName();
    final long ONE_MEGABYTE = 1024 * 1024;

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

        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReferenceFromUrl("gs://smartmeetingclient-2f555.appspot.com");
        StorageReference pathReference = storageRef.getRoot();

        pathReference.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Log.e(TAG, "succeed get Bytes from doc ");

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });

    }
}

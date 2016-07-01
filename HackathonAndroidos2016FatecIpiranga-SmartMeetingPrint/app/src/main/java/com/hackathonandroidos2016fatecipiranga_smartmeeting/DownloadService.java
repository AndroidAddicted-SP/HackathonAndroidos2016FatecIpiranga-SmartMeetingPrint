package com.hackathonandroidos2016fatecipiranga_smartmeeting;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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
        StorageReference pathReference = storageRef.child("/documents/leo.turbiani@gmail.com.pdf");

        pathReference.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Log.e(TAG, "succeed get Bytes from doc ");
                //GRAVANDO O ARQUIVO
                File root = android.os.Environment.getExternalStorageDirectory();

                File dir = new File (root.getAbsolutePath() + "/download");
                dir.mkdirs();
                File file = new File(dir, "leo.turbiani@gmail.com.pdf");

                try {
                    FileOutputStream f = new FileOutputStream(file);
                    f.write(bytes);
                    f.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Log.e(TAG, e.getMessage());
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e(TAG, e.getMessage());
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });

    }
}

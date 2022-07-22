/*
 * Copyright 2021. Huawei Technologies Co., Ltd. All rights reserved.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.huawei.hms.network.filemanager.sample;

import android.Manifest;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Upload and download demo UIs.
 *
 * @since: 2021/01/21
 */
public class MainActivity extends Activity implements AUpDownloadEngine.EventListener {
    static String TAG = "FileManagerActivity";
    TextView tvInfo;
    AUpDownloadEngine downloadEngine;
    AUpDownloadEngine uploadEngine;

    void showMessage(String message) {
        showMessage(message, Color.CYAN);
    }

    void showMessage(String message, int color) {
        Log.i(TAG, "showMessage:" + message);
        tvInfo.post(new Runnable() {
            @Override
            public void run() {
                if (!TextUtils.isEmpty(message) && !message.contains("onProgress:")) {
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                }
                tvInfo.setText(message);
                tvInfo.setTextColor(color);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
                    checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1001);
            }
        }
        // just for download
        downloadEngine = new DownloadEngine(MainActivity.this.getApplicationContext(), this);

        // just for upload
        uploadEngine = new UploadEngine(MainActivity.this.getApplicationContext(), this);

        tvInfo = findViewById(R.id.tv_info);
        tvInfo.setMovementMethod(ScrollingMovementMethod.getInstance());

        findViewById(R.id.bt_download).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadEngine.download();
            }
        });

        findViewById(R.id.bt_download_pause).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadEngine.pause();
            }
        });
        findViewById(R.id.bt_download_resume).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadEngine.resume();
            }
        });

        findViewById(R.id.bt_download_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadEngine.cancel();
            }
        });

        findViewById(R.id.bt_uploadForPut).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadEngine.uploadForPut();
            }
        });

        findViewById(R.id.bt_uploadForPost).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadEngine.uploadForPost();
            }
        });

        findViewById(R.id.bt_cancelUpload).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadEngine.cancel();
            }
        });
    }

    @Override
    public void onEngineStart() {
        showMessage("onEngineStart");
    }

    @Override
    public void onProgress(int onProgress) {
        showMessage("onProgress:" + onProgress);
    }

    @Override
    public void onException(String message) {
        showMessage(message, Color.RED);
        Log.e(TAG, "exception for:" + message);
    }

    @Override
    public void onSuccess(String message) {
        try {
            showMessage("onProgress:" + 100);
            Thread.sleep(200);
            showMessage("success->" + message, Color.GREEN);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
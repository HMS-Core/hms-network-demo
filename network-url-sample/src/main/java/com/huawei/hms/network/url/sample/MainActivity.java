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

package com.huawei.hms.network.url.sample;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Load the corresponding request button on the app screen.
 *
 * @since: 2020/8/22
 */

public class MainActivity extends Activity implements View.OnClickListener, EventListener {
    private static final String TAG = "NetworkKitSample";
    private HttpClientSample httpClientSample;
    private RestClientSample restClientSample;
    private TextView callText;
    String title = "";
    @Override
    public void onException(String message) {
        showDetailMessage(message, Color.RED);
        Log.e(TAG, "exception for:" + message);
    }

    @Override
    public void onSuccess(String message) {
        showDetailMessage(message, Color.GREEN);
    }

    void showDetailMessage(String message, int color) {
        Log.i(TAG, "showMessage:" + message);
        if (callText != null) {
            callText.post(new Runnable() {
                @Override
                public void run() {
                    String showMsg = title + ":\n\n" + message;
                    if (!TextUtils.isEmpty(message)) {
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                    callText.setText(showMsg);
                    callText.setTextColor(color);
                }
            });
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        findViewById(R.id.btn_httpclient_execute).setOnClickListener(this);
        findViewById(R.id.btn_httpclient_enqueue).setOnClickListener(this);
        findViewById(R.id.btn_restclient_execute).setOnClickListener(this);
        findViewById(R.id.btn_restclient_enqueue).setOnClickListener(this);

        callText = findViewById(R.id.call_text);
        callText.setMovementMethod(ScrollingMovementMethod.getInstance());
        httpClientSample = new HttpClientSample(MainActivity.this);
        restClientSample = new RestClientSample(MainActivity.this);
    }

    @Override
    public void onClick(View view) {
        // Initiate a request using either the RestClient (annotation mode) or HttpClient mode.
        Log.i(TAG, "RestClientSample view onClick");
        switch (view.getId()) {
            case R.id.btn_httpclient_execute:
                title = "httpclient_execute";
                httpClientExecute();
                Log.i(TAG, "RestClientSample btn_httpclient_execute");
                break;
            case R.id.btn_httpclient_enqueue:
                title = "httpclient_enqueue";
                httpClientEnqueue();
                Log.i(TAG, "RestClientSample btn_httpclient_enqueue");
                break;
            case R.id.btn_restclient_execute:
                title = "annotation_execute";
                restClientAnnoExecute();
                Log.i(TAG, "RestClientSample btn_restclient_execute");
                break;
            case R.id.btn_restclient_enqueue:
                title = "annotation_enqueue";
                restClientAnnoAsync();
                Log.i(TAG, "RestClientSample btn_restclient_enqueue");
                break;
            default:
        }
    }

    private void httpClientExecute() {
        if(httpClientSample != null){
            httpClientSample.httpClientExecute();
        }
    }

    private void httpClientEnqueue() {
        if(httpClientSample != null){
            httpClientSample.httpClientEnqueue();
        }
    }

    private void restClientAnnoExecute() {
        if(restClientSample != null) {
            restClientSample.annoExecute();
        }
    }

    private void restClientAnnoAsync() {
        if(restClientSample != null) {
            restClientSample.annoEnqueue();
        }
    }
}

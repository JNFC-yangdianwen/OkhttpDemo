package com.example.yangdianwen.okhttpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    String url="http://www.baidu.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       new  Thread(){
           @Override
           public void run() {
               super.run();
               //创建okHttpClient对象
//               OkHttpClient mOkHttpClient = new OkHttpClient();
//               //创建一个Request
//               final Request request = new Request.Builder()
//                       .url("https://github.com/hongyangAndroid")
//                       .build();
//               Log.d(TAG, "run: "+request);
               VolleyHttp vh=new VolleyHttp();
               vh.getHttp(MainActivity.this,url);
           }
       }.start();
    }
}

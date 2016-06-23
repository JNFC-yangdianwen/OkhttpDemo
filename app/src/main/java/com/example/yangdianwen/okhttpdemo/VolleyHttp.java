package com.example.yangdianwen.okhttpdemo;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by yangdianwen on 16-6-23.
 */
public class VolleyHttp {

  public void   getHttp(Context context,String url){
      //创建请求消息队列
        RequestQueue mQueue = Volley.newRequestQueue(context);
      /**
       * StringRequest的构造函数需要传入三个参数，
       * 第一个参数就是目标服务器的URL地址，
       * 第二个参数是服务器响应成功的回调，
       * 第三个参数是服务器响应失败的回调。
       * 其中，目标服务器地址我们填写的是百度的首页，
       * 然后在响应成功的回调里打印出服务器返回的内容，在响应失败的回调里打印出失败的详细信息。
       */

      StringRequest stringRequest = new StringRequest(url,
              new Response.Listener<String>() {
                  @Override
                  public void onResponse(String response) {
                      Log.d("TAG", response);
                  }
              }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
              Log.e("TAG", error.getMessage(), error);
          }
      });
      //请求网络图片
//      ImageRequest的构造函数接收六个参数，
//      第一个参数就是图片的URL地址，这个没什么需要解释的。
//      第二个参数是图片请求成功的回调，
//      这里我们把返回的Bitmap参数设置到ImageView中。
//      第三第四个参数分别用于指定允许图片最大的宽度和高度，
//      如果指定的网络图片的宽度或高度大于这里的最大值，则会对图片进行压缩，
//      指定成0的话就表示不管图片有多大，都不会进行压缩。第五个参数用于指定图片的颜色属性，
//      Bitmap.Config下的几个常量都可以在这里使用，其中ARGB_8888可以展示最好的颜色属性，
//      每个图片像素占据4个字节的大小，而RGB_565则表示每个图片像素占据2个字节大小。
//      第六个参数是图片请求失败的回调，这里我们当请求失败时在ImageView中显示一张默认图片。

//      ImageRequest imageRequest = new ImageRequest(
//              "http://developer.android.com/images/home/aw_dac.png",
//              new Response.Listener<Bitmap>() {
//                  @Override
//                  public void onResponse(Bitmap response) {
//                      imageView.setImageBitmap(response);
//                  }
//              }, 0, 0, Config.RGB_565, new Response.ErrorListener() {
//          @Override
//          public void onErrorResponse(VolleyError error) {
//              imageView.setImageResource(R.drawable.default_image);
//          }
//      });
      mQueue.add(stringRequest);
  }

}

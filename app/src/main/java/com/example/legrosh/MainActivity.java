package com.example.legrosh;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    ImageView animation;
    WebView wbview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wbview=findViewById(R.id.webview);
        wbview.getSettings().setJavaScriptEnabled(true);
        animation=findViewById(R.id.imageView);
        String url="https://harshjaiswani.github.io/LeGroSh-old/";
//        String url="https://testrepo-one.vercel.app/";

        wbview.loadUrl(url);

        wbview.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                animation.setVisibility(View.VISIBLE);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                view.setVisibility(View.VISIBLE);
                animation.setVisibility(View.GONE);
                super.onPageFinished(view, url);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(wbview.canGoBack()){
            wbview.goBack();
        }else{
            super.onBackPressed();
        }
    }
}
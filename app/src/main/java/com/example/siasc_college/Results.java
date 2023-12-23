package com.example.siasc_college;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class Results extends AppCompatActivity {
    private WebView resultWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Results");

        resultWebView=(WebView) findViewById(R.id.resultsWebView);
        resultWebView.setWebViewClient(new WebViewClient());
        resultWebView.loadUrl("https://www.tvu.edu.in/examination/results/");
        WebSettings webSettings=resultWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }
    public class mywebClient extends WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon){
            super.onPageStarted(view,url,favicon);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url){
            view.loadUrl(url);
            return true;
        }
    }
    @Override
    public void onBackPressed(){
        if(resultWebView.canGoBack()) {
            resultWebView.goBack();
        }
        else{
            super.onBackPressed();
        }
    }
}
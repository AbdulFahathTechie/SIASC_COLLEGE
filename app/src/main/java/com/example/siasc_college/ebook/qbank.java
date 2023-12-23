package com.example.siasc_college.ebook;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.example.siasc_college.R;

public class qbank extends AppCompatActivity {
    private WebView qbankWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qbank);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("q-bank");

        qbankWebView=(WebView) findViewById(R.id.qbankWebView);
        qbankWebView.setWebViewClient(new WebViewClient());
        qbankWebView.loadUrl("https://www.shanmugacollege.edu.in/quest.html");
        WebSettings webSettings=qbankWebView.getSettings();
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
        if(qbankWebView.canGoBack()) {
            qbankWebView.goBack();
        }
        else{
            super.onBackPressed();
        }
    }
}
package com.example.siasc_college;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class ELibrary extends AppCompatActivity {
    private WebView eLibraryWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elibrary);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("e-Library");

        eLibraryWebView=(WebView) findViewById(R.id.eLibraryWebView);
        eLibraryWebView.setWebViewClient(new WebViewClient());
        eLibraryWebView.loadUrl("https://www.tvu.edu.in/academic/departments/library/");
        WebSettings webSettings=eLibraryWebView.getSettings();
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
        if(eLibraryWebView.canGoBack()) {
            eLibraryWebView.goBack();
        }
        else{
            super.onBackPressed();
        }
    }
}
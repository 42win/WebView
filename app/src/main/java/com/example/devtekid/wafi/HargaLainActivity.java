package com.example.devtekid.wafi;

import android.graphics.Bitmap;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class HargaLainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{

    private WebView webView;
    private SwipeRefreshLayout refreshLayout;
    public ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harga_lain);

        progressBar = (ProgressBar)findViewById(R.id.bar);

        webView = (WebView) findViewById(R.id.webview1);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new HargaLainActivity.MyBrowser(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
                setTitle("Loading...");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
                setTitle(view.getTitle());
            }
        });
        webView.loadUrl("https://wafi.seniorpenalaran.com/sampah-lain");

        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiferefresh);
        refreshLayout.setOnRefreshListener(this);
    }
    @Override
    public void onRefresh() {
        webView.reload();
        refreshLayout.setRefreshing(false);
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error){
            view.loadData("maaf nyalakan koneksi internet anda", "text/html","utf-8");
            super.onReceivedError(view, request, error);
        }

        @Override
        public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse){
            view.loadData("maaf nyalakan koneksi internet anda", "text/html","utf-8");
            super.onReceivedHttpError(view, request, errorResponse);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()){
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

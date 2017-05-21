package com.bit.biteie;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bit.biteie.R;

public class GalleryActivity extends AppCompatActivity {


    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.buttoncolordark));
            window.setNavigationBarColor(getResources().getColor(R.color.buttoncolordark));
        }

        setContentView(R.layout.activity_gallery);



        webView = (WebView) findViewById(R.id.webview_gallery);


        webView.loadUrl("https://drive.google.com/drive/folders/0B9Fi_mvltTeXaGxDa0IxeE5hRlU?usp=sharing");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSaveFormData(true);

        webView.getSettings().setBuiltInZoomControls(true);

        webView.setWebViewClient(new MyWebViewClient());
    }

    private class MyWebViewClient extends WebViewClient
    {
        @Override

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl (url);
            return true;
        }
    }


}

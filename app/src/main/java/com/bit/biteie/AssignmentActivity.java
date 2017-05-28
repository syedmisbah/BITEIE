package com.bit.biteie;

import android.graphics.Bitmap;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class AssignmentActivity extends AppCompatActivity {

    private WebView webView;
    private ProgressBar spinner;

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

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_assignment);

        String semTitle = getIntent().getStringExtra(SemSelAssignment.EXTRA_ITEM_TITLE);


        spinner=(ProgressBar)findViewById(R.id.progressBarAssgn);
        webView = (WebView) findViewById(R.id.assignment_web);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new myWebclient());
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);


        if (semTitle.equalsIgnoreCase(SemSelAttn.semester_3))
        {
            webView.loadUrl("https://drive.google.com/drive/folders/0B9Fi_mvltTeXVDdoLTRycHlhc00");
        }

        else if (semTitle.equalsIgnoreCase(SemSelAttn.semester_4))
        {
            webView.loadUrl("https://drive.google.com/drive/folders/0B9Fi_mvltTeXUDNKZ0V4NXNOZU0");
        }

        else if (semTitle.equalsIgnoreCase(SemSelAttn.semester_5))
        {
            webView.loadUrl("https://drive.google.com/drive/folders/0B9Fi_mvltTeXeWFKaHdDaUw2ZzQ");
        }

        else if (semTitle.equalsIgnoreCase(SemSelAttn.semester_6)) {
            webView.loadUrl("https://drive.google.com/drive/folders/0B9Fi_mvltTeXRFowWExhR0sycHM");
        }

        else if (semTitle.equalsIgnoreCase(SemSelAttn.semester_7)) {
                webView.loadUrl("https://drive.google.com/drive/folders/0B9Fi_mvltTeXWXFSb2x3anRCd00");
            }

        else {
                webView.loadUrl("https://drive.google.com/drive/folders/0B9Fi_mvltTeXbFlSeXJPTUxHYXc");
            }

        }

            public class myWebclient extends WebViewClient {
                @Override
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);
                    spinner.setVisibility(View.GONE);
                }

                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    super.onPageStarted(view, url, favicon);
                }
            }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.webView.canGoBack()) {
            this.webView.goBack();
          //  webView.loadUrl( "javascript:window.location.reload(true)");
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}


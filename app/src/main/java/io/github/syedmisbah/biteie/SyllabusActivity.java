package io.github.syedmisbah.biteie;

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

public class SyllabusActivity extends AppCompatActivity {

    private WebView webView = null;
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
        setContentView(R.layout.activity_syllabus);
        spinner=(ProgressBar)findViewById(R.id.progressBar3);


        String semTitle = getIntent().getStringExtra(SemSelSyl.EXTRA_ITEM_TITLE);



        webView = (WebView) findViewById(R.id.syllabus_web);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new myWebclient());
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);

        if (semTitle.equalsIgnoreCase(SemSelAttn.semester_3))
        {
            webView.loadData((getString(R.string.url_syl_3)),"text/html", "UTF-8");
        }

        else if (semTitle.equalsIgnoreCase(SemSelAttn.semester_4))
        {
            webView.loadData((getString(R.string.url_syl_4)),"text/html", "UTF-8");
        }

        else if (semTitle.equalsIgnoreCase(SemSelAttn.semester_5))
        {
            webView.loadData((getString(R.string.url_syl_5)),"text/html", "UTF-8");
        }

        else if (semTitle.equalsIgnoreCase(SemSelAttn.semester_6))
        {
            webView.loadData((getString(R.string.url_syl_6)),"text/html", "UTF-8");
        }

        else if (semTitle.equalsIgnoreCase(SemSelAttn.semester_7))
        {
            webView.loadData((getString(R.string.url_syl_7)),"text/html", "UTF-8");
        }

        else
        {
            webView.loadData((getString(R.string.url_syl_8)),"text/html", "UTF-8");
        }


    }

    public class myWebclient extends WebViewClient{
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
            webView.loadUrl( "javascript:window.location.reload(true)");
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}







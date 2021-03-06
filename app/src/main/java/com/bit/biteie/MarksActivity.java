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


        public class MarksActivity extends AppCompatActivity {

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
                setContentView(R.layout.activity_marks);

                String semTitle = getIntent().getStringExtra(SemSelAssignment.EXTRA_ITEM_TITLE);



                spinner=(ProgressBar)findViewById(R.id.MarksBar3);
                webView = (WebView) findViewById(R.id.marks_web);
                WebSettings webSettings = webView.getSettings();
                webSettings.setJavaScriptEnabled(true);
                webView.setWebViewClient(new myWebclient());
                webSettings.setBuiltInZoomControls(true);
                webSettings.setSupportZoom(true);
                webSettings.setLoadWithOverviewMode(true);
                webSettings.setUseWideViewPort(true);

               // String sem8 = "<html><iframe src='https://docs.google.com/spreadsheets/d/1PNICkcRg1BE_bVMXRqr2Q841wC4HJ9EPhnptR4zmZZ0/pubhtml?gid=908056700&single=true'&embedded='true' width='1080' height='1600' frameborder='0'></iframe></html>";
                //String sem6 = "<html><iframe src='https://docs.google.com/spreadsheets/d/11xqK-0cK-04LU890Zv0fFCqW7_v62rLsbrP-7IIJefc/pubhtml?gid=1115472232&single=true'&embedded='true' width='1080' height='1600' frameborder='0'></iframe></html>";
                //String sem4 = "<html><iframe src='https://docs.google.com/spreadsheets/d/11xqK-0cK-04LU890Zv0fFCqW7_v62rLsbrP-7IIJefc/pubhtml?gid=1474507528&single=true'&embedded='true' width='100%' height='1600' frameborder='0'></iframe></html>";


                String url_mks_3 = "";
                String url_mks_4 = "<html><iframe src='https://docs.google.com/spreadsheets/d/1b5V9ZAat1Fh_-bPo-kg4FfnPFFMGuo_b6FWe3QgdAvU/pubhtml?gid=922440599&amp;single=true'&amp;embedded='true' width='100%' height='100%'></iframe></html>";
                String url_mks_5 = "";
                String url_mks_6 = "<html><iframe src='https://docs.google.com/spreadsheets/d/1b5V9ZAat1Fh_-bPo-kg4FfnPFFMGuo_b6FWe3QgdAvU/pubhtml?gid=911002700&single=true'&amp;embedded='true' width='100%' height='100%'></iframe></html>";
                String url_mks_7 = "";
                String url_mks_8 = "<html><iframe src='https://docs.google.com/spreadsheets/d/1b5V9ZAat1Fh_-bPo-kg4FfnPFFMGuo_b6FWe3QgdAvU/pubhtml?gid=1631946162&single=true'&amp;embedded='true' width='100%' height='100%'></iframe></html>";




                if (semTitle.equalsIgnoreCase(SemSelAttn.semester_3))
                {
                    webView.loadData(url_mks_3,"text/html", "UTF-8");
                }

                else if (semTitle.equalsIgnoreCase(SemSelAttn.semester_4))
                {
                    webView.loadData(url_mks_4,"text/html", "UTF-8");
                }

                else if (semTitle.equalsIgnoreCase(SemSelAttn.semester_5))
                {
                    webView.loadData(url_mks_5,"text/html", "UTF-8");
                }

                else if (semTitle.equalsIgnoreCase(SemSelAttn.semester_6))
                {
                    webView.loadData(url_mks_6,"text/html", "UTF-8");
                }

                else if (semTitle.equalsIgnoreCase(SemSelAttn.semester_7))
                {
                    webView.loadData(url_mks_7,"text/html", "UTF-8");
                }

                else
                {
                    webView.loadData(url_mks_8,"text/html", "UTF-8");
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

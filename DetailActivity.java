package arr.com.retrofit2;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.Toolbar;

public class DetailActivity extends Activity {
        WebView webView;
        Toolbar toolbar;
        ProgressBar progressBar;
ProgressBar pd;
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        webView=findViewById(R.id.webview);
        progressBar=findViewById(R.id.progressbar);
        toolbar=findViewById(R.id.toolbar);

        setActionBar(toolbar);
        webView.setVisibility(View.INVISIBLE);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebChromeClient(new WebChromeClient());


        webView.setWebViewClient(new WebViewClient()
        {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                webView.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
                Toast.makeText(DetailActivity.this, "Start Loading", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Toast.makeText(DetailActivity.this, "Page Loaded", Toast.LENGTH_SHORT).show();
            }
        });
        webView.loadUrl(getIntent().getStringExtra("url"));





    }
}

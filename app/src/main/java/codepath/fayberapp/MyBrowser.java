package codepath.fayberapp;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import activities.FayActivity;

public class MyBrowser extends AppCompatActivity {
    private WebView myWebView;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_browser);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        pd = new ProgressDialog(this);
        pd.setTitle("Localisation en cours...");
        pd.setMessage(".....");
        pd.setCancelable(false);
        pd.show();

        myWebView =  findViewById(R.id.webview);
        // Configure related browser settings
        myWebView.getSettings().setLoadsImagesAutomatically(true);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        // Configure the client to use when opening URLs
        myWebView.setWebViewClient(new MyWebBrowser());
        // the initial URL
        myWebView.loadUrl("https://goo.gl/maps/xkks3n16G3t");

        myWebView.getSettings().setSupportZoom(true);
        myWebView.getSettings().setBuiltInZoomControls(true); // allow pinch to zooom
        myWebView.getSettings().setDisplayZoomControls(false); // disable the default zoom controls on the page
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Respond to the action bar's Up/Home button to the home page with (finishAffinity)
                Intent i = new Intent(MyBrowser.this, FayActivity.class);
                startActivity(i);
                finishAffinity();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Manages the behavior when URLs are loaded
    private class MyWebBrowser extends WebViewClient {
        @SuppressWarnings("deprecation")
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @TargetApi(Build.VERSION_CODES.N)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Toast.makeText(MyBrowser.this, "!!!", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            pd.dismiss();
            Toast.makeText(MyBrowser.this, "Ok!!!", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPageCommitVisible(WebView view, String url) {
            super.onPageCommitVisible(view, url);
        }
    }
}

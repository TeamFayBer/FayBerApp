package codepath.fayberapp;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import activities.FayActivity;
import activities.TeamFayBerActivity;

public class AproposActivity extends AppCompatActivity {
    TextView tvApropos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apropos);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tvApropos = (TextView) findViewById(R.id.tvApropos);
    }

    public void onFacebookClick(View view){
        if(isFacebookInstalled()){
            Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.facebook.katana");
            startActivity( LaunchIntent );
        }else if(isLiteInstalled()){
            Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.facebook.lite");
            startActivity( LaunchIntent );
        }else{
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://web.facebook.com/SoinsInfirmiersAdomicileDispoEnHAITI"));
            if (browserIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(browserIntent);
            }
        }
    }

    public boolean isFacebookInstalled() {
        try {
            getApplicationContext().getPackageManager().getApplicationInfo("com.facebook.katana", 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public boolean isLiteInstalled() {
        try {
            getApplicationContext().getPackageManager().getApplicationInfo("com.facebook.lite", 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    //com.twitter.android onTwitterClick
    public void onTwitterClick(View view){
        if(isTwitterInstalled()){
            Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.twitter.android");
            startActivity( LaunchIntent );
        }else{
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/FayBerNCA_SIAD"));
            if (browserIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(browserIntent);
            }
        }
    }

    public boolean isTwitterInstalled() {
        try {
            getApplicationContext().getPackageManager().getApplicationInfo("com.twitter.android", 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    //com.google.android.youtube onYoutubeClick
    public void onYoutubeClick(View view){
        if(isYoutubeInstalled()){
            Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");
            startActivity( LaunchIntent );
        }else{
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCwt6hkZiRc5nD47gkBrKb7Q"));
            if (browserIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(browserIntent);
            }
        }
    }

    public boolean isYoutubeInstalled() {
        try {
            getApplicationContext().getPackageManager().getApplicationInfo("com.google.android.youtube", 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    //com.google.android.apps.plus onPlusClick
    public void onPlusClick(View view){
        if(isPlusInstalled()){
            Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.plus");
            startActivity( LaunchIntent );
        }else{
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.ht/search?q=fayber+nursing+care+agency"));
            if (browserIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(browserIntent);
            }
        }
    }

    public boolean isPlusInstalled() {
        try {
            getApplicationContext().getPackageManager().getApplicationInfo("com.google.android.apps.plus", 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Respond to the action bar's Up/Home button to the home page with (finishAffinity)
                Intent i = new Intent(AproposActivity.this, FayActivity.class);
                startActivity(i);
                finishAffinity();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

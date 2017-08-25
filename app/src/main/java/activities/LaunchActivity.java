package activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import codepath.fayberapp.R;


public class LaunchActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(LaunchActivity.this, FayActivity.class);
                startActivity(i);
            }
        },2000);
    }
    public void onSuccess() {
        Intent i = new Intent(this, FayActivity.class);
        startActivity(i);
        Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show();
    }
}

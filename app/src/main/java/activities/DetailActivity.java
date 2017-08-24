package activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import codepath.fayberapp.R;

public class DetailActivity extends AppCompatActivity {


    TextView tvText;
    ImageView ImageItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        tvText = (TextView) findViewById(R.id.tvDetails);
        ImageItem = (ImageView) findViewById(R.id.ivImage1);
    }
    public void onLogButton() {
        Intent i = new Intent(this, SignInActivity.class);
        startActivity(i);
    }
}

package activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import codepath.fayberapp.R;

public class DetailsActivity extends AppCompatActivity {


    TextView tvText;
    ImageView ImageItem;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        tvText = (TextView) findViewById(R.id.tvDetails);
        ImageItem = (ImageView) findViewById(R.id.ivImage1);
        button = (Button) findViewById(R.id.btnRegister);
    }

    public void onLogButton(View v) {
        Intent i = new Intent(DetailsActivity.this, SignInActivity.class);
        startActivity(i);
    }
}

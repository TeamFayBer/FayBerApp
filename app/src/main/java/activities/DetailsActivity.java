package activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import codepath.fayberapp.R;

public class DetailsActivity extends AppCompatActivity {

    TextView tvText;
    ImageView ImageItem;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        tvText = (TextView) findViewById(R.id.tvDetails);
         ImageItem = (ImageView) findViewById(R.id.ivImage1);
    }

}

package codepath.fayberapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AproposActivity extends AppCompatActivity {

    TextView tvApropos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apropos);

        tvApropos = (TextView) findViewById(R.id.tvApropos);
    }
}

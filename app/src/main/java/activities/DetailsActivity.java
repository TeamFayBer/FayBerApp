package activities;

import android.app.SharedElementCallback;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.TextView;

import Models.Services;
import codepath.fayberapp.R;

public class DetailsActivity extends AppCompatActivity {
    TextView tvText;
    TextView titre;
    ImageView ImageItem;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        //Display the Up button home
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);
        //Call a differents page,not the same
        Services serv = (Services) getIntent().getSerializableExtra("services");

        tvText = (TextView) findViewById(R.id.tvDetails);
        tvText.setText(serv.getDetails().toString());
        titre = (TextView) findViewById(R.id.tvtitle4detail);
        titre.setText(serv.getTitle().toString());
        ImageItem = (ImageView) findViewById(R.id.ivImage1);
        ImageItem.setImageResource(serv.getImage());
        button = (Button) findViewById(R.id.btnRegister);
    }
   public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.icon_share, menu);
        return true;
    }
    //onClick in icon share
    public void onShareAction(MenuItem mi) {
        // handle click here
    }
    //navigate to SignUp activity
    public void onLogButton(View v) {
        Intent i = new Intent(DetailsActivity.this, SignInActivity.class);
        startActivity(i);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Respond to the action bar's Up/Home button
                finish();
                return true;
            case R.id.miShare:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

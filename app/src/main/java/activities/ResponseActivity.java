package activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import codepath.fayberapp.R;

public class ResponseActivity extends AppCompatActivity {

    EditText etName;
    EditText etPhono;
    EditText etMaili;
    EditText etMessagi;
    Button btnEnvoyi;
    TextView tvContacti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);
        //Display up button to home page
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        etName = (EditText) findViewById(R.id.etNomComplet);
        etPhono = (EditText) findViewById(R.id.etPhone);
        etMaili = (EditText) findViewById(R.id.etMail);
        etMessagi = (EditText) findViewById(R.id.etMessage);
        btnEnvoyi = (Button) findViewById(R.id.btnEnvoyer);
        tvContacti = (TextView) findViewById(R.id.tvContact);

        btnEnvoyi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ResponseActivity.this, FayActivity.class);
                startActivity(i);
            }
        });
    }
    public void onLogButton(View v) {
        Intent i = new Intent(ResponseActivity.this, FayActivity.class);
        startActivity(i);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Respond to the action bar's Up/Home button to the home page with (finishAffinity)
                Intent i = new Intent(ResponseActivity.this, FayActivity.class);
                startActivity(i);
                finishAffinity();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

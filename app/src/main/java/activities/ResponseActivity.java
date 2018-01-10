package activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
      //  etName.getText().clear();

        etPhono = (EditText) findViewById(R.id.etPhone);
       // etPhono.getText().clear();

        etMaili = (EditText) findViewById(R.id.etMail);
     //   etMaili.getText().clear();

        etMessagi = (EditText) findViewById(R.id.etMessage);
       // etMessagi.getText().clear();

        btnEnvoyi = (Button) findViewById(R.id.btnEnvoyer);
        tvContacti = (TextView) findViewById(R.id.tvContact);

        btnEnvoyi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ResponseActivity.this, FayActivity.class);
                startActivity(i);
                sendSMS();
            }
        });
    }
    public void  sendSMS(){
        String body = etName.getText().toString()
                + "\n" + etMaili.getText().toString()
                + "\n" + etPhono.getText().toString()
                + "\n" + etMessagi.getText().toString();

        try{
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage("36893514", null, body, null, null);
            Toast.makeText(ResponseActivity.this, "Message envoyé", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(ResponseActivity.this, "erreur", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
    public void onLogButton(View v) {
        if (etName.getText().toString().equals("") && etMessagi.getText().toString().equals("") &&
                etPhono.getText().toString().equals("") && etMaili.getText().toString().equals(""))
        {
            Toast.makeText(this, "un ou plusieurs champ(s) sont vides", Toast.LENGTH_SHORT).show();
        } else {
           sendSMS();
        }
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

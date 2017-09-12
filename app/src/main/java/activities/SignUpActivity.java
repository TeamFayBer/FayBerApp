package activities;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import codepath.fayberapp.R;

public class SignUpActivity extends AppCompatActivity {

    EditText edT;
    EditText edT1;
    EditText edT2;
    EditText edT3;
    EditText edT4;
    JSONArray articleJsonResults;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
      //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      //  setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //create notification
       edT = (EditText) findViewById(R.id.etNomComplet);
        edT1 = (EditText) findViewById(R.id.etPhone);
        edT2 = (EditText) findViewById(R.id.etIdentif);
        edT3 = (EditText) findViewById(R.id.etMail);
         edT4 = (EditText) findViewById(R.id.etPass);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Respond to the action bar's Up/Home button
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void onLogButton(View v) {

        if (edT.getText().toString().equals("") && edT1.getText().toString().equals("") &&
                edT2.getText().toString().equals("") && edT3.getText().toString().equals("") && edT4.getText().toString().equals("")) {
            Toast.makeText(this, "un ou plusieyur s sont vides", Toast.LENGTH_SHORT).show();
        } else {
            getInfoRegisterUser();
        }
        //Get an instance of NotificationManager//

        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.notification_icon)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!");

        // Gets an instance of the NotificationManager service//

        NotificationManager mNotificationManager =

                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

//When you issue multiple notifications about the same type of event, it’s best practice for your app to try to update an existing notification with this new information, rather than immediately creating a new notification. If you want to update this notification at a later date, you need to assign it an ID. You can then use this ID whenever you issue a subsequent notification. If the previous notification is still visible, the system will update this existing notification, rather than create a new one. In this example, the notification’s ID is 001//

        //NotificationManager.notify().

                mNotificationManager.notify(001, mBuilder.build());
    }
    public void getInfoRegisterUser(){

        String url = "http://fayberagency.com/v1/app/login_user.php";
        AsyncHttpClient client = new AsyncHttpClient();

        RequestParams params = new RequestParams();
        params.put("nom_client", edT.getText().toString());
        params.put("password_client", edT4.getText().toString());
        params.put("telephone_client", edT1.getText().toString());
        params.put("username_client", edT2.getText().toString());
        params.put("email_client", edT3.getText().toString());
        client.post(url,params, new JsonHttpResponseHandler(){

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONObject response) {
                //JSONArray articleJsonResults = null;
                articleJsonResults = null;
                try {

                    Object objectlogin = response.get("response");
                    if (objectlogin instanceof JSONArray) {
                        articleJsonResults = response.getJSONArray("response");
                        Intent i = new Intent(SignUpActivity.this, FicheDemandeActivity.class);
                        i.putExtra("nom_client", edT.getText().toString());
                        i.putExtra("telephone_client", edT1.getText().toString());
                        i.putExtra("email_client", edT3.getText().toString());
                        i.putExtra("username_client", edT2.getText().toString());
                        startActivity(i);
                        Toast.makeText(SignUpActivity.this, "hello user...", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(SignUpActivity.this, "Verifier nom utilisateur et mot de pass", Toast.LENGTH_SHORT).show();
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(SignUpActivity.this, "Verifier nom utilisateur et mot de pass", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

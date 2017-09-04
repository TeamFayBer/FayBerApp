package activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import codepath.fayberapp.R;
import cz.msebera.android.httpclient.entity.mime.Header;

public class SignInActivity extends AppCompatActivity {

    EditText edText;
    EditText edText1;
    Button but;
    Button but1;
    TextView text;
    TextView text1;
    ImageView Pic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //   setSupportActionBar(toolbar);

        edText = (EditText) findViewById(R.id.etIdentif);
        edText1 = (EditText) findViewById(R.id.etPass);
        text = (TextView) findViewById(R.id.tvForgot);
        text1 = (TextView) findViewById(R.id.tvOr);
        Pic = (ImageView) findViewById(R.id.ivSignIn);
        but = (Button) findViewById(R.id.btnSignUp);
        but1 = (Button) findViewById(R.id.btnSignIn1);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(i);
            }
        });
    }

    public void onLogButton(View v) {
        if(edText.getText().toString().equals("") && edText1.getText().toString().equals("")){
            Toast.makeText(this, "un ou plusieyur s sont vides", Toast.LENGTH_SHORT).show();
        }else{
            getInfoLoginUser();
        }
        //Intent i = new Intent(SignInActivity.this, FicheDemandeActivity.class);
        //startActivity(i);
    }

    public void getInfoLoginUser(){
        String url = "http://fayberagency.com/v1/app/login_user.php";
        AsyncHttpClient client = new AsyncHttpClient();

        RequestParams params = new RequestParams();
        params.put("user_name", edText.getText().toString());
        params.put("user_password", edText1.getText().toString());
        client.post(url,params, new JsonHttpResponseHandler(){

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONObject response) {
                JSONArray articleJsonResults = null;
                try {

                    Object objectlogin = response.get("response");
                    if (objectlogin instanceof JSONArray) {
                        articleJsonResults = response.getJSONArray("response");
                        Intent i = new Intent(SignInActivity.this, FicheDemandeActivity.class);
                        i.putExtra("id_client", articleJsonResults.getJSONObject(0).getString("id_client"));
                        i.putExtra("nom_client", articleJsonResults.getJSONObject(0).getString("nom_client"));
                        i.putExtra("telephone_client", articleJsonResults.getJSONObject(0).getString("telephone_client"));
                        i.putExtra("email_client", articleJsonResults.getJSONObject(0).getString("email_client"));
                        i.putExtra("username_client", articleJsonResults.getJSONObject(0).getString("username_client"));
                        //startActivity(i);
                        Toast.makeText(SignInActivity.this, "hello user...", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(SignInActivity.this, "Verifier nom utilisateur et mot de pass", Toast.LENGTH_SHORT).show();
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(SignInActivity.this, "Verifier nom utilisateur et mot de pass", Toast.LENGTH_SHORT).show();
            }
        });
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
}
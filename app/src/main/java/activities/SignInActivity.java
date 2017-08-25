package activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import codepath.fayberapp.R;

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
        edText = (EditText) findViewById(R.id.etIdentif);
        edText1 = (EditText) findViewById(R.id.etPass);
        text = (TextView) findViewById(R.id.tvForgot);
        text1 = (TextView) findViewById(R.id.tvOr);
        Pic = (ImageView) findViewById(R.id.ivSignIn);
        but = (Button) findViewById(R.id.btnSignUp);
        but1 = (Button) findViewById(R.id.btnSignIn1);
    }
}

package Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import codepath.fayberapp.R;


public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
    }


    public void onLoginImage(View v) {
        Intent i = new Intent(this, FayActivity.class);
        startActivity(i);
        Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show();
    }


}

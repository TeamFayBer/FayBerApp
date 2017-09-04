package codepath.fayberapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import Models.Equipe;
import Models.Partenaires;
import activities.EquipeArrayAdapter;
import activities.FayActivity;
import activities.TeamFayBerActivity;

public class PartenaireActivity extends AppCompatActivity {
    ImageView ivPartenaires1, ivPartenaires2, ivPartenaires3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partenaire);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // call the listview
        ivPartenaires1 = (ImageView) findViewById(R.id.ivPartenaires1);
        ivPartenaires2 = (ImageView) findViewById(R.id.ivPartenaires2);
        ivPartenaires3 = (ImageView) findViewById(R.id.ivPartenaires3);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Respond to the action bar's Up/Home button to the home page with (finishAffinity)
                Intent i = new Intent(PartenaireActivity.this, FayActivity.class);
                startActivity(i);
                finishAffinity();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

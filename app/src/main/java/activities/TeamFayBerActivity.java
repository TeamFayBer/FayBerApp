package activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import Models.Equipe;
import codepath.fayberapp.R;

public class TeamFayBerActivity extends AppCompatActivity {
    EquipeArrayAdapter equipeAdapter;
    ArrayList<Equipe> aEquipe;
    ListView lvEquipe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_fay_ber);
        // call the listview
        lvEquipe = (ListView) findViewById(R.id.lvEquipe);
        // onclick in the listview for seeing the details
        lvEquipe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Equipe equipe = (Equipe) lvEquipe.getItemAtPosition(position);
                //   Toast.makeText(FayActivity.this, "Pas data to see details of service", Toast.LENGTH_SHORT).show();
                //Intent i = new Intent(TeamFayBerActivity.this, FayActivity.class);
                //i.putExtra("Equipe", equipe);
               // startActivity(i);

                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setDisplayShowHomeEnabled(true);
                //map
                // map = (ImageView) findViewById(R.id.mapView);
            }
        });

        aEquipe = new ArrayList<>();
        equipeAdapter = new EquipeArrayAdapter(TeamFayBerActivity.this, aEquipe);
        lvEquipe.setAdapter(equipeAdapter);

        equipeAdapter.addAll(Equipe.fromFakeData());
        equipeAdapter.notifyDataSetChanged();
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Respond to the action bar's Up/Home button to the home page with (finishAffinity)
                Intent i = new Intent(TeamFayBerActivity.this, FayActivity.class);
                startActivity(i);
                finishAffinity();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

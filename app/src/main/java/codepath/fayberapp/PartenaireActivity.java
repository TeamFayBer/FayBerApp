package codepath.fayberapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import Models.Equipe;
import Models.Partenaires;
import activities.EquipeArrayAdapter;
import activities.TeamFayBerActivity;

public class PartenaireActivity extends AppCompatActivity {
    /*PartenairesArrayAdapter PartenairesAdapter;
    ArrayList<Partenaires> aPartenaires;
    ListView lvPartenaires; */
    ImageView ivPartenaires1, ivPartenaires2, ivPartenaires3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partenaire);

        // call the listview
        ivPartenaires1 = (ImageView) findViewById(R.id.ivPartenaires1);
        ivPartenaires2 = (ImageView) findViewById(R.id.ivPartenaires2);
        ivPartenaires3 = (ImageView) findViewById(R.id.ivPartenaires3);
        // onclick in the listview for seeing the details
        /*lvPartenaires.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //Partenaires Partenaires = (Partenaires) lvPartenaires.getItemAtPosition(position);
                //   Toast.makeText(FayActivity.this, "Pas data to see details of service", Toast.LENGTH_SHORT).show();
                //Intent i = new Intent(TeamFayBerActivity.this, FayActivity.class);
                //i.putExtra("Equipe", equipe);
                // startActivity(i);
            }
        }); */

       /* aPartenaires = new ArrayList<>();
        PartenairesAdapter = new PartenairesArrayAdapter(PartenairesActivity.this, aPartenaires);
        lvPartenaires.setAdapter(PartenairesAdapter);

        PartenairesAdapter.addAll(Equipe.fromFakeData());
        PartenairesAdapter.notifyDataSetChanged();  */
    }
}

package activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Models.Services;
import codepath.fayberapp.R;

import static android.os.Build.VERSION_CODES.M;

public class FicheDemandeActivity extends AppCompatActivity implements OnItemSelectedListener {

    Button btnenvoyer;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiche_demande);
        //Display the up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        btnenvoyer = (Button) findViewById(R.id.btnEnvoyer);

        btnenvoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                senMail();
            }
        });

        // Spinner element
        spinner = (Spinner) findViewById(R.id.spiSexe);
        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Sexe");
        categories.add("M");
        categories.add("F");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        if(item.equals("Sexe")){
        }
    }


    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
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
        if(spinner.getSelectedItem().toString()!="Sexe"){
            Services serv = (Services) getIntent().getSerializableExtra("serv");
            Intent i = new Intent(FicheDemandeActivity.this, FayActivity.class);
            startActivity(i);
            Toast.makeText(this, "Sous peu, vous recevrez un message relatif à votre demande: "+serv.getTitle()+" \n"+serv.getDetails(), Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Select sex", Toast.LENGTH_SHORT).show();
        }
    }

    public void senMail(){
        Services serv = (Services) getIntent().getSerializableExtra("services");
        String nom_client=getIntent().getStringExtra("nom_client");
        String telephone_client=getIntent().getStringExtra("telephone_client");
        String email_client=getIntent().getStringExtra("email_client");

        String uriText = "mailto:fayber.nursingcareagency@gmail.com" +
                "?subject="+ Uri.encode("Demande d'aide") +
                "&body="+Uri.encode("Service Demande:\t"+serv.getTitle()+"\n Description Service:\t"+serv.getDetails()
                        +"\nNom Client:\t"+nom_client+"\nTelephone Client:\t"+telephone_client+"\nEmail Client:\t"+email_client);
        Uri uri = Uri.parse(uriText);
        Intent send = new Intent(Intent.ACTION_SENDTO);
        send.setData(uri);
        if(send.resolveActivity(getPackageManager()) != null){
            startActivity(Intent.createChooser(send, "Send email"));
        }
    }
}

package activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Models.Services;
import codepath.fayberapp.R;

public class FicheDemandeActivity extends AppCompatActivity implements OnItemSelectedListener {

    Button btnenvoyer;
    Spinner spinner, spin;
    EditText  mTodayDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiche_demande);
        //Display the up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        btnenvoyer = (Button) findViewById(R.id.btnEnvoyer);

        // Spinner element
        spinner = (Spinner) findViewById(R.id.spiSexe);
        spin = (Spinner) findViewById(R.id.spiGroudSanguin);
        // Spinner click listener
        spinner.setOnItemSelectedListener(this);
        spin.setOnItemSelectedListener(this);


        // Spinner Drop down elements
        List<String> categories1 = new ArrayList<String>();
        categories1.add("Groupe Sanguin");
        categories1.add("O+");
        categories1.add("O-");
        categories1.add("A+");
        categories1.add("A-");
        categories1.add("B+");
        categories1.add("B+");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories1);

        // Drop down layout style - list view with radio button
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spin.setAdapter(dataAdapter1);

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

        mTodayDate = (EditText)findViewById(R.id.etDate);

        //Get or Generate Date
        Date todayDate = new Date();

        //Get an instance of the formatter
        DateFormat dateFormat = DateFormat.getDateTimeInstance();

        //If you want to show only the date then you will use
        //DateFormat dateFormat = DateFormat.getDateInstance();

        //Format date
        String todayDateTimeString = dateFormat.format(todayDate);

        //display Date
        mTodayDate.setText(todayDateTimeString);
        //Button
        btnenvoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(spinner.getSelectedItem().toString()!="Sexe"){
                    senMail();
                }else{
                    Toast.makeText(getApplicationContext(), "Select sex", Toast.LENGTH_SHORT).show();
                }
            }
        });

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

    public void senMail(){
        Services serv = (Services) getIntent().getSerializableExtra("services");
        String nom_client=getIntent().getStringExtra("nom_client");
        String telephone_client=getIntent().getStringExtra("telephone_client");
        String email_client=getIntent().getStringExtra("email_client");

      //  Toast.makeText(getApplicationContext(), "Sous peu, vous recevrez un message relatif à votre demande: "+serv.getTitle()+" \n"+serv.getDetails(), Toast.LENGTH_LONG).show();

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

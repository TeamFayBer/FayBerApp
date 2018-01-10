package activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Models.Services;
import codepath.fayberapp.R;

public class FicheDemandeActivity extends AppCompatActivity implements OnItemSelectedListener {

    Button btnenvoyer;
    Spinner spinner, spin;
    EditText  mTodayDate, etAdresse, etMaladie, etMedecin, etContactMedecin ;
    SharedPreferences sharedPreferences ;
    SharedPreferences.Editor editor ;
    String sexe,gSanguin,theDate,adresse,maladie,medecin,contactMedecin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiche_demande);
        //Display the up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        sharedPreferences = getSharedPreferences("PreferencesTAG", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        if(sharedPreferences.getString("nom_client", null).length()>5){
            getSupportActionBar().setTitle("Fiche Demande : "+sharedPreferences.getString("nom_client", null).substring(0,6)+"...");
        }else{
            getSupportActionBar().setTitle("Fiche Demande : "+sharedPreferences.getString("nom_client", null));
        }


        btnenvoyer = (Button) findViewById(R.id.btnEnvoyer);
        etAdresse = (EditText) findViewById(R.id.etAdresse);
        etMaladie = (EditText) findViewById(R.id.etMaladie);
        etMedecin = (EditText) findViewById(R.id.etMedecin);
        etContactMedecin = (EditText) findViewById(R.id.etContactMedecin);


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

        Calendar cal = Calendar.getInstance();
        Date currentDate = cal.getTime();

        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String formattedDateString = formatter.format(currentDate);
        mTodayDate.setText(formattedDateString);


        //Button
        btnenvoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//Groupe Sanguin
                if(spinner.getSelectedItem().toString()!="Sexe" || spin.getSelectedItem().toString()!="Groupe Sanguin"){
                    //etAdresse, etMaladie, etMedecin, etContactMedecin
                    if(mTodayDate.getText().toString().equals("") || etAdresse.getText().toString().equals("") || etMaladie.getText().toString().equals("") || etMedecin.getText().toString().equals("")  || etContactMedecin.getText().toString().equals("") ){
                        Toast.makeText(FicheDemandeActivity.this, "Des champs sont vides...", Toast.LENGTH_SHORT).show();
                    }else{
                        sexe = spinner.getSelectedItem().toString();
                        gSanguin = spin.getSelectedItem().toString();
                        theDate = mTodayDate.getText().toString();
                        adresse = etAdresse.getText().toString();
                        maladie = etMaladie.getText().toString();
                        medecin = etMedecin.getText().toString();
                        contactMedecin = etContactMedecin.getText().toString();
                        saveDemandClient(sexe,gSanguin,theDate,adresse,maladie,medecin,contactMedecin);
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Select sex ou GS", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void saveDemandClient(String sexe, String gSanguin, String theDate, String adresse, String maladie, String medecin, String contactMedecin) {
        senMail();

        String url = "http://fayberagency.com/v1/app/register_user.php";
        AsyncHttpClient client = new AsyncHttpClient();

        RequestParams params = new RequestParams();
        params.put("nom_client", edT.getText().toString());
        params.put("password_client", edT4.getText().toString());
        params.put("telephone_client", edT1.getText().toString());
        params.put("username_client", edT2.getText().toString());
        params.put("email_client", edT3.getText().toString());
        client.post(url,params, new JsonHttpResponseHandler(){

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
        String nom_client=sharedPreferences.getString("nom_client", null);
        String telephone_client=sharedPreferences.getString("telephone_client", null);
        String email_client=sharedPreferences.getString("email_client", null);

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

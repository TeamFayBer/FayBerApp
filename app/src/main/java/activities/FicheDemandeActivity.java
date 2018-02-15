package activities;

import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import Models.Services;
import codepath.fayberapp.R;
import cz.msebera.android.httpclient.Header;

public class FicheDemandeActivity extends AppCompatActivity implements OnItemSelectedListener {

    Button btnenvoyer;
    Spinner spiSexe, spiGroudSanguin;
    Spinner spHLundi, spHMar, spHMer,spHJeu,spHVend,spHSam,spHDim;
    CheckBox chLun,chMardi,chMercredi,chJeu,chVend,chSam,chDim;
    EditText etAdresse, etRaison, etNomDoc, etTelDoc, etClinicDoc, etAdrDoc;
    String adrClient,raisonClient,docClient,telDocClient,clinicDocClient,adrClinicClient, sexeClient, gsClient, disponibiliteClient;
    SharedPreferences sharedPreferences ;
    SharedPreferences.Editor editor ;
    JSONArray articleJsonResults;
    ProgressDialog progressDialog;
    Services serv;

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

        progressDialog = new ProgressDialog(FicheDemandeActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Sauvegarde en cours...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);

        // Spinner element
        spiSexe = (Spinner) findViewById(R.id.spiSexe);
        spiGroudSanguin = (Spinner) findViewById(R.id.spiGroudSanguin);
        spHLundi = (Spinner) findViewById(R.id.spHLundi);
        spHMar = (Spinner) findViewById(R.id.spHMar);
        spHMer = (Spinner) findViewById(R.id.spHMer);
        spHJeu = (Spinner) findViewById(R.id.spHJeu);
        spHVend = (Spinner) findViewById(R.id.spHVend);
        spHSam = (Spinner) findViewById(R.id.spHSam);
        spHDim = (Spinner) findViewById(R.id.spHDim);

        chLun = (CheckBox) findViewById(R.id.chLun);
        chMardi = (CheckBox) findViewById(R.id.chMardi);
        chMercredi = (CheckBox) findViewById(R.id.chMercredi);
        chJeu = (CheckBox) findViewById(R.id.chJeu);
        chVend = (CheckBox) findViewById(R.id.chVend);
        chSam = (CheckBox) findViewById(R.id.chSam);
        chDim = (CheckBox) findViewById(R.id.chDim);

        etAdresse = (EditText) findViewById(R.id.etAdresse);
        etRaison = (EditText) findViewById(R.id.etRaison);
        etNomDoc = (EditText) findViewById(R.id.etNomDoc);
        etTelDoc = (EditText) findViewById(R.id.etTelDoc);
        etClinicDoc = (EditText) findViewById(R.id.etClinicDoc);
        etAdrDoc = (EditText) findViewById(R.id.etAdrDoc);

        serv = (Services) getIntent().getSerializableExtra("services");
        // Spinner click listener
        spiSexe.setOnItemSelectedListener(this);
        spiGroudSanguin.setOnItemSelectedListener(this);


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
        spiGroudSanguin.setAdapter(dataAdapter1);

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
        spiSexe.setAdapter(dataAdapter);
/*
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
        mTodayDate.setText(formattedDateString); */


        //Button
        btnenvoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//Groupe Sanguin
                if(spiSexe.getSelectedItem().toString()!="Sexe" || spiGroudSanguin.getSelectedItem().toString()!="Groupe Sanguin"){
                    sexeClient = spiSexe.getSelectedItem().toString();
                    gsClient = spiGroudSanguin.getSelectedItem().toString();
                    if(!etAdresse.getText().toString().equals("") && !etRaison.getText().toString().equals("")){
                        adrClient = etAdresse.getText().toString();
                        raisonClient = etRaison.getText().toString();

                        docClient= etNomDoc.getText().toString();
                        telDocClient= etTelDoc.getText().toString();
                        clinicDocClient= etClinicDoc.getText().toString();
                        adrClinicClient= etAdrDoc.getText().toString();

                        disponibiliteClient = "";
                        if(chLun.isChecked()){
                            disponibiliteClient += "Lundi "+spHLundi.getSelectedItem().toString()+" ; ";
                        }
                        if(chMardi.isChecked()){
                            disponibiliteClient += "Mardi "+spHMar.getSelectedItem().toString()+" ; ";
                        }
                        if(chMercredi.isChecked()){
                            disponibiliteClient += "Mercredi "+spHMer.getSelectedItem().toString()+" ; ";
                        }
                        if(chJeu.isChecked()){
                            disponibiliteClient += "Jeudi "+spHJeu.getSelectedItem().toString()+" ; ";
                        }
                        if(chVend.isChecked()){
                            disponibiliteClient += "Vendredi "+spHVend.getSelectedItem().toString()+" ; ";
                        }
                        if(chSam.isChecked()){
                            disponibiliteClient += "Samedi "+spHSam.getSelectedItem().toString()+" ; ";
                        }
                        if(chDim.isChecked()){
                            disponibiliteClient += "Dimanche "+spHDim.getSelectedItem().toString()+" ; ";
                        }

                        progressDialog.show();
                        saveDemandClient(adrClient,raisonClient,docClient,telDocClient,clinicDocClient,adrClinicClient, sexeClient, gsClient, disponibiliteClient);
                    }

                        // ,,, disponibiliteClient;


                }else{
                    Toast.makeText(getApplicationContext(), "Selectionner sexe ou Groupe Sanguin", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void saveDemandClient(final String adrClient, String raisonClient, String docClient, String telDocClient, String clinicDocClient, String adrClinicClient, String sexeClient, final String gsClient, String disponibiliteClient) {
        //senMail();

        String url = "http://fayberagency.com/v1/app/register_demande.php";
        AsyncHttpClient client = new AsyncHttpClient();

        RequestParams params = new RequestParams();
        params.put("adrClient", adrClient);
        params.put("raisonClient", raisonClient);
        params.put("docClient", docClient);
        params.put("telDocClient", telDocClient);
        params.put("clinicDocClient", clinicDocClient);
        params.put("adrClinicClient", adrClinicClient);
        params.put("sexeClient", sexeClient);
        params.put("gsClient", gsClient);
        params.put("disponibiliteClient", disponibiliteClient);
        params.put("demandID", serv.getId());
        params.put("clientID", sharedPreferences.getString("id_client", null));

        client.post(url,params, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                articleJsonResults = null;
                try {

                    Object objectlogin = response.get("response");
                    System.out.println(objectlogin.toString());
                    if (objectlogin instanceof JSONArray) {
                        articleJsonResults = response.getJSONArray("response");
                        progressDialog.dismiss();
                        if(articleJsonResults.getJSONObject(0).getString("saveClient").equals("success")){
                            notifNewUser(sharedPreferences.getString("nom_client", null),adrClient,gsClient,serv.getTitle());
                        }else{
                            alerteConfirm("essayer a nouveau ","vos informations n'ont pas ete enregistre");
                        }
                    }else{
                        progressDialog.dismiss();
                        alerteConfirm("essayer a nouveau ","vos informations n'ont pas ete enregistre");
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                    progressDialog.dismiss();
                    alerteConfirm("essayer a nouveau ","vos informations n'ont pas ete enregistre");
                }

            }

            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(FicheDemandeActivity.this, "Echec sauvegarde, essayer a nouveau...", Toast.LENGTH_SHORT).show();
                alerteConfirm("Echec Connexion ","vos informations n'ont pas ete enregistre");
                System.out.println(responseString);
                progressDialog.dismiss();
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
    public void onBackPressed() {
        super.onBackPressed();
        // Intent i = new Intent(getApplicationContext(), FayActivity.class);
        // startActivity(i);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Respond to the action bar's Up/Home button
               // Intent i = new Intent(getApplicationContext(), FayActivity.class);
               // startActivity(i);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void senMail(){
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




//Use Timer to reload app every 30 milliseconde
//timerMethod();
    Timer reload = new Timer();
    void timerMethod()
    {
        reload.schedule(new TimerTask() {
            public void run() {
                Log.d("timer", "timer ");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                       //
                    }
                });
            }
        }, 10000, 10000);
//1minutes = 60000 milliseconde
//0,0005minutes = 30 milliseconde
    }


    private void notifNewUser(String nom, String adrClient, String gsClient, String servi) {
        //Get an instance of NotificationManager//
//notifNewUser(sharedPreferences.getString("nom_client", null),adrClient,gsClient,serv.getTitle());
        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcherlogo)
                        .setBadgeIconType(R.mipmap.ic_launcherlogo)
                        .setContentTitle("Fiche demande : "+nom)
                        .setSubText("Service demander :"+servi)
                        .setContentText("Vos Informations :\nAdresse : "+adrClient+"\n Groupe Sanguin : "+gsClient);

        // Gets an instance of the NotificationManager service//
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

//When you issue multiple notifications about the same type of event, it’s best practice for your app to try to update an existing notification with this new information, rather than immediately creating a new notification. If you want to update this notification at a later date, you need to assign it an ID. You can then use this ID whenever you issue a subsequent notification. If the previous notification is still visible, the system will update this existing notification, rather than create a new one. In this example, the notification’s ID is 001//
        //NotificationManager.notify().

        mNotificationManager.notify(001, mBuilder.build());
        startActivity(new Intent(getApplicationContext(), FayActivity.class));
        finishAffinity();
        //edT.getText().clear();

    }


    private void alerteConfirm(final String info, final String desc) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(getApplicationContext());

        progressDialog.dismiss();
        dialog.setTitle("Echec demande : ")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage(info+"\n"+desc)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialoginterface, int i) {
                        dialoginterface.cancel();
                    }
                });
        dialog.show();
    }
}

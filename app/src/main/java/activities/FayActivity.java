package activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import Models.Services;
import adapters.ServiceArrayAdapter;
import codepath.fayberapp.R;

public class FayActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ServiceArrayAdapter serviceAdapter;
    ArrayList<Services> service;
    ListView lvServices;

    //  Button btnItems, btnItems1, btnItems2, btnItems3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fay);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // create data

        Services services = new Services();
        services.setImage(R.mipmap.ic_diete);
        services.setTitle("EDUCATION ET RÉEDUCTION");
        services.setDetails("Soins et procédés visant à assurer l’hygiène corporelle du patient/client et de son environnement.");


        Services services3 = new Services();
        services3.setImage(R.mipmap.ic_hygienecorpor);
        services3.setTitle("PRÉVENTION DE LA MALADIE");
        services3.setDetails("Aide à la prise des médicaments présents sous forme injectable et non injectable, surveillance de leurs effets secondaires.");

        Services services1 = new Services();
        services1.setImage(R.mipmap.ic_assistancemedical);
        services1.setTitle("SOINS DE BASE DE NURSING");
        services1.setDetails("Prélèvement et transfert de spécimen (sang, selles, urines, etc.) aux laboratoires.");

        Services services2 = new Services();
        services2.setImage(R.mipmap.ic_test);
        services2.setTitle("PROMOTION DE LA SANTÉ");
        services2.setDetails("Réalisation des tests rapides (malaria, hémogramme, glycémie, HIV, RPR, et autres.)");

        Services services4 = new Services();
        services4.setImage(R.mipmap.ic_laboratoire);
        services4.setTitle("EDUCATION ET RÉEDUCTION");
        services4.setDetails("Soins et procédés visant à assurer l’hygiène corporelle du patient/client et de son environnement.");

        Services services5 = new Services();
        services5.setImage(R.mipmap.ic_diete);
        services5.setTitle("EDUCATION ET RÉEDUCTION");
        services5.setDetails("Installation de soluté, contrôle de la diurèse horaire et changement de sondes vésicales (Changement de cathéter).");



        lvServices = (ListView) findViewById(R.id.lvServices);


        lvServices.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Services services = (Services) lvServices.getItemAtPosition(position);
            //   Toast.makeText(FayActivity.this, "Pas data to see details of service", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(FayActivity.this, DetailsActivity.class);
                i.putExtra("services", services);
                startActivity(i);
            }
        });
        service = new ArrayList<>();
        serviceAdapter = new ServiceArrayAdapter(FayActivity.this, service);
        lvServices.setAdapter(serviceAdapter);

        serviceAdapter.add(services);
        serviceAdapter.add(services1);
        serviceAdapter.add(services2);
        serviceAdapter.add(services3);
        serviceAdapter.add(services4);
        serviceAdapter.add(services5);

        serviceAdapter.notifyDataSetChanged();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.fay, menu);
        return true;
    }

    public void onLogSuccess() {
        Intent i = new Intent(this, DetailsActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_service) {

        } else if (id == R.id.nav_group) {

        } else if (id == R.id.nav_paramètre) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_contact) {

        } else if (id == R.id.nav_info) {

        } else if (id == R.id.nav_partenaire) {
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}

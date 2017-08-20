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
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import codepath.fayberapp.R;

public class FayActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    // GridView IvItems;
    //  ServiceArrayAdapter serviceAdapter;
    //  ArrayList<Services> service;
    Button btnItems, btnItems1, btnItems2, btnItems3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fay);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnItems = (Button) findViewById(R.id.btnEducation);
        btnItems1 = (Button) findViewById(R.id.btnSoins);
        btnItems2 = (Button) findViewById(R.id.btnPrevention);
        btnItems3 = (Button) findViewById(R.id.btnPromotion);
      /*  service = new ArrayList<>();
        serviceAdapter = new ServiceArrayAdapter(this, service);
        IvItems.setAdapter(serviceAdapter);*/
        // IvItems = (GridView) findViewById(R.id.lvLists);

      /*  String url = "https://apifayberagency.com";

         public void
            public void onSuccess(int statusCode, Header[] headers, JSONObject response)
            {
                JSONArray serviceJson = null;
                try{
                    movieJsonResults = response.getJSONArray("");
                    service.addAll(Services.fromJSONArray(serviceJson));
                    serviceAdapter.notifyDataSetChanged();
                    Log.d("DEBUG", service.toString());
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }*/

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

    public void onLogSuccess() {
        Intent i = new Intent(this, DetailsActivity.class);
        startActivity(i);
    }
}

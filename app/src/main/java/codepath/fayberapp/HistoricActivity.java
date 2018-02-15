package codepath.fayberapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import Models.Historic_demande;
import activities.FayActivity;
import adapters.HistoricArrayAdapter;
import cz.msebera.android.httpclient.Header;

public class HistoricActivity extends AppCompatActivity {

    ProgressBar progress;
    private SwipeRefreshLayout swiperefresh;
    TextView tvError;
    // call the adapter,the listview and the model
    HistoricArrayAdapter serviceAdapter;
    ArrayList<Historic_demande> aServices;
    ListView lvServices;
    JSONArray serviceJsonResults;
    SharedPreferences sharedPreferences ;
    SharedPreferences.Editor editor ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historic);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        progress = (ProgressBar) findViewById(R.id.progress);
        swiperefresh = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);
        tvError = findViewById(R.id.tvError);
        tvError.setVisibility(View.GONE);

        // call the listview
        lvServices = (ListView) findViewById(R.id.lvServices);
        swiperefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                progress.setVisibility(View.VISIBLE);
                getListService();
                swiperefresh.setRefreshing(false);
            }
        });
        // Configure the refreshing colors
        swiperefresh.setColorSchemeResources(android.R.color.holo_red_light,
                android.R.color.holo_orange_dark,
                android.R.color.holo_red_dark);

        progress.setVisibility(View.VISIBLE);

        sharedPreferences = getSharedPreferences("PreferencesTAG", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if(sharedPreferences.getString("nom_client", null).length()>5){
            getSupportActionBar().setTitle("Historique : "+sharedPreferences.getString("nom_client", null).substring(0,6)+"...");
        }else{
            getSupportActionBar().setTitle("Historique : "+sharedPreferences.getString("nom_client", null));
        }

        getListService();
    }

    private void getListService() {
        aServices = new ArrayList<>();
        serviceAdapter = new HistoricArrayAdapter(HistoricActivity.this, aServices);
        lvServices.setAdapter(serviceAdapter);
//http://fayberagency.com/v1/app/liste_demande.php?id=5
        String url = "http://fayberagency.com/v1/app/liste_demande.php?id="+sharedPreferences.getString("id_client", null);
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response)
            {
                //if(objectBon instanceof JSONArray) {
                serviceJsonResults = null;
                try{
                    serviceJsonResults = response.getJSONArray("response");
                    if(serviceJsonResults != null){
                        aServices.addAll(Historic_demande.fromJSONArray(serviceJsonResults));
                        serviceAdapter.notifyDataSetChanged();
                        progress.setVisibility(View.GONE);
                        tvError.setVisibility(View.GONE);
                        Log.d("DEBUG", aServices.toString());
                    }else{
                        tvError.setText("Aucun Historique");
                        tvError.setVisibility(View.VISIBLE);
                        progress.setVisibility(View.GONE);
                    }
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                    tvError.setText("Impossible de rejoindre le serveur \n Tirer vers le bas pour rafraichir");
                    tvError.setVisibility(View.VISIBLE);
                    progress.setVisibility(View.GONE);
                }
            }


            public void onFailure(int statusCode, Header[] headers,String responseString,Throwable throwable)
            {
                super.onFailure(statusCode, headers, responseString, throwable);
                tvError.setText("Erreur Connexion, Essayer à nouveau... \n Tirer vers le bas pour rafraichir");
                tvError.setVisibility(View.VISIBLE);
                progress.setVisibility(View.GONE);
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Respond to the action bar's Up/Home button to the home page with (finishAffinity)
                Intent i = new Intent(HistoricActivity.this, FayActivity.class);
                startActivity(i);
                finishAffinity();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

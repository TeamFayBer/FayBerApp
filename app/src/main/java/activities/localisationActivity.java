package activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import codepath.fayberapp.R;

public class localisationActivity extends AppCompatActivity {

    private SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localisation);
    }
    protected void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        
        if (mapFragment == null) {
            mapFragment = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map));
            // Check if we were successful in obtaining the map.
            if (mapFragment != null) {
                mapFragment.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap map) {
                        loadMap(map);
                    }
                });
            }
        }
    }

    // The Map is verified. It is now safe to manipulate the map.
    protected void loadMap(GoogleMap googleMap) {
        if (googleMap != null) {
            // ... use map here
        }
    }
}

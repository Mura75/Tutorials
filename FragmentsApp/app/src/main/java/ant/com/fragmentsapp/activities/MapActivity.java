package ant.com.fragmentsapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import ant.com.fragmentsapp.R;

public class MapActivity extends AppCompatActivity {

    GoogleMap googleMap;

    double lat, lng;

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        lat = getIntent().getDoubleExtra("lat", 0);
        lng = getIntent().getDoubleExtra("lng", 0);
        name = getIntent().getStringExtra("name");
        initMap();
    }

    private void initMap () {
        if (googleMap == null) {
            googleMap = ((MapFragment)getFragmentManager().findFragmentById(R.id.mapFragment)).getMap();
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lng), 15));
            googleMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
            MarkerOptions markerOptions = new MarkerOptions().position(new LatLng(lat, lng)).title(name);

            googleMap.addMarker(markerOptions);
        }
    }
}

package ant.com.fragmentsapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;

import java.util.StringTokenizer;

import ant.com.fragmentsapp.R;

public class CinemaActivity extends AppCompatActivity {

    private TextView tvCinemaName;
    private TextView tvCinemaAddress;
    private TextView tvCinemaAvenue;
    private TextView tvCinemaCity;
    private TextView tvCinemaMall;
    private TextView tvCinemaPhone;
    private TextView tvCinemaWebsite;
    private TextView tvCinemaGeo;

    private Button buttonMap;

    private GoogleMap googleMap;

    String name, city, phone, address, website, avenue, mall, geo;

    double lng, lat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinema);

        bindViews();

        name = getIntent().getStringExtra("full_name");
        phone = getIntent().getStringExtra("phone");
        city = getIntent().getStringExtra("city");
        address = getIntent().getStringExtra("address");
        website = getIntent().getStringExtra("website");
        avenue = getIntent().getStringExtra("avenue");
        mall = getIntent().getStringExtra("mall");
        geo = getIntent().getStringExtra("geo");

        StringTokenizer token = new StringTokenizer(geo, ",");

        while (token.hasMoreElements()) {
            lat = Double.parseDouble(token.nextToken());
            lng = Double.parseDouble(token.nextToken());
        }

        Log.d("my_lat_lng", lat + "\n" + lng);

        tvCinemaName.setText(name);
        tvCinemaAddress.setText(address);
        tvCinemaAvenue.setText(avenue);
        tvCinemaCity.setText(city);
        tvCinemaMall.setText(mall);
        tvCinemaPhone.setText(phone);
        tvCinemaWebsite.setText(website);
        tvCinemaGeo.setText(geo);

        buttonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CinemaActivity.this, MapActivity.class);
                intent.putExtra("lat", lat);
                intent.putExtra("lng", lng);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

    }

    private void bindViews() {
        tvCinemaName = (TextView) findViewById(R.id.tvCinemaName);
        tvCinemaAddress = (TextView) findViewById(R.id.tvCinemaAddress);
        tvCinemaAvenue = (TextView) findViewById(R.id.tvCinemaAvenue);
        tvCinemaCity = (TextView) findViewById(R.id.tvCinemaCity);
        tvCinemaMall = (TextView) findViewById(R.id.tvCinemaMall);
        tvCinemaPhone = (TextView) findViewById(R.id.tvCinemaPhone);
        tvCinemaWebsite = (TextView) findViewById(R.id.tvCinemaWebsite);
        tvCinemaGeo = (TextView) findViewById(R.id.tvCinemaGeo);
        buttonMap = (Button)findViewById(R.id.buttonMap);
    }



}

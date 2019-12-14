package com.example.task6t;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    protected Double markerList [] [];
    private static int markerValue = 15;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMarkerList();
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        addMarker();
        mMap.setOnMarkerClickListener(new OnMarkerClickListener());

    }

    public void onClick(View view) {
        Intent intent = new Intent(MapsActivity.this, HistoryActivity.class);
        startActivity(intent);
    }

    public void onClick1(View view) {
        Intent intent = new Intent(MapsActivity.this, MapsActivity.class);
        startActivity(intent);
    }


    private void getMarkerList(){
        if (markerList == null){
            markerList = new Double[markerValue][2];
            double piDegrees = 180.00;
            for (int i = 0 ; i < markerValue ; i++ ) {
            markerList[i][0] = -200 + Math.random() * (-piDegrees+20);
            markerList[i][1] = 30 + Math.random() * (piDegrees/4);
            }
        }
    }

    private void addMarker(){
        for (int i = 0 ; i < markerValue ; i++) {
            mMap.addMarker(new MarkerOptions().position(new LatLng(markerList[i][1], markerList[i][0])));
        }
    }
}

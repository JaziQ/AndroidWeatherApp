package com.example.task6t;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;


public class OnMarkerClickListener implements GoogleMap.OnMarkerClickListener {
    @Override
    public boolean onMarkerClick(Marker marker){
        double lat = marker.getPosition().latitude;
        double lon = marker.getPosition().longitude;
        String position = lat + ", " + lon;
        RequestGeoposition requestGeoposition = new RequestGeoposition();
        requestGeoposition.getLocaleKey(position);
        return false;
    }
}

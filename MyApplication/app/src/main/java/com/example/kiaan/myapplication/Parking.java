package com.example.kiaan.myapplication;


import android.graphics.Color;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

/**
 * Created by Noosrat on 2014/08/14.
 */
public class Parking extends CustomOverlay {

    int colour;
    String type;

    PolygonOptions rectOptions;
    Polygon polygon;

    public Parking(String n,String d, String t)
    {
        super(n, d);
        type = t;

        if (t.equals("Staff"))
            colour = Color.RED;
        else if (t.equals("PostGrad"))
            colour = Color.YELLOW;
        else if (t.equals("Standard"))
            colour = Color.BLUE;
    }

    public void setPolygon(GoogleMap mMap, LatLng...lngs)
    {
        rectOptions = new PolygonOptions()
                .add(lngs).fillColor(colour).strokeWidth(2);
        polygon = mMap.addPolygon(rectOptions);
    }

    public void hidePolygon()
    {
        polygon.setVisible(false);
    }
}

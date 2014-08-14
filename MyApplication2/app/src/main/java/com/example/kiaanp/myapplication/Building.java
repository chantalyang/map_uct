package com.example.kiaanp.myapplication;

import android.graphics.Color;


import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

/**
 * Created by Noosrat on 2014/08/07.
 */
public class Building extends CustomOverlay {

    public String faculty;
    //public String polygon;
    public String photo;
    int colour;

    PolygonOptions rectOptions;
    Polygon polygon;


    public Building(String n,String d, String f)
    {
        super(n,d);
        faculty=f;

        if (f.equals("Science"))
            colour = Color.MAGENTA;
        else if (f.equals("Commerce"))
            colour = Color.YELLOW;
        else if (f.equals("Humanities"))
            colour = Color.BLUE;
        else if (f.equals("Engineering and Built Environment"))
            colour = Color.GREEN;
    }

    public void setPolygon(GoogleMap mMap, LatLng...lngs)
    {
        rectOptions = new PolygonOptions()
                .add(lngs).fillColor(colour).strokeWidth(0);
        polygon = mMap.addPolygon(rectOptions);
    }

    public void hidePolygon()
    {
        polygon = null;
    }
}

package com.example.kiaanp.myapplication;

import com.google.android.gms.maps.model.Marker;

/**
 * Created by Chantal on 2014/08/13.
 */
public class Icon extends GeographicalLocation {

    public String iconType;
    public Marker marker;

    //Constructor
    public Icon(String name, String desc, String type, Marker mark){
        super(name, desc);
        iconType = type;
        marker = mark;
    }
}

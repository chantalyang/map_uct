package com.example.kiaanp.myapplication;

/**
 * Created by Chantal on 2014/08/13.
 */
public class Icon extends GeographicalLocation {

    public String iconType;

    //Constructor
    public Icon(String name, String desc, String type){
        super(name, desc);
        iconType = type;
    }
}

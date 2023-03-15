package com.example.layout_version;

public class Criteria {
    public static final int type_brightness = 1001;
    public static final int type_loudness = 1002;
    public int type;
    public int magnitude;
    public int duration;

    public Criteria(int type, int magnitude, int duration){
        this.type = type;
        this.magnitude = magnitude;
        this.duration = duration;
    }
}

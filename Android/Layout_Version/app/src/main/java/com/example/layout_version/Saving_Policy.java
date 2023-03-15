package com.example.layout_version;

public class Saving_Policy implements Displayable_Policy{
    public int max_time;
    public Camera camera;

    public Saving_Policy(Camera parent, int time){
        max_time = time;
        camera = parent;
    }

    @Override
    public String get_display_text() {
        return camera.name + ": " + max_time + " minutes";
    }
}

package com.example.layout_version;

public class Notification_Policy implements Displayable_Policy{
    public static final int type_buzz = 1001;
    public static final int type_silent = 1002;

    public int id;
    public int type;
    public Criteria criteria;
    public Camera camera;

    public Notification_Policy(Criteria criteria, Camera parent, int notification_type){
        this.criteria = criteria;
        this.camera = parent;
        this.type = notification_type;
    }

    @Override
    public String get_display_text() {
        return null;
    }
}

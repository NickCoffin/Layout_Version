package com.example.layout_version;

import java.util.ArrayList;

public class BackEnd {
    public static ArrayList<Camera> cameras = new ArrayList<>();
    public static ArrayList<Saving_Policy> savings = new ArrayList<>();
    public static ArrayList<Notification_Policy> notifications = new ArrayList<>();

    public static void init_test_objects(){
        cameras.add(new Camera("camera 1"));
        Criteria criteria = new Criteria(Criteria.type_brightness, 10, 10);
        notifications.add(new Notification_Policy(criteria, cameras.get(0), Notification_Policy.type_buzz));
        savings.add(new Saving_Policy(cameras.get(0), 10));
    }

    public static ArrayList<String>  get_policy_string_saving(){
        ArrayList<String> result = new ArrayList<>();

        return result;
    }
}


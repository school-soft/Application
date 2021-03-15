package com.application.schoolsoft;

import android.content.Intent;

public class ActivityFactory {



    public static void openMeniuPrincipal(ActivityBase activity){
        Intent intent = new Intent(activity, MeniuPrincipal.class);
        activity.startActivity(intent);
        activity.finish();
    }

    public static void openSettings(ActivityBase activity){
        Intent intent = new Intent(activity, SettingsActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }

    public static void openLogin(ActivityBase activity){
        Intent intent = new Intent(activity, LoginPage.class);
        activity.startActivity(intent);
        activity.finish();
    }

    public static void openLoginfromSettings(ActivityBase activity){
        Intent intent = new Intent(activity, LoginPage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        activity.startActivity(intent);
    }

}

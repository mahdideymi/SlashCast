package com.slash.slashcast;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.slash.slashcast.customControls.CustomTextViewLight;
import com.slash.slashcast.customControls.CustomTextViewMedium;

public class Application extends android.app.Application {

    @SuppressLint("StaticFieldLeak")
    private static Context context;
    public static Typeface FONT_BOLD;
    public static Typeface FONT_HEAVY;
    public static Typeface FONT_LIGHT;
    public static Typeface FONT_MEDIUM;
    public static LayoutInflater INFLATER;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();
        INFLATER = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        AssetManager assetManager = getAssets();
        FONT_BOLD = Typeface.createFromAsset(assetManager , "yekan_bakh_bold.ttf");
        FONT_HEAVY = Typeface.createFromAsset(assetManager , "yekan_bakh_heavy.ttf");
        FONT_LIGHT = Typeface.createFromAsset(assetManager , "yekan_bakh_light.ttf");
        FONT_MEDIUM = Typeface.createFromAsset(assetManager , "yekan_bakh_medium.ttf");

    }

    public static void toast(String message){
        toast(message , Toast.LENGTH_SHORT);
    }

    public static void toast(String message , int duration){
        View view = INFLATER.inflate(R.layout.toast , null);
        CustomTextViewMedium txtMessage = view.findViewById(R.id.toastMsg);
        txtMessage.setText(message);
        Toast toast = new Toast(context);
        toast.setDuration(duration);
        toast.setGravity(Gravity.BOTTOM , 0 , 250);
        toast.setView(view);
        toast.show();
    }

    public static Context getContext() {
        return context;
    }
}

package com.slash.slashcast;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.LayoutInflater;

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

    public static Context getContext() {
        return context;
    }
}

package com.slash.slashcast.customControls;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

import com.slash.slashcast.Application;

public class CustomTextViewLight extends AppCompatTextView {
    public CustomTextViewLight(Context context) {
        super(context);
        init();
    }

    public CustomTextViewLight(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomTextViewLight(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        setTypeface(Application.FONT_LIGHT);
    }
}

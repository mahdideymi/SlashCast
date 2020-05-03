package com.slash.slashcast.customControls;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatButton;

import com.slash.slashcast.Application;


public class CustomButtonMedium extends AppCompatButton {
    public CustomButtonMedium(Context context) {
        super(context);
        init();
    }

    public CustomButtonMedium(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomButtonMedium(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        setTypeface(Application.FONT_MEDIUM);
    }
}
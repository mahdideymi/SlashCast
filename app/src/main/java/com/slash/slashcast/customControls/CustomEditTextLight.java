package com.slash.slashcast.customControls;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatEditText;

import com.slash.slashcast.Application;

public class CustomEditTextLight extends AppCompatEditText {
    public CustomEditTextLight(Context context) {
        super(context);
        init();
    }

    public CustomEditTextLight(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomEditTextLight(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        setTypeface(Application.FONT_LIGHT);
    }
}

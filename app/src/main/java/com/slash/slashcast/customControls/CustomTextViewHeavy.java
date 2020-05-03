package com.slash.slashcast.customControls;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

import com.slash.slashcast.Application;

public class CustomTextViewHeavy extends AppCompatTextView {

    public CustomTextViewHeavy(Context context) {
        super(context);
        init();
    }

    public CustomTextViewHeavy(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomTextViewHeavy(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        setTypeface(Application.FONT_HEAVY);
    }
}
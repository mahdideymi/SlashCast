package com.slash.slashcast.customControls;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatEditText;

import com.slash.slashcast.Application;

public class CustomEditTextMedium extends AppCompatEditText {
    public CustomEditTextMedium(Context context) {
        super(context);
        init();
    }

    public CustomEditTextMedium(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomEditTextMedium(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        setTypeface(Application.FONT_MEDIUM);
    }
}

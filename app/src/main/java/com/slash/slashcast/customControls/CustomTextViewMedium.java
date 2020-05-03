package com.slash.slashcast.customControls;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

import com.slash.slashcast.Application;

public class CustomTextViewMedium extends AppCompatTextView {

    public CustomTextViewMedium(Context context) {
        super(context);
        init();
    }

    public CustomTextViewMedium(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomTextViewMedium(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        setTypeface(Application.FONT_MEDIUM);
    }
}

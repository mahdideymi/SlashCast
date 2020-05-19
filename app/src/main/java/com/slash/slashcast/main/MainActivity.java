package com.slash.slashcast.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.slash.slashcast.R;
import com.slash.slashcast.databinding.ActivityMainBinding;
import com.slash.slashcast.enterTel.EnterTelActivity;
import com.slash.slashcast.home.HomeActivity;
import com.slash.slashcast.otp.OtpActivity;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Handler handler = new Handler();
        handler.postDelayed(() -> {
                    startActivity(new Intent(this, HomeActivity.class));
                    this.finish();
                }
                , 1000);
    }
}

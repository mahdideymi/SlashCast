package com.slash.slashcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.slash.slashcast.databinding.ActivityOtpBinding;

public class OtpActivity extends AppCompatActivity {

    ActivityOtpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_otp);
        binding.btnOtp.setOnClickListener(view -> {
            if (!binding.otpEdt.getText().toString().isEmpty())
            startActivity(new Intent(OtpActivity.this, HomeActivity.class));
            this.finish();
        });

    }
}

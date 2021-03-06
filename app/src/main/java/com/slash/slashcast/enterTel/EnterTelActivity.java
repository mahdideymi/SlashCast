package com.slash.slashcast.enterTel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.slash.slashcast.otp.OtpActivity;
import com.slash.slashcast.R;
import com.slash.slashcast.databinding.ActivityEnterTelBinding;

public class EnterTelActivity extends AppCompatActivity {

    ActivityEnterTelBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_enter_tel);
        binding.continueEnterTel.setOnClickListener(view -> {
            String mobile = binding.edtEnterTel.getText().toString();
            if (mobile.isEmpty()) {
                binding.edtErrEnterTel.setVisibility(View.VISIBLE);
                binding.edtErrEnterTel.setText("شماره تلفن همراه نمی تواند خالی باشد");
            } else {
                if (mobile.length() == 11 && (mobile.charAt(0) == '0' && mobile.charAt(1) == '9')) {
                    binding.edtErrEnterTel.setVisibility(View.GONE);
                    startActivity(new Intent(EnterTelActivity.this, OtpActivity.class));
                    finish();
                } else {
                    binding.edtErrEnterTel.setVisibility(View.VISIBLE);
                    binding.edtErrEnterTel.setText("شماره تلفن همراه را به درستی وارد نمایید");
                }
            }
        });
    }
}

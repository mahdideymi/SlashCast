package com.slash.slashcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.slash.slashcast.EnterTel.EnterTelActivity;
import com.slash.slashcast.databinding.ActivityOtpBinding;
import com.slash.slashcast.service.OtpCounterService;

public class OtpActivity extends AppCompatActivity {

    ActivityOtpBinding binding;
    private boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_otp);

        startService(new Intent(this, OtpCounterService.class));

        binding.backToEnterTel.setOnClickListener(view -> {
            startActivity(new Intent(OtpActivity.this, EnterTelActivity.class));
            finish();
        });

        binding.otpCountDowner.setOnClickListener(view -> {
            if (!flag) {
                flag = true;
                stopService(new Intent(this, OtpCounterService.class));
                registerReceiver(br, new IntentFilter(OtpCounterService.COUNTDOWN_BR));
                startService(new Intent(this, OtpCounterService.class));
                binding.otpCountDowner.setTextColor(getResources().getColor(R.color.colorInput));
            }
        });

        binding.btnOtp.setOnClickListener(view -> {
            if (!binding.otpEdt.getText().toString().isEmpty()) {
                if (binding.otpEdt.getText().toString().equals("2317") && flag) {
                    binding.otpErrEdt.setVisibility(View.GONE);
                    startActivity(new Intent(OtpActivity.this, HomeActivity.class));
                    this.finish();
                } else {
                    binding.otpErrEdt.setVisibility(View.VISIBLE);
                    binding.otpErrEdt.setText("رمز عبور را اشتباه وارد کردید");
                }
            } else {
                binding.otpErrEdt.setVisibility(View.VISIBLE);
                binding.otpErrEdt.setText("رمز عبور نمی تواند خالی باشد");
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(br, new IntentFilter(OtpCounterService.COUNTDOWN_BR));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(br);
    }

    @Override
    protected void onStop() {
        super.onStop();
        try {
            unregisterReceiver(br);
        } catch (Exception e) {
            // Receiver was probably already stopped in onPause()
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(new Intent(this, OtpCounterService.class));
    }

    private BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            updateGUI(intent); // or whatever method used to update your GUI fields
        }
    };

    @SuppressLint("SetTextI18n")
    private void updateGUI(Intent intent) {
        if (intent.getExtras() != null) {
            long millisUntilFinished = intent.getLongExtra("countdown", 0);
            binding.otpCountDowner.setText(((millisUntilFinished / 1000) - 1) + " ثانیه تا دریافت کد جدید");
            Log.e("countDownerGui", String.valueOf(millisUntilFinished));
            if (millisUntilFinished < 2000) {
                binding.otpCountDowner.setTextColor(getResources().getColor(R.color.colorRed));
                binding.otpCountDowner.setText("ارسال دوباره کد تایید");
                flag = false;
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(OtpActivity.this, EnterTelActivity.class));
        this.finish();
    }
}

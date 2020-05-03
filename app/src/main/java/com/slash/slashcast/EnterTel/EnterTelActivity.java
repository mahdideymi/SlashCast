package com.slash.slashcast.EnterTel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.database.DatabaseUtils;
import android.os.Bundle;
import android.widget.Toast;

import com.slash.slashcast.OtpActivity;
import com.slash.slashcast.R;
import com.slash.slashcast.databinding.ActivityEnterTelBinding;

public class EnterTelActivity extends AppCompatActivity {

    ActivityEnterTelBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_enter_tel);
        binding.continueEnterTel.setOnClickListener( view -> {
            String mobile = binding.edtEnterTel.getText().toString();
            if (mobile.isEmpty()) {
                Toast.makeText(this, "شماره تلفن نمی تواند خالی باشد.", Toast.LENGTH_SHORT).show();
            } else {
                if ( mobile.length() == 11 && (mobile.charAt(0) == '0' && mobile.charAt(1) == '9'))
                    startActivity(new Intent(EnterTelActivity.this, OtpActivity.class));
                else
                    Toast.makeText(this, "شماره تلفن را به درستی وارد نمایید.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

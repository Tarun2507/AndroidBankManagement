package com.example.bankapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UpdatePin extends AppCompatActivity {

    List<Account> accounts = new ArrayList<Account>();
    EditText oldpin, newpin, confirmpin;
    Button updatePin, goback;
    int pin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_pin);
        accounts = LoginActivity.tempAccounts;
        oldpin = findViewById(R.id.oldpin);
        newpin = findViewById(R.id.newpin);
        confirmpin = findViewById(R.id.confirmnewpin);
        updatePin = findViewById(R.id.update);
        goback = findViewById(R.id.goback);
        pin = accounts.get(0).getPin();
        updatePin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyAndSetPin();
            }
        });
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            }
        });
    }

    public void verifyAndSetPin() {
        if (Integer.parseInt(oldpin.getText().toString()) == pin && Integer.parseInt(newpin.getText().toString()) == Integer.parseInt(confirmpin.getText().toString())) {
            for (int i = 0; i < accounts.size(); i++) {
                accounts.get(i).setPin(Integer.parseInt(newpin.getText().toString()));
            }
            Toast.makeText(getApplicationContext(),"Pin updated successfully", Toast.LENGTH_LONG).show();
        }
    }
    }
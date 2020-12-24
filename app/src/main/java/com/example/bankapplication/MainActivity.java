package com.example.bankapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView welcomemsg;
    Button cb,updatePin,payUB,transfer,interac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        welcomemsg = findViewById(R.id.welcomemsg);
        cb = findViewById(R.id.checkbal);
        updatePin = findViewById(R.id.updatepin);
        payUB = findViewById(R.id.payutility);
        transfer = findViewById(R.id.transfer);
        interac = findViewById(R.id.interac);
        welcomemsg.setText("Welcome " + LoginActivity.username);

        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Balance.class);
                startActivity(intent);
            }
        });
        updatePin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),UpdatePin.class);
                startActivity(intent);
            }
        });
        payUB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Utility.class);
                startActivity(intent);
            }
        });
        transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Transfer.class);
                startActivity(intent);
            }
        });
        interac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Interac.class);
                startActivity(intent);
            }
        });

    }
}
package com.example.bankapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    EditText cardnumber,pin;
    Button login;
    List<Account> accounts = new ArrayList<Account>();
    public static List<Account> tempAccounts = new ArrayList<Account>();
    public static String username="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        cardnumber = findViewById(R.id.cardnumber);
        pin = findViewById(R.id.pin);
        login = findViewById(R.id.login);
        fillData();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateUser();
            }
        });
    }

    public void fillData() {
    accounts.add(new Account("Tarun Reddy","Avpride","7032052989","225567","savings",7842,"2255566677",4000));
    accounts.add(new Account("Tarun Reddy","Avpride","7032052989","225567","chequing",7842,"2255566677",2000));
    accounts.add(new Account("Surya Reddy","DSNR","443333221","10256","savings",7842,"2255566677",4500));
    accounts.add(new Account("Surya Reddy","DSNR","443333221","10256","chequing",7842,"2255566677",2500));
    accounts.add(new Account("Shashi Reddy","Nizampet","64433227","2255567","savings",7842,"2255566677",4300));
    accounts.add(new Account("Shashi Reddy","Nizampet","64433227","2255567","chequing",7842,"2255566677",3000));
    }
    public void validateUser() {
        int isValid = 0;
        for(int i=0;i<accounts.size();i++) {
            if(accounts.get(i).getCardnumber().equals(cardnumber.getText().toString())&&Integer.parseInt(pin.getText().toString())==accounts.get(i).getPin()) {
                username = accounts.get(i).getName();
                tempAccounts.add(accounts.get(i));
                isValid = 1;
            }
        }
        if(isValid == 1) {
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(),"Invalid credentials,Please try again.", Toast.LENGTH_LONG).show();
        }
    }
}
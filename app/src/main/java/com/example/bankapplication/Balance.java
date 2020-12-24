package com.example.bankapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Balance extends AppCompatActivity {
    List<Account> accounts = new ArrayList<Account>();
    TextView balance;
    Spinner sp;
    Button back;
    String[] accounttypes = {"Chequing","Savings"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);
        accounts = LoginActivity.tempAccounts;
        balance = findViewById(R.id.balance);
        sp = findViewById(R.id.sp);
        back = findViewById(R.id.back);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,accounttypes);
       sp.setAdapter(aa);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String accountType = accounttypes[position];
                for(int i=0;i<accounts.size();i++){
                    if(accounts.get(i).getAccounttype().equalsIgnoreCase(accountType)) {
                        balance.setText(String.valueOf(accounts.get(i).getBalance()));
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
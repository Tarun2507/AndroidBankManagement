package com.example.bankapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Transfer extends AppCompatActivity {

    Spinner sp,sp2;
    EditText edt;
    Button btn;
    String[] accountTypes = {"Chequing","Savings"};
    String sourceAccount = "";
    List<Account> accounts = new ArrayList<Account>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);
        sp = findViewById(R.id.source);
        sp2 = findViewById(R.id.destination);
        edt = findViewById(R.id.transferAmount);
        btn = findViewById(R.id.transferbtn);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,accountTypes);
        sp.setAdapter(aa);
        sp2.setAdapter(aa);
        accounts = LoginActivity.tempAccounts;
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               String sourceAccount = accountTypes[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<accounts.size();i++) {
                    if(accounts.get(i).getAccounttype().equalsIgnoreCase("Chequing") && sourceAccount.equalsIgnoreCase("Chequing")){
                        accounts.get(i).setBalance(accounts.get(i).getBalance() - Double.parseDouble(edt.getText().toString()));
                        if(accounts.get(i).getAccounttype().equalsIgnoreCase("savings")) {
                            accounts.get(i).setBalance(accounts.get(i).getBalance() + Double.parseDouble(edt.getText().toString()));
                        }
                    }
                    if(accounts.get(i).getAccounttype().equalsIgnoreCase("Savings") && sourceAccount.equalsIgnoreCase("Savings")){
                        accounts.get(i).setBalance(accounts.get(i).getBalance() + Double.parseDouble(edt.getText().toString()));
                        if(accounts.get(i).getAccounttype().equalsIgnoreCase("chequing")) {
                            accounts.get(i).setBalance(accounts.get(i).getBalance() + Double.parseDouble(edt.getText().toString()));
                        }
                    }
                    Toast.makeText(getApplicationContext(),"Money has been transferred successfully", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
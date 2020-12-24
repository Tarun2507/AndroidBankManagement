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

public class Utility extends AppCompatActivity {

    Spinner sp,sp2;
    EditText subid,amount;
    Button pay;
    String[] utilities = {"Hydro","Water","Gas","Phone"};
    String[] accountTypes= {"Chequing","Savings"};
    String selectedUtility="";
    String selectedAccountType = "";
    List<Account> accounts = new ArrayList<Account>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utility);
        sp=findViewById(R.id.utilities);
        sp2=findViewById(R.id.accounts);
        subid = findViewById(R.id.subid);
        amount=findViewById(R.id.amount);
        pay=findViewById(R.id.pay);
        accounts = LoginActivity.tempAccounts;
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,utilities);
        sp.setAdapter(aa);
        ArrayAdapter<String> aa2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,accountTypes);
        sp2.setAdapter(aa2);

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<accounts.size();i++) {
                    if(accounts.get(i).getAccounttype().equalsIgnoreCase(selectedAccountType)) {
                        Double bill = Double.parseDouble(amount.getText().toString());
                        accounts.get(i).setBalance(accounts.get(i).getBalance() - bill);
                        Toast.makeText(getApplicationContext(),"Bill paid successfully", Toast.LENGTH_LONG).show();
                        break;
                    }
                }
            }
        });
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedUtility = utilities[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedAccountType = accountTypes[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
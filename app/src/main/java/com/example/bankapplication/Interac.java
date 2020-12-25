package com.example.bankapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Interac extends AppCompatActivity {

    GmailSender sender;
    Button btn;
    EditText recepient,amount;
    List<Account> accounts = new ArrayList<Account>();
    String senderName = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interac);
        recepient = findViewById(R.id.email);
        amount = findViewById(R.id.amount2);
        accounts = LoginActivity.tempAccounts;
        senderName = accounts.get(0).getName();
        sender = new GmailSender("", "");
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Your transaction has been sent successfully", Toast.LENGTH_SHORT).show();
                new MyAsyncClass().execute();
            }
        });
    }
    class MyAsyncClass extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {

            super.onPreExecute();

        }

        @Override

        protected Void doInBackground(Void... mApi) {
            try {
                sender.sendMail("Transaction update", "You received $" + amount.getText() + "from " + senderName,  "madttarunsurya@gmail.com", recepient.getText().toString());
                Log.d("send", "done");
            }
            catch (Exception ex) {
                Log.d("exceptionsending", ex.toString());
            }
            return null;
        }

        @Override

        protected void onPostExecute(Void result) {

            super.onPostExecute(result);


        }
    }
}
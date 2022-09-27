package com.example.w3_p4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.emailAddress);
        password = findViewById(R.id.passWord);

        Button button01 = findViewById(R.id.loginBT);
        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailStr = email.getText().toString();
                String pwStr = password.getText().toString();
                if (emailStr.equals(" ") && pwStr.equals(" ")){
                    Intent intent = new Intent(getApplicationContext(),flashcard.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Welcome cs501@bu.edu!", Toast.LENGTH_LONG).show();
                } else if (emailStr.equals("cs501@bu.edu") && !pwStr.equals("1234")) {
                    Toast.makeText(getApplicationContext(), "You wrote wrong password!", Toast.LENGTH_LONG).show();
                } else if (!emailStr.equals("cs501@bu.edu") && pwStr.equals("1234")){
                    Toast.makeText(getApplicationContext(), "You wrote wrong email address!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Please write again (email and pw are wrong)", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void onConfigurationChanged (@NonNull Configuration MainActivity) {
        super.onConfigurationChanged(MainActivity);
    }
}
package com.jalsoft.android.eccormece;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {
    Button signup;
    EditText password,phone,email;
    TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        login = findViewById(R.id.login_label);
        signup = findViewById(R.id.SignupButton);
        email = findViewById(R.id.SignupEmail);
        phone = findViewById(R.id.signupPhone);
        password = findViewById(R.id.signupPassword);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String em,ph,pass;
                em = email.getText().toString();
                ph = phone.getText().toString();
                pass = password.getText().toString();
                if (em.equals("") || ph.equals("") || pass.equals("")){
                    Log.d("errorr", "Alll fields required");
                }
            }
        });

    }}
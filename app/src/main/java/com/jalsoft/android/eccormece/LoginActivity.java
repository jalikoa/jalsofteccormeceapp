package com.jalsoft.android.eccormece;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    Button login;
    EditText email,password;
    TextView signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.loginButton);
        signup = findViewById(R.id.signup_label);
        email = findViewById(R.id.loginEmail);
        password = findViewById(R.id.loginPassword);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String em,pass;
                em = email.getText().toString();
                pass = password.getText().toString();
                if (em.equals("") || pass.equals("")){
                    Toast toast = Toast.makeText(LoginActivity.this, "All fields are required", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    Log.d("loginError", "All fields are required");
                } else {
                    if(em.equals("jalikoa@gmail.com") && pass.equals("jalikoa")){
                        Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                        startActivity(intent);
                        Toast toast = Toast.makeText(LoginActivity.this, "Login succesfull", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    } else {
                        Log.d("loginError", "Incorrect username or password");
                        Toast toast = Toast.makeText(LoginActivity.this, "Incorrect username or password", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                }

            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });

    }
}

package com.jalsoft.android.eccormece;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {
    private TextView pageTitle;
    private Button signupButton;
    private TextView emailLabel;
    private EditText emailInput;
    private TextView contactLabel;
    private EditText contactInput;
    private TextView passwordLabel;
    private EditText passwordInput;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        pageTitle = findViewById(R.id.pageTitle);
        emailLabel = findViewById(R.id.emailLabel);
        emailInput = findViewById(R.id.emailInput);
        contactLabel = findViewById(R.id.contactLabel);
        contactInput = findViewById(R.id.contactInput);
        passwordLabel = findViewById(R.id.passwordLabel);
        passwordInput= findViewById(R.id.passwordInput);
        signupButton = findViewById(R.id.signUpBtn);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = contactInput.getText().toString();
                AlertDialog.Builder builder = new AlertDialog.Builder(SignupActivity.this);
                builder.setTitle("Popup Title");
                builder.setMessage("This is Jalikoa's app in production");
                builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss(); // Close the popup
                    }
                });

    }
});
    }}
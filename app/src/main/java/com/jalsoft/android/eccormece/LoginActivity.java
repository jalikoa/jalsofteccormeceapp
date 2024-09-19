package com.jalsoft.android.eccormece;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    // Declare variables for the UI components
    private TextView titleTextView;
//    private ImageView myImageView;
    private EditText mEditText;
    private Button myButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // Linking to the XML layout

        // Initializing the UI components by finding them by their ID
        titleTextView = findViewById(R.id.titleTextView);
//        myImageView = findViewById(R.id.myImageView);
        mEditText = findViewById(R.id.myEditText);
        myButton = findViewById(R.id.myButton);

        // Setting an action for the button
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the text from the EditText and display it in the TextView
                String userInput = mEditText.getText().toString();
                titleTextView.setText(userInput);
            }
        });
    }
}

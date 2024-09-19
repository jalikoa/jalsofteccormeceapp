package com.jalsoft.android.eccormece;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class PracticeActivity extends AppCompatActivity {
    private Button myButton;
    private ImageView myImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        myButton = findViewById(R.id.myButton);
        myImageView = findViewById(R.id.myImageView);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an alert dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(PracticeActivity.this);
                builder.setTitle("Popup Title");
                builder.setMessage("This is Jalikoa's app in production");
                builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss(); // Close the popup
                    }
                });

                // Display the popup
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }
}

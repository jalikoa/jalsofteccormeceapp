package com.jalsoft.android.eccormece;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity5 extends AppCompatActivity {
    Dialog dialog;
    Button cancelBtn,LogoutBtn;
    CardView logout,settingsCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_griddashboard);
        logout = findViewById(R.id.logoutCard);
        settingsCard = findViewById(R.id.settingsCard);
        dialog = new Dialog(MainActivity5.this);
        dialog.setContentView(R.layout.custom_dialog_box);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.dialog_bg));
        dialog.setCancelable(false);
        cancelBtn = dialog.findViewById(R.id.btnDialogCancel);
        LogoutBtn = dialog.findViewById(R.id.btnDialog);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        settingsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity5.this);
                alertDialog.setTitle("Hey");
                alertDialog.setMessage("Hey there bro ukoje man");
                alertDialog.setCancelable(true);
                alertDialog.show();
            }
        });
        LogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity5.this, MainActivity.class);
                startActivity(intent);
                finish();
                dialog.dismiss();
                Toast toast = Toast.makeText(MainActivity5.this,"Logout succesfull",Toast.LENGTH_LONG);
                toast.show();
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });
    }
}
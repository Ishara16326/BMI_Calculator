package com.example.bmicalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText Age = (EditText)findViewById(R.id.txt_age);
        EditText Height = (EditText)findViewById(R.id.txt_height);
        EditText Weight = (EditText)findViewById(R.id.txt_weight);

        Button Button_cal =(Button)findViewById(R.id.btn_cal);
        Button_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Age.getText().toString().equals("") || Height.getText().toString().equals("") || Weight.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Invalid Entry", Toast.LENGTH_LONG).show();
                } else if (Integer.parseInt(Age.getText().toString()) < 18) {
                    Toast.makeText(getApplicationContext(), "This app is for people over 18 only", Toast.LENGTH_LONG).show();
                }else {
                    float BMI = (Float.parseFloat(Weight.getText().toString()))/((Float.parseFloat(Height.getText().toString()))*(Float.parseFloat(Height.getText().toString())))*10000;
                    Intent BMI_Cal= new Intent(MainActivity.this,MainActivity2.class);
                    BMI_Cal.putExtra("bmi",BMI);
                    startActivity(BMI_Cal);
                }
            }
        });
    }
    @Override
    public void onBackPressed(){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Do you want to Exit from App?")
                .setTitle("Exit")
                .setCancelable(true)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        AlertDialog msgBox = builder1.create();
        msgBox.show();
    }
}

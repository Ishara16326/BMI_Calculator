package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Bundle abc = getIntent().getExtras();
        float BMI = abc.getFloat("bmi");


        String CategoryBMI = null;
        String color = null;

        if (BMI > 0) {
            if (BMI < 16) {
                CategoryBMI = "Severe Thinness";
                color = "#B22222";
            } else if (16 <= BMI && BMI < 17) {
                CategoryBMI = "Moderate Thinness";
                color = "#B22222";
            } else if (17 <= BMI && BMI < 18.5) {
                CategoryBMI = "Mild Thinness";
                color = "#FFD700";
            } else if (18.5 <= BMI && BMI < 25) {
                CategoryBMI = "Normal";
                color = "#32CD32";
            } else if (25 <= BMI && BMI < 30) {
                CategoryBMI = "Overweight";
                color = "#FFD700";
            } else if (30 <= BMI && BMI < 35) {
                CategoryBMI = "Obese Class I";
                color = "#FF0000";
            } else if (35 <= BMI && BMI < 40) {
                CategoryBMI = "Obese Class II";
                color = "#FF0000";
            } else if (BMI >= 40) {
                CategoryBMI = "Obese class III";
                color = "#B22222";
            }
            TextView BMI_Cal = (TextView) findViewById(R.id.txt_cal);
            BMI_Cal.setText("BMI = "+Float.toString(BMI)+" kg/m2");

            TextView Category = (TextView) findViewById(R.id.category);
            Category.setText(CategoryBMI);
            Category.setTextColor(Color.parseColor(color));
        }
        else{
            Toast.makeText(getApplicationContext(), "Invalid Entry", Toast.LENGTH_LONG).show();
        }
    }
}
package com.example.firstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class Main2Activity extends AppCompatActivity {
    // Declaration des variables

    private EditText firstNumber, secondNumber;
    private Button btnPlus, btnDiv, btnSous, btnMult;
    private TextView result;

    private String val1, val2, res;
    private int resultInt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Affectation des variables
        firstNumber = findViewById(R.id.first_number);
        secondNumber = findViewById(R.id.second_number);
        btnPlus = findViewById(R.id.btn_plus);
        btnDiv = findViewById(R.id.btn_div);
        btnSous = findViewById(R.id.btn_sous);
        btnMult = findViewById(R.id.btn_mult);
        result = findViewById(R.id.result);


        // actions
        btnPlus.setOnClickListener(v -> {
            val1 = firstNumber.getText().toString();
            val2 = secondNumber.getText().toString();
            resultInt = Integer.parseInt(val1) + Integer.parseInt(val2);
            res = Integer.toString(resultInt);
            result.setText("Result: " + res);
        });
        btnDiv.setOnClickListener(v -> {
            val1 = firstNumber.getText().toString();
            val2 = secondNumber.getText().toString();
            resultInt = Integer.parseInt(val1) / Integer.parseInt(val2);
            res = Integer.toString(resultInt);
            result.setText("Result: " + res);
        });
        btnSous.setOnClickListener(v -> {
            val1 = firstNumber.getText().toString();
            val2 = secondNumber.getText().toString();
            resultInt = Integer.parseInt(val1) - Integer.parseInt(val2);
            res = Integer.toString(resultInt);
            result.setText("Result: " + res);
        });

        btnMult.setOnClickListener(v -> {
            val1 = firstNumber.getText().toString();
            val2 = secondNumber.getText().toString();
            resultInt = Integer.parseInt(val1) * Integer.parseInt(val2);
            res = Integer.toString(resultInt);
            result.setText("Result: " + res);


        });
    }

    // Declarations des methodes
}
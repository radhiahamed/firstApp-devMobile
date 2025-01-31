package com.example.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class SignInActivity extends AppCompatActivity {
    // Declaration des variables
    private TextView goToSignUp, ForgetPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        // Affectation des variables
        goToSignUp = findViewById(R.id.go_to_sign_up);
        ForgetPassword = findViewById(R.id.forget_password);


        // actions
        goToSignUp.setOnClickListener(V -> {
            // to do after click to text view
            startActivity(new Intent(this, SignUpActivity.class));
        });
        ForgetPassword.setOnClickListener(v ->{
            startActivity(new Intent(this , ForgetPasswordActivity.class));
        });
    }

        // Declarations des methodes
    }
package com.example.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ForgetPasswordActivity extends AppCompatActivity {
// Declaration des variables
    private Button backToSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        // Affectation des variables
        backToSignIn = findViewById(R.id.back_to_sign_in);

        // actions
        backToSignIn.setOnClickListener(v ->{
            // to do after click to text view
            startActivity(new Intent(this, SignInActivity.class));
        });


    }
    // Declarations des methodes
}
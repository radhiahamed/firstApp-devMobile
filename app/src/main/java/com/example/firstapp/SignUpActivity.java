package com.example.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignUpActivity extends AppCompatActivity {
// Declaration des variables
    private TextView goToSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        // Affectation des variables
        goToSignIn = findViewById(R.id.go_to_sign_in);

        // actions
goToSignIn.setOnClickListener(v -> {
            // to do after click to text view
            startActivity(new Intent(this, SignInActivity.class));
        });
        // Declarations des methodes
    }
}
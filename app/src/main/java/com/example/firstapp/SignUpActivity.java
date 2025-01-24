package com.example.firstapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kotlin.internal.UProgressionUtilKt;

public class SignUpActivity extends AppCompatActivity {
    // Declaration des variables
    private TextView goToSignIn;
    private EditText userName, email, cin, password, confirmPassword;
    private Button btnSignUp;
    private String userNameString, emailString, cinString, passwordString, confirmPasswordString;
    private static final String EMAIL_REGEX = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        // Affectation des variables
        goToSignIn = findViewById(R.id.go_to_sign_in);
        userName = findViewById(R.id.user_name_sign_up);
        email = findViewById(R.id.email_sign_up);
        cin = findViewById(R.id.cin_sign_up);
        password = findViewById(R.id.password_sign_up);
        confirmPassword = findViewById(R.id.confirm_password_sign_up);
        btnSignUp = findViewById(R.id.btn_sign_up);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        // actions
        btnSignUp.setOnClickListener(v -> {
            if (validate()) {
                progressDialog.setMessage("please wait !");
                progressDialog.show();
                firebaseAuth.createUserWithEmailAndPassword(emailString, passwordString).addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        sendEmailVerification();
                    } else {
                        Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }

                });

            }
        });
        goToSignIn.setOnClickListener(v -> {
            // to do after click to text view
            startActivity(new Intent(this, SignInActivity.class));
        });
        // Declarations des methodes
    }

    private void sendEmailVerification() {
        FirebaseUser loggedUser = firebaseAuth.getCurrentUser();
        if (loggedUser != null) {
            loggedUser.sendEmailVerification().addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                //send user date
                    Toast.makeText(this, "registration done please check your email", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(this, SignInActivity.class));
                    progressDialog.dismiss();
                    finish();
                } else {
                    Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            });
        }
    }

    private boolean validate() {
        boolean result = false;
        userNameString = userName.getText().toString().trim();
        emailString = email.getText().toString().trim();
        cinString = cin.getText().toString().trim();
        passwordString = password.getText().toString().trim();
        confirmPasswordString = confirmPassword.getText().toString().trim();

        if (userNameString.length() < 7) {
            userName.setError("user name is invalid");
        } else if (!isValidEmail(emailString)) {
            email.setError("email is invalid");
        } else if (cinString.length() != 8) {
            cin.setError("cin is invalid");

        } else if (passwordString.length() < 6) {
            password.setError("password is invalid");

        } else if (confirmPasswordString.equals(passwordString)) {
            confirmPassword.setError("confirm password is invalid");
        } else {
            result = true;
        }
        return result;


    }

    private boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
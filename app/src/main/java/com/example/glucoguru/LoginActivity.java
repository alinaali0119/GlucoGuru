package com.example.glucoguru;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    TextView tvSignup;

    TextInputEditText tietEmail;
    TextInputEditText tietPassword;
    Button btnLogin;
    Button btnGoogleLogin;
    Button btnSP;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tietEmail= findViewById(R.id.tietEmail);
        tietPassword= findViewById(R.id.tietPassword);
        btnLogin= findViewById(R.id.btnLogin);
        btnGoogleLogin= findViewById(R.id.btnGoogleLogin);
        btnSP= findViewById(R.id.btnSP);
        auth= FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email= tietEmail.getText().toString();
                String password= tietPassword.getText().toString();
                if(email.isBlank()){
                    tietEmail.setError("Enter Email");
                    tietEmail.requestFocus();
                } else if (password.isBlank()) {
                    tietPassword.setError("Enter Password");
                    tietPassword.requestFocus();
                }
                else
                {
                    auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent i1= new Intent(LoginActivity.this, DashboardActivity.class);
                        startActivity(i1);
                    } else {
                        Toast.makeText(LoginActivity.this, "Login Failed"+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                    }
                });

                }
            }
        });


        btnGoogleLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        btnSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(i);
            }
        });
    }
}
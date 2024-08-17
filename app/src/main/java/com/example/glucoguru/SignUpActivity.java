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

public class SignUpActivity extends AppCompatActivity {
    TextView tvSignup;
    TextInputEditText tietName;
    TextInputEditText tietEmail;
    TextInputEditText tietPhone;
    TextInputEditText tietPassword;
    Button btnSignup;
    Button btnLP;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        auth= FirebaseAuth.getInstance();

        tietName= findViewById(R.id.tietName);
        tietEmail= findViewById(R.id.tietEmail);
        tietPhone= findViewById(R.id.tietPhone);
        tietPassword= findViewById(R.id.tietPassword);
        btnSignup= findViewById(R.id.btnSignUp);
        btnLP= findViewById(R.id.btnLP);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name= tietName.getText().toString();
                String email= tietEmail.getText().toString();
                String phone= tietPhone.getText().toString();
                String password= tietPassword.getText().toString();

                if(email.isBlank()){
                    tietEmail.setError("Enter Email");
                    tietEmail.requestFocus();
                } else if (password.isBlank()) {
                    tietPassword.setError("Enter Password");
                    tietPassword.requestFocus();
                } else if (name.isBlank()) {
                    tietName.setError("Enter Name");
                    tietName.requestFocus();
                }else if (phone.isBlank()) {
                    tietPhone.setError("Enter Phone Number");
                    tietPhone.requestFocus();
                }
                else {
                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(SignUpActivity.this, "User Created", Toast.LENGTH_SHORT).show();
                                tietName.setText(null);
                                tietEmail.setText(null);
                                tietPhone.setText(null);
                                tietPassword.setText(null);
                            } else {
                                Toast.makeText(SignUpActivity.this, "Unable to Create User"+task.getException(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }

            }
        });

        btnLP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2= new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(i2);
            }
        });
    }
}
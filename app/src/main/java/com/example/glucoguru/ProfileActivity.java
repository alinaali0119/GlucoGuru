package com.example.glucoguru;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity";
    TextView tvFullName, tvAge, tvGender, tvMedicalConditions, tvMedications, tvSmokingStatus, tvAlcoholConsumption, tvHeight, tvWeight;
    private FirebaseAuth auth;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvFullName = findViewById(R.id.tvFullName);
        tvAge = findViewById(R.id.tvAge);
        tvGender = findViewById(R.id.tvGender);
        tvMedicalConditions = findViewById(R.id.tvMedicalConditions);
        tvMedications = findViewById(R.id.tvMedications);
        tvSmokingStatus = findViewById(R.id.tvSmokingStatus);
        tvAlcoholConsumption = findViewById(R.id.tvAlcoholConsumption);
        tvHeight = findViewById(R.id.tvHeight);
        tvWeight = findViewById(R.id.tvWeight);

        auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        if (user != null) {
            String userId = user.getUid();
            databaseReference = FirebaseDatabase.getInstance().getReference("HealthDetails");

            databaseReference.child(userId).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        HealthDetails healthDetails = snapshot.getValue(HealthDetails.class);
                        if (healthDetails != null) {
                            tvFullName.setText(healthDetails.getFullName());
                            tvAge.setText(healthDetails.getAge());
                            tvGender.setText(healthDetails.getGender());
                            tvMedicalConditions.setText(healthDetails.getMedicalConditions());
                            tvMedications.setText(healthDetails.getMedications());
                            tvSmokingStatus.setText(healthDetails.getSmokingStatus());
                            tvAlcoholConsumption.setText(healthDetails.getAlcoholConsumption());
                            tvHeight.setText(healthDetails.getHeight());
                            tvWeight.setText(healthDetails.getWeight());
                            Log.d(TAG, "Data fetched successfully");
                        } else {
                            Log.d(TAG, "HealthDetails object is null");
                        }
                    } else {
                        Log.d(TAG, "Snapshot does not exist");
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Log.e(TAG, "Database error: " + error.getMessage());
                }
            });
        }
        else {
            Log.d(TAG, "User is not authenticated");

        }
    }  }
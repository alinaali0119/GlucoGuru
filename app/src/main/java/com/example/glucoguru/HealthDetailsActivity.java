package com.example.glucoguru;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HealthDetailsActivity extends AppCompatActivity {

    TextInputEditText etFullName, etAge, etGender, etMedicalConditions, etMedications, etSmokingStatus, etAlcoholConsumption, etHeight, etWeight;
    TextInputEditText etGlucose, etInsulin, etBMI, etBloodPressure, etDiabetesPedigree;
    Button btnSubmit;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etFullName = findViewById(R.id.etFullName);
        etAge = findViewById(R.id.etAge);
        etGender = findViewById(R.id.etGender);
        etMedicalConditions = findViewById(R.id.etMedicalConditions);
        etMedications = findViewById(R.id.etMedications);
        etSmokingStatus = findViewById(R.id.etSmokingStatus);
        etAlcoholConsumption = findViewById(R.id.etAlcoholConsumption);
        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);
        etGlucose = findViewById(R.id.etGlucose);
        etInsulin = findViewById(R.id.etInsulin);
        etBMI = findViewById(R.id.etBMI);
        etBloodPressure = findViewById(R.id.etBloodPressure);
        etDiabetesPedigree = findViewById(R.id.etDiabetesPedigree);
        btnSubmit = findViewById(R.id.btnSubmit);

        databaseReference = FirebaseDatabase.getInstance().getReference("HealthDetails");

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveHealthDetails();
            }
        });
    }

    private void saveHealthDetails() {
        String fullName = etFullName.getText().toString().trim();
        String age = etAge.getText().toString().trim();
        String gender = etGender.getText().toString().trim();
        String medicalConditions = etMedicalConditions.getText().toString().trim();
        String medications = etMedications.getText().toString().trim();
        String smokingStatus = etSmokingStatus.getText().toString().trim();
        String alcoholConsumption = etAlcoholConsumption.getText().toString().trim();
        String height = etHeight.getText().toString().trim();
        String weight = etWeight.getText().toString().trim();
        String glucose = etGlucose.getText().toString().trim();
        String insulin = etInsulin.getText().toString().trim();
        String bmi = etBMI.getText().toString().trim();
        String bloodPressure = etBloodPressure.getText().toString().trim();
        String diabetesPedigree = etDiabetesPedigree.getText().toString().trim();

        if (TextUtils.isEmpty(fullName)) {
            etFullName.setError("Full name is required");
            return;
        }

        if (TextUtils.isEmpty(age)) {
            etAge.setError("Age is required");
            return;
        }

        if (TextUtils.isEmpty(gender)) {
            etGender.setError("Gender is required");
            return;
        }

        if (TextUtils.isEmpty(height)) {
            etHeight.setError("Height is required");
            return;
        }

        if (TextUtils.isEmpty(weight)) {
            etWeight.setError("Weight is required");
            return;
        }

        if (TextUtils.isEmpty(glucose)) {
            etGlucose.setError("Glucose is required");
            return;
        }

        if (TextUtils.isEmpty(insulin)) {
            etInsulin.setError("Insulin is required");
            return;
        }

        if (TextUtils.isEmpty(bmi)) {
            etBMI.setError("BMI is required");
            return;
        }

        if (TextUtils.isEmpty(bloodPressure)) {
            etBloodPressure.setError("Blood Pressure is required");
            return;
        }

        String id = databaseReference.push().getKey();

        HealthDetails healthDetails = new HealthDetails(id, fullName, age, gender, medicalConditions, medications, smokingStatus, alcoholConsumption, height, weight, glucose, insulin, bmi, bloodPressure, diabetesPedigree);

        if (id != null) {
            databaseReference.child(id).setValue(healthDetails).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(HealthDetailsActivity.this, "Health details saved", Toast.LENGTH_SHORT).show();
                    clearFields();
                } else {
                    Toast.makeText(HealthDetailsActivity.this, "Failed to save health details", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void clearFields() {
        etFullName.setText("");
        etAge.setText("");
        etGender.setText("");
        etMedicalConditions.setText("");
        etMedications.setText("");
        etSmokingStatus.setText("");
        etAlcoholConsumption.setText("");
        etHeight.setText("");
        etWeight.setText("");
        etGlucose.setText("");
        etInsulin.setText("");
        etBMI.setText("");
        etBloodPressure.setText("");
        etDiabetesPedigree.setText("");
    }
}

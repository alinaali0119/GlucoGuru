package com.example.glucoguru;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DashboardActivity extends AppCompatActivity {

    Button btnProfileManagement;
    Button btnHealthDetails;
    Button btnUploadPhotos;
    Button btnCashbackSection;
    Button btnOptionFive;
    Button btnOptionSix;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnProfileManagement= findViewById(R.id.btnProfileManagement);
        btnHealthDetails= findViewById(R.id.btnHealthDetails);
        btnUploadPhotos= findViewById(R.id.btnUploadPhotos);
        btnCashbackSection= findViewById(R.id.btnCashbackSection);
        btnOptionFive= findViewById(R.id.btnOptionFive);
        btnOptionSix= findViewById(R.id.btnOptionSix);

        btnHealthDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent i= new Intent(DashboardActivity.this, HealthDetailsActivity.class);
            startActivity(i);
            }
        });

        btnProfileManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(DashboardActivity.this, ProfileActivity.class);
                startActivity(i);
            }
        });

    }
}
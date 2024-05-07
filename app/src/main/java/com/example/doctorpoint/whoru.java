package com.example.doctorpoint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class whoru extends AppCompatActivity {
    Button patient,doctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whoru);
        setContentView(R.layout.activity_whoru);
        patient=(Button) findViewById(R.id.patient);
        doctor=(Button) findViewById(R.id.doctor);
        getWindow().setStatusBarColor(ContextCompat.getColor(whoru.this,R.color.endc));

        patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),patientregister.class);
                startActivity(intent);
            }
        });
        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),doctorregiandpro.class);
                startActivity(intent);
            }
        });

    }
}
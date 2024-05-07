package com.example.doctorpoint;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class patientnotification extends AppCompatActivity {

    String docname;
    TextView notifi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patientnotification);
        getWindow().setStatusBarColor(ContextCompat.getColor(patientnotification.this, R.color.notificationcolor));

        notifi=(TextView)findViewById(R.id.notifi);

        docname=btnselection.getActivityInstance().getData();

        notifi.setText("YOU BOOKED APPOINTMENT OF "+docname+".");
        //Toast.makeText(this, "YOU BOOKED APPOINTMENT OF "+docname, Toast.LENGTH_LONG).show();

    }
}

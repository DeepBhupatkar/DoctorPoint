package com.example.doctorpoint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class patienthomepage extends AppCompatActivity {
   TextView btnv,btnb,btnnoti;
   Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patienthomepage);
        getWindow().setStatusBarColor(ContextCompat.getColor(patienthomepage.this, R.color.phomepageback));
        btnv=(TextView) findViewById(R.id.viewbtn);
        btnb=(TextView) findViewById(R.id.bookbtn);
        btnnoti=(TextView) findViewById(R.id.notification);
        logout=(Button) findViewById(R.id.logo);

        btnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),patientchoice1.class);
                startActivity(intent);
            }
        });
        btnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),bookappointment.class);
                startActivity(intent);
            }
        });
        btnnoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),patientnotification.class);
                startActivity(intent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(patienthomepage.this,whoru.class));
            }
        });
    }
}
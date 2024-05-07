package com.example.doctorpoint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class timepass extends AppCompatActivity {

    String patientnamexyz;
    Button doclogout;
    TextView docnotifi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timepass);
        getWindow().setStatusBarColor(ContextCompat.getColor(timepass.this, R.color.notificationcolor));
        patientnamexyz=btnselection.getActivityInstance1().getunique();
        docnotifi=(TextView) findViewById(R.id.docnotifi);
        doclogout=(Button) findViewById(R.id.doclogo);


        docnotifi.setText(patientnamexyz+",BOOK YOUR APPOINTMENT");
        //Toast.makeText(timepass.this, "PATIENT NAME IN DOCTOR=="+patientnamexyz, Toast.LENGTH_LONG).show();

        doclogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(timepass.this,whoru.class));
            }
        });
    }
}
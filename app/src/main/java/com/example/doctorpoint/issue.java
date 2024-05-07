package com.example.doctorpoint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class issue extends AppCompatActivity {
    Button next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue);
        next=(Button)findViewById(R.id.next);
        getWindow().setStatusBarColor(ContextCompat.getColor(issue.this,R.color.endc));
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),patienthomepage.class);
                startActivity(intent);
            }
        });
    }
}
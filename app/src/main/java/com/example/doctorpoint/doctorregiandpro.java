package com.example.doctorpoint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class doctorregiandpro extends AppCompatActivity {
    EditText name,email,number,password;
    Button next,lo;
    int c=0;
    ProgressBar drpbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorregiandpro);
        getWindow().setStatusBarColor(ContextCompat.getColor(doctorregiandpro.this,R.color.docstatusbar));
        name=(EditText) findViewById(R.id.name);
        email=(EditText) findViewById(R.id.email);
        number=(EditText) findViewById(R.id.number);
        password=(EditText) findViewById(R.id.password);
        lo=(Button) findViewById(R.id.button3);
        next=(Button) findViewById(R.id.next);
        drpbar=(ProgressBar)findViewById(R.id.dorpbar);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name1=name.getText().toString();
                String email1=email.getText().toString();
                String number1=number.getText().toString();
                String password1=password.getText().toString();
                if (name1.isEmpty()) {
                    name.setError("DOCTOR NAME IS REQUIRED");
                    name.requestFocus();
                    return;
                }
                if (name1.charAt(0) >= 65 && name1.charAt(0) <= 90 || name1.charAt(0) >= 97 && name1.charAt(0) <= 122) {
                    c++;
                }
                if (c == 0) {
                    name.setError("PATIENT NAME SHOULD NOT START WITH DIGIT");
                    name.requestFocus();
                    return;
                }
                c=0;
                if (email1.isEmpty()){
                    email.setError("E-MAIL IS REQUIRED");
                    email.requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email1).matches()){
                    email.setError("ENTER VALID E-MAIL");
                    email.requestFocus();
                    return;
                }

                if (number1.isEmpty()) {
                    number.setError("PHONE NUMBER IS REQUIRED");
                    number.requestFocus();
                    return;
                }
                if (password1.isEmpty()){
                    password.setError("PASSWORD IS REQUIRED");
                    password.requestFocus();
                    return;

                }
                if (password1.length()<8){
                    password.setError("8 CHARACTERS IS REQUIRED");
                    password.requestFocus();
                    return;

                }
                drpbar.setVisibility(view.VISIBLE);
                Intent intent=new Intent(getApplicationContext(),doctorregiandprofinal.class);
                intent.putExtra("dname",name1);
                intent.putExtra("demail",email1);
                intent.putExtra("dpassword",password1);
                intent.putExtra("dnumber",number1);

                startActivity(intent);
            }
        });
        lo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(getApplicationContext(),doctorlogin.class);
                startActivity(intent);
            }
        });

    }
}

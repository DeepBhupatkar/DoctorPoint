package com.example.doctorpoint;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class doctorregiandprofinal extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText qualification,experience,charges,address;
    Button create,dlogin;
    int q=0;
    ProgressBar dropbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorregiandprofinal);
        getWindow().setStatusBarColor(ContextCompat.getColor(doctorregiandprofinal.this,R.color.docstatusbar));
        qualification=(EditText) findViewById(R.id.qualification);
        experience=(EditText) findViewById(R.id.experience);
        charges=(EditText) findViewById(R.id.charges);
        address=(EditText) findViewById(R.id.address);
        create=(Button) findViewById(R.id.create);
        dlogin=(Button) findViewById(R.id.login);

        dropbar=(ProgressBar) findViewById(R.id.dropbarr);
        mAuth=FirebaseAuth.getInstance();

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name=getIntent().getStringExtra("dname");
                String email=getIntent().getStringExtra("demail");
                String password=getIntent().getStringExtra("dpassword");
                String phone=getIntent().getStringExtra("dnumber");

                String qualification1=qualification.getText().toString();
                String experience1=experience.getText().toString();
                String charges1=charges.getText().toString();
                String address1=address.getText().toString();
                if (qualification1.isEmpty()) {
                    qualification.setError("QUALIFICATION REQUIRED");
                    qualification.requestFocus();
                    return;
                }
                if (qualification1.charAt(0) >= 65 && qualification1.charAt(0) <= 90 || qualification1.charAt(0) >= 97 && qualification1.charAt(0) <= 122) {
                    q++;
                }
                if (q== 0) {
                    qualification.setError(" NOT START WITH DIGIT");
                    qualification.requestFocus();
                    return;
                }
                q=0;
                if (experience1.isEmpty()){
                    experience.setError("EXPERIENCE IS REQUIRED");
                    experience.requestFocus();
                    return;
                }

                if (charges1.isEmpty()){
                    charges.setError("CHARGES IS REQUIRED");
                    charges.requestFocus();
                    return;
                }

                if (address1.isEmpty()) {
                    address.setError("ADDRESS REQUIRED");
                    address.requestFocus();
                    return;
                }

                dropbar.setVisibility(view.VISIBLE);

                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful())
                        {
                            doctor DOCTOR=new doctor(name,email,phone,qualification1,experience1,charges1,address1,password);
                            FirebaseDatabase.getInstance().getReference("Doctor")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(DOCTOR).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if (task.isSuccessful())
                                    {
                                        Toast.makeText(doctorregiandprofinal.this, "REGISTERED AND PROFILE CREATED SUCCESSFULLY!", Toast.LENGTH_LONG).show();
                                        dropbar.setVisibility(View.GONE);
                                    }
                                    else
                                    {
                                        Toast.makeText(doctorregiandprofinal.this, "FAILED TO REGISTER!", Toast.LENGTH_SHORT).show();
                                        dropbar.setVisibility(View.GONE);
                                    }
                                }
                            });
                        }
                        else
                        {
                            Toast.makeText(doctorregiandprofinal.this, "DOCTOR ALREADY EXISTS!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        dlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(getApplicationContext(),doctorlogin.class);
                startActivity(intent);
            }
        });




    }
}
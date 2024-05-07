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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class patientogin extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText lemail,lpsw;
    Button flog,lsib;
    TextView lfpsw;
    ProgressBar ppbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patientogin);
        getWindow().setStatusBarColor(ContextCompat.getColor(patientogin.this,R.color.endc));
        mAuth = FirebaseAuth.getInstance();
        lemail=(EditText) findViewById(R.id.lemail);
        lpsw =(EditText) findViewById(R.id.lpsw);
        flog=(Button) findViewById(R.id.flog);
        lsib=(Button)findViewById(R.id.lsib);
        lfpsw=(TextView)findViewById(R.id.lfpsw);
        ppbar=(ProgressBar)findViewById(R.id.ppbar);

        flog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Lemail = lemail.getText().toString();
                String Lpsw = lpsw.getText().toString();
                if (Lemail.isEmpty()){
                    lemail.setError("E-MAIL IS REQUIRED");
                    lemail.requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(Lemail).matches()){
                    lemail.setError("ENTER VALID E-MAIL");
                    lemail.requestFocus();
                    return;
                }

                if (Lpsw.isEmpty()){
                    lpsw.setError("PASSWORD IS REQUIRED");
                    lpsw.requestFocus();
                    return;

                }
                if (Lpsw.length()<8){
                    lpsw.setError("8 CHARACTERS IS REQUIRED");
                    lpsw.requestFocus();
                    return;

                }
                ppbar.setVisibility(View.VISIBLE);
                mAuth.signInWithEmailAndPassword(Lemail,Lpsw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser Patient = FirebaseAuth.getInstance().getCurrentUser();

                            if (Patient.isEmailVerified()) {
                                startActivity(new Intent(getApplicationContext(), issue.class));

                            } else {
                                Patient.sendEmailVerification();
                                Toast.makeText(patientogin.this, "CHECK YOUR E-MAIL TO VERIFY YOUR ACCOUNT ", Toast.LENGTH_LONG).show();
                                ppbar.setVisibility(View.GONE);
                            }
                        }

                        else {
                            Toast.makeText(patientogin.this, "ACCOUNT NOT FOUND", Toast.LENGTH_LONG).show();
                            ppbar.setVisibility(View.GONE);
                        }

                    }
                });






            }
        });


        lsib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getApplicationContext(),patientregister.class);
                startActivity(intent);
            }
        });
        lfpsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),ForgotPassword.class);
                startActivity(intent);
            }
        });








    }
}
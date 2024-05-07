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

public class patientregister extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText uname, email, psw, phn;
    Button rgis, lob;
    int c = 0;
    ProgressBar pbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patientregister);
        getWindow().setStatusBarColor(ContextCompat.getColor(patientregister.this,R.color.endc));
        mAuth = FirebaseAuth.getInstance();
        uname = (EditText) findViewById(R.id.uname);
        phn = (EditText) findViewById(R.id.phn);
        psw = (EditText) findViewById(R.id.psw);
        rgis = (Button) findViewById(R.id.rgis);
        lob = (Button) findViewById(R.id.lob);
        email = (EditText) findViewById(R.id.email);
        pbar=(ProgressBar)findViewById(R.id.pbar);
        rgis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String runame = uname.getText().toString();
                String remail = email.getText().toString();
                String rphn = phn.getText().toString();
                String rpsw = psw.getText().toString();

                if (runame.isEmpty()) {
                    uname.setError("PATIENT NAME IS REQUIRED");
                    uname.requestFocus();
                    return;
                }
                if (runame.charAt(0) >= 65 && runame.charAt(0) <= 90 || runame.charAt(0) >= 97 && runame.charAt(0) <= 122) {
                    c++;
                }
                if (c == 0) {
                    uname.setError("PATIENT NAME SHOULD NOT START WITH DIGIT");
                    uname.requestFocus();
                    return;
                }
                c=0;
                if (remail.isEmpty()){
                    email.setError("E-MAIL IS REQUIRED");
                    email.requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(remail).matches()){
                    email.setError("ENTER VALID E-MAIL");
                    email.requestFocus();
                    return;
                }

                if (rphn.isEmpty()) {
                    phn.setError("PHONE NUMBER IS REQUIRED");
                    phn.requestFocus();
                    return;
                }
                if (rpsw.isEmpty()){
                    psw.setError("PASSWORD IS REQUIRED");
                    psw.requestFocus();
                    return;

                }
                if (rpsw.length()<8){
                    psw.setError("8 CHARACTERS IS REQUIRED");
                    psw.requestFocus();
                    return;

                }

                pbar.setVisibility(view.VISIBLE);
                mAuth.createUserWithEmailAndPassword(remail,rpsw)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    patient Patient=new patient(runame,remail,rphn);
                                    FirebaseDatabase.getInstance().getReference("patient")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(Patient).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()){
                                                Toast.makeText(getApplicationContext(),"PATIENT REGISTERED SUCCESSFULLY",Toast.LENGTH_LONG).show();
                                                pbar.setVisibility(View.GONE);
                                            }
                                            else
                                            {
                                                Toast.makeText(getApplicationContext(),"PATIENT REGISTRATION FAILED",Toast.LENGTH_LONG).show();
                                                pbar.setVisibility(View.GONE);

                                            }

                                        }
                                    });

                                }else
                                {
                                    Toast.makeText(getApplicationContext()," TRY-AGAIN TO REGISTRATION ",Toast.LENGTH_LONG).show();
                                    pbar.setVisibility(View.GONE);
                                }

                            }
                        });



            }
        });

        lob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getApplicationContext(),patientogin.class);
                startActivity(intent);
            }
        });


















    }
}
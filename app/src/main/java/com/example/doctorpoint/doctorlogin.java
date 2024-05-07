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

public class doctorlogin extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText doclemail,doclpass;
    Button docloginbtn1,drr1;
    ProgressBar ppbar;
    TextView dolfpsw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorlogin);
        getWindow().setStatusBarColor(ContextCompat.getColor(doctorlogin.this,R.color.docstatusbar));

        mAuth = FirebaseAuth.getInstance();
        ppbar=(ProgressBar)findViewById(R.id.ppbar);
        doclemail=(EditText) findViewById(R.id.doclemail);
        doclpass=(EditText) findViewById(R.id.doclpass);
        dolfpsw=(TextView)findViewById(R.id.dlfpsw);
        docloginbtn1=(Button) findViewById(R.id.docloginbtn);
        drr1=(Button)findViewById(R.id.button3);

        docloginbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String dlemail = doclemail.getText().toString();
                String dlpass = doclpass.getText().toString();


                if (dlemail.isEmpty()){
                    doclemail.setError("E-MAIL IS REQUIRED");
                    doclemail.requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(dlemail).matches()){
                    doclemail.setError("ENTER VALID E-MAIL");
                    doclemail.requestFocus();
                    return;
                }

                if (dlpass.isEmpty()){
                    doclpass.setError("PASSWORD IS REQUIRED");
                    doclpass.requestFocus();
                    return;

                }
                if (dlpass.length()<8){
                    doclpass.setError("8 CHARACTERS IS REQUIRED");
                    doclpass.requestFocus();
                    return;

                }


                ppbar.setVisibility(View.VISIBLE);
                mAuth.signInWithEmailAndPassword(dlemail,dlpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser DOCTOR = FirebaseAuth.getInstance().getCurrentUser();

                            if (DOCTOR.isEmailVerified()) {

                                Intent intent=new Intent(getApplicationContext(),timepass.class);
                                startActivity(intent);

                            } else {
                                DOCTOR.sendEmailVerification();
                                Toast.makeText(doctorlogin.this, "CHECK YOUR E-MAIL TO VERIFY YOUR ACCOUNT ", Toast.LENGTH_LONG).show();
                                ppbar.setVisibility(View.GONE);

                            }
                        }

                        else {
                            Toast.makeText(doctorlogin.this, "ACCOUNT NOT FOUND", Toast.LENGTH_LONG).show();
                            ppbar.setVisibility(View.GONE);
                        }

                    }
                });


            }
        });

        dolfpsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),doctorforgotpsw.class);
                startActivity(intent);
            }
        });
        drr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(getApplicationContext(),doctorregiandpro.class);
                startActivity(intent);
            }
        });

    }
}
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
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {
    EditText email;
    Button respsw;
    ProgressBar pb;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        email =(EditText) findViewById(R.id.email);
        respsw=(Button) findViewById(R.id.respsw);
        pb=(ProgressBar)findViewById(R.id.pb);
        getWindow().setStatusBarColor(ContextCompat.getColor(ForgotPassword.this,R.color.endc));
        auth= FirebaseAuth.getInstance();

        respsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetpassword();
            }
        });

    }
    private void  resetpassword(){
        String remail=email.getText().toString();
        if (remail.isEmpty())
        {
            email.setError("E-MAIL IS REQUIRED!");
            email.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(remail).matches()){
            email.setError("ENTER VALID E-MAIL");
            email.requestFocus();
            return;
        }
        pb.setVisibility(View.VISIBLE);
        auth.sendPasswordResetEmail(remail).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(ForgotPassword.this,"CHECK YOU E-MAIL TO RESET PASSWORD ",Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(ForgotPassword.this,"TRY AGAIN!",Toast.LENGTH_LONG).show();
                }
            }
        });


    }


}
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
import com.google.firebase.auth.FirebaseAuth;

public class doctorforgotpsw extends AppCompatActivity {
    EditText docfemail;
    Button docfrespsw;
    ProgressBar docpb;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorforgotpsw);
        getWindow().setStatusBarColor(ContextCompat.getColor(doctorforgotpsw.this, R.color.docstatusbar));
        docfemail =(EditText) findViewById(R.id.dfemail);
        docfrespsw=(Button) findViewById(R.id.dfrespsw);
        docpb=(ProgressBar)findViewById(R.id.dfppbar);

        auth= FirebaseAuth.getInstance();

        docfrespsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetpassword();
            }
        });

    }
    private void  resetpassword(){
        String remail=docfemail.getText().toString();
        if (remail.isEmpty())
        {
            docfemail.setError("E-MAIL IS REQUIRED!");
            docfemail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(remail).matches()){
            docfemail.setError("ENTER VALID E-MAIL");
            docfemail.requestFocus();
            return;
        }
        docpb.setVisibility(View.VISIBLE);
        auth.sendPasswordResetEmail(remail).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(doctorforgotpsw.this,"CHECK YOU E-MAIL TO RESET PASSWORD ",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(doctorforgotpsw.this,"TRY AGAIN!",Toast.LENGTH_LONG).show();
                }
            }
        });


    }


}
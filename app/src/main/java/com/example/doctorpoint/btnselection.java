package com.example.doctorpoint;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class btnselection extends AppCompatActivity {


    static btnselection INSTANCE;
    static btnselection INSTANCEdoc;
    String docname;
    String PATIENTNAME;
    String pname123;
    String unique;
    Button today,tomorrow,dayafter,time1,time2,time3,time4,conform;
    int count=0;

    DatabaseReference reference=FirebaseDatabase.getInstance().getReference("patient")
            .child(FirebaseAuth.getInstance().getCurrentUser().getUid());

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        INSTANCE=this;
        INSTANCEdoc=this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btnselection);
        getWindow().setStatusBarColor(ContextCompat.getColor(btnselection.this,R.color.btnselectionback));
        today=(Button) findViewById(R.id.today);
        tomorrow=(Button) findViewById(R.id.tomorrow);
        dayafter=(Button) findViewById(R.id.dayafter);
        time1=(Button) findViewById(R.id.time1);
        time2=(Button) findViewById(R.id.time2);
        time3=(Button) findViewById(R.id.time3);
        time4=(Button) findViewById(R.id.time4);
        conform=(Button) findViewById(R.id.conform);

        conform.setEnabled(false);


        //tv=(TextView) findViewById(R.id.tv);

        docname=getIntent().getStringExtra("docname");

        //Toast.makeText(getApplicationContext(),"Doctor name: "+docname,Toast.LENGTH_LONG).show();

       //null//Toast.makeText(btnselection.this,"PATIENT NAME: "+pname,Toast.LENGTH_LONG).show();

        pnamedisplay();

      //  tv.setText(pname);
        today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                tomorrow.setEnabled(false);
                dayafter.setEnabled(false);
                today.setEnabled(false);
                if (count==2)
                {
                    conform.setEnabled(true);
                }
            }
        });

        tomorrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                today.setEnabled(false);
                dayafter.setEnabled(false);
                tomorrow.setEnabled(false);
                if (count==2)
                {
                    conform.setEnabled(true);
                }
            }
        });

        dayafter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                today.setEnabled(false);
                tomorrow.setEnabled(false);
                dayafter.setEnabled(false);
                if (count==2)
                {
                    conform.setEnabled(true);
                }
            }
        });

        time1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                time2.setEnabled(false);
                time3.setEnabled(false);
                time1.setEnabled(false);
                time4.setEnabled(false);
                if (count==2)
                {
                    conform.setEnabled(true);
                }
            }
        });

        time2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                time1.setEnabled(false);
                time3.setEnabled(false);
                time2.setEnabled(false);
                time4.setEnabled(false);

                if (count==2)
                {
                    conform.setEnabled(true);
                }
            }
        });

        time3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                time1.setEnabled(false);
                time2.setEnabled(false);
                time3.setEnabled(false);
                time4.setEnabled(false);
                if (count==2)
                {
                    conform.setEnabled(true);
                }
            }
        });
        time4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                time1.setEnabled(false);
                time2.setEnabled(false);
                time3.setEnabled(false);
                time4.setEnabled(false);
                if (count==2)
                {
                    conform.setEnabled(true);
                }
            }
        });

        conform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "APPOINTMENT BOOKED SUCCESSFULLY!", Toast.LENGTH_LONG).show();
                conform.setEnabled(false);
            }
        });

    }

    public void pnamedisplay()
    {

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 pname123=dataSnapshot.child("USERNAME").getValue().toString();
                //Toast.makeText(btnselection.this, "pname:"+pname123, Toast.LENGTH_LONG).show();
                 copy(pname123);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


            }
        });


    }
 public String copy(String abcd)
 {
     PATIENTNAME=""+abcd;
     passString(PATIENTNAME);
     return PATIENTNAME;
 }

    public String passString(String ti1)
    {
        unique=ti1;
       // Toast.makeText(btnselection.this,"PATIENT NAME UNIQUE == "+unique,Toast.LENGTH_LONG).show();
        return unique;
    }
    public static btnselection getActivityInstance1()
    {
        return INSTANCEdoc;
    }

    public String getunique()
    {
        return this.unique;

    }

    public static btnselection getActivityInstance()
    {
        return INSTANCE;
    }

    public String getData()
    {
        return this.docname;

    }















}

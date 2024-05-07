package com.example.doctorpoint;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class bookappointment extends AppCompatActivity {

    RecyclerView recview1;
    FirebaseDatabase db;
    DatabaseReference root;
    myadapter1 adapter1;
    ArrayList<model> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookappointment);
        getWindow().setStatusBarColor(ContextCompat.getColor(bookappointment.this, R.color.pviewdocpro));

        db=FirebaseDatabase.getInstance();
        root=db.getReference().child("Doctor");

        recview1=findViewById(R.id.recview1);
        recview1.setHasFixedSize(true);
        recview1.setLayoutManager(new LinearLayoutManager(this));

        list=new ArrayList<>();
        adapter1=new myadapter1(this,list);

        recview1.setAdapter(adapter1);

        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    model doctormodel=dataSnapshot.getValue(model.class);
                    list.add(doctormodel);
                }
                adapter1.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}

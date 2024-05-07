package com.example.doctorpoint;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter1 extends RecyclerView.Adapter<myadapter1.myviewholder1>
{

    ArrayList<model> mlist;
    Context context;

    public myadapter1(Context context,ArrayList<model> mlist)
    {
        this.mlist=mlist;
        this.context=context;
    }

    @NonNull
    @Override
    public myviewholder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.singlerowdesign1,parent,false);
        return new myviewholder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder1 holder, int position) {
        model doctormodel= mlist.get(position);
        holder.name1.setText(doctormodel.getName());

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public static class myviewholder1 extends RecyclerView.ViewHolder
    {
        TextView name1;
        View rootView;

        public myviewholder1(@NonNull View itemView) {
            super(itemView);

            rootView=itemView;
            name1=itemView.findViewById(R.id.name1);

            itemView.findViewById(R.id.bookbtn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //String name=name1.getText().toString();
                    //btnselection obj=new btnselection(name);
                    //Toast.makeText(obj, "name = "+name, Toast.LENGTH_LONG).show();

                    Intent intent=new Intent(rootView.getContext(),btnselection.class);
                    intent.putExtra("docname",name1.getText().toString());
                    //LocalBroadcastManager.getInstance(itemView.getContext()).sendBroadcast(intent);
                    rootView.getContext().startActivity(intent);
                }
            });
        }
    }
}
package com.example.doctorpoint;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class descfragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    String name1,qualification1,address1,experience1,charges1;

    public descfragment() {

    }

    public descfragment(String name, String qualification, String address,String experience, String charges) {
        this.name1 = name;
        this.qualification1 = qualification;
        this.address1 = address;
        this.experience1 = experience;
        this.charges1 = charges;
    }


    public static descfragment newInstance(String param1, String param2) {
        descfragment fragment = new descfragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_descfragment, container, false);

        ImageView image2 = view.findViewById(R.id.image2);
        TextView name = view.findViewById(R.id.name);
        TextView qualification = view.findViewById(R.id.qualification);
        TextView experience = view.findViewById(R.id.experience1);
        TextView clinicaddress = view.findViewById(R.id.clinicaddress);
        TextView charges = view.findViewById(R.id.charges);

        name.setText("NAME: "+name1);
        qualification.setText("QUALIFICATION: " + qualification1);
        experience.setText("EXPERIENCE: " + experience1);
        clinicaddress.setText("ADDRESS: " + address1);
        charges.setText("CHARGES: " + charges1);

        return view;
    }

    public void onBackPressed() {
        AppCompatActivity activity = (AppCompatActivity) getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapper, new recfragment()).addToBackStack(null).commit();

    }
}
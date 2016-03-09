package com.wooa.toyproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    TextView tv_name;
    TextView tv_age;
    TextView tv_major;

    String name, age, major;


    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b;
        b =  getArguments();
        name = b.getString("name");
        age = b.getString("age");
        major = b.getString("major");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        tv_name = (TextView)view.findViewById(R.id.tv_name);
        tv_age = (TextView)view.findViewById(R.id.tv_age);
        tv_major = (TextView)view.findViewById(R.id.tv_major);

        tv_name.setText(name);
        tv_age.setText(age);
        tv_major.setText(major);

        return view;
    }

}

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

    User user;

    TextView tv_name;
    TextView tv_age;
    TextView tv_major;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public void setUser(User user){
        Log.e("ProfileFragment", "setUser");
        this.user = user;
    }

    public User getUser(){
        Log.e("ProfileFragment", "getUser");
        return user;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        tv_name = (TextView)view.findViewById(R.id.tv_name);
        tv_age = (TextView)view.findViewById(R.id.tv_age);
        tv_major = (TextView)view.findViewById(R.id.tv_major);

        tv_name.setText(getUser().getUserName());
        tv_age.setText(getUser().getUserAge());
        tv_major.setText(getUser().getUserMajor());

        return view;
    }

}

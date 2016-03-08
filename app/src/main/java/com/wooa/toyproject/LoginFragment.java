package com.wooa.toyproject;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener{

    EditText edit_name;
    EditText edit_age;
    EditText edit_major;

    Button btn_send;

    private ActivityCallback callback;

    User user;
    public interface ActivityCallback {
        void onSendButtonClick(User user);
    }

    public void setOnActivityCallback(ActivityCallback callback){
        this.callback = callback;
    }

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_login, container, false);
        edit_name = (EditText)view.findViewById(R.id.edit_name);
        edit_age = (EditText)view.findViewById(R.id.edit_age);
        edit_major = (EditText)view.findViewById(R.id.edit_major);
        btn_send = (Button) view.findViewById(R.id.btn_send);

        btn_send.setOnClickListener(this);

        return view;
    }

    public void onButtonClick(){

    }

    @Override
    public void onClick(View v) {
        if(callback != null){
            user = new User();
            user.setUserName(edit_name.getText().toString());
            user.setUserAge(edit_age.getText().toString());
            user.setUserMajor(edit_major.getText().toString());

            callback.onSendButtonClick(user);
        }
    }
}

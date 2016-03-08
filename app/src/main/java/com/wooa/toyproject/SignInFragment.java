package com.wooa.toyproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends Fragment {

    EditText edit_user_name, edit_user_age, edit_user_major;
    Button btn_send;

    String name, age, major;
    User user;

    private ActivityCallback callback;

    public interface ActivityCallback {
        void onSendButtonClick(User user);
    }

    public void setOnAcivityCallback(ActivityCallback callback) {
        this.callback = callback;
    }

    public SignInFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sign_in, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edit_user_name = (EditText) view.findViewById(R.id.edit_user_name);
        edit_user_age = (EditText) view.findViewById(R.id.edit_user_age);
        edit_user_major = (EditText) view.findViewById(R.id.edit_user_major);
        user = new User();

        edit_user_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() > 0)
                    user.setName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        edit_user_age.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() > 0)
                    user.setAge(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        edit_user_major.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() > 0)
                    user.setMajor(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        btn_send = (Button) view.findViewById(R.id.btn_send);


        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!user.getName().isEmpty() && !user.getAge().isEmpty() && !user.getMajor().isEmpty()){

                    callback.onSendButtonClick(user);
                }
            }
        });
    }
}

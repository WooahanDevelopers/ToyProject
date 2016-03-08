package com.wooa.toyproject;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LoginFragment.ActivityCallback {

    LoginFragment loginFragment = new LoginFragment();
    ProfileFragment profileFragment = new ProfileFragment();

    TextView tv_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_content = (TextView)findViewById(R.id.tv_content);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, loginFragment, "login").commit();


        loginFragment.setOnActivityCallback(this);
    }

    @Override
    public void onSendButtonClick(User user) {
        tv_content.setText("내용 : " + user.getUserName() + " " + user.getUserAge() + " " + user.getUserMajor());
        if ( getSupportFragmentManager().findFragmentByTag("login") != null ) {
            getSupportFragmentManager().beginTransaction().hide(loginFragment).commit();
            Bundle b = new Bundle();
            b.putString("FF","Ff");
            profileFragment.setArguments(b);
            getSupportFragmentManager().beginTransaction().add(R.id.container, profileFragment, "profile").commit();
            profileFragment.setUser(user);
        }

    }
}

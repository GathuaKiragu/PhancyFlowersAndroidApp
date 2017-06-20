package com.example.kiragu.phancyflowers;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.example.kiragu.phancyflowers.ui.LoginActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.loginButton)Button mLoginButton;
    @Bind(R.id.signUpButton) Button mSignUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        VideoView videoview = (VideoView) findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.bg);
        videoview.setVideoURI(uri);
        videoview.start();

        mLoginButton.setOnClickListener(this);
        mSignUpButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v == mLoginButton) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }
        if (v == mSignUpButton) {
            Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intent);
        }
    }
}

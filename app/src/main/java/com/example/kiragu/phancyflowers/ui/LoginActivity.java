package com.example.kiragu.phancyflowers.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kiragu.phancyflowers.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.loginButton1)
    Button mLoginButton1;
    @Bind(R.id.loginTextView)
    TextView mLoginTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mLoginButton1.setOnClickListener(this);
        mLoginTextView.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if (view == mLoginButton1) {
            Intent intent = new Intent(LoginActivity.this, ProductListActivity.class);
            startActivity(intent);
            finish();
        }
        if (view == mLoginTextView) {
            Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(intent);
            finish();
        }
    }
}

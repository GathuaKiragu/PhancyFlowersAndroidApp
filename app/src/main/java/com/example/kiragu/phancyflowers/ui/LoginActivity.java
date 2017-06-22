package com.example.kiragu.phancyflowers.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kiragu.phancyflowers.R;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String TAG = LoginActivity.class.getSimpleName();
    @Bind(R.id.loginButton1)
    Button mLoginButton1;
    @Bind(R.id.loginTextView)
    TextView mLoginTextView;
    @Bind(R.id.emailTextView)
    EditText mEmailView;
    @Bind(R.id.passwordEditText) EditText mPassword;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mAuth = FirebaseAuth.getInstance();

        mLoginButton1.setOnClickListener(this);
        mLoginTextView.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if (view == mLoginButton1) {
            loginWithPassword();
        }
        if (view == mLoginTextView) {
            Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(intent);
            finish();
        }
    }
    private void loginWithPassword() {
        String email = mEmailView.getText().toString().trim();
        String password = mPassword.getText().toString().trim();
        if (email.equals("")) {
            mEmailView.setError("Please enter your email");
            return;
        }
        if (password.equals("")) {
            mPassword.setError("Password cannot be blank");
            return;
        }
    }
}

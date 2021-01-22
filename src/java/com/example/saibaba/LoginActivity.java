package com.example.saibaba;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText Email;
    Button Login;
    EditText Password;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.Email = (EditText) findViewById(R.id.Email);
        this.Password = (EditText) findViewById(R.id.Password);
        Button button = (Button) findViewById(R.id.Login);
        this.Login = button;
        button.setOnClickListener(new OnClickListener() {
            private View view;

            public void onClick(View view) {
                String email = LoginActivity.this.Email.getText().toString().trim();
                String pwd = LoginActivity.this.Password.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    LoginActivity.this.Email.setError("Please enter email address");
                } else if (TextUtils.isEmpty(pwd)) {
                    LoginActivity.this.Password.setError("Please enter a password");
                } else if (pwd.length() < 6) {
                    LoginActivity.this.Password.setError("Password must be>= 6 characters");
                } else {
                    this.view = view;
                    LoginActivity.this.startActivity(new Intent(LoginActivity.this, AppActivity.class));
                }
            }
        });
    }
}

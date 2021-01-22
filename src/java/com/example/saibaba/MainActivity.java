package com.example.saibaba;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText Email;
    Button Login;
    EditText Password;
    Button Register;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.Email = (EditText) findViewById(R.id.Email);
        this.Password = (EditText) findViewById(R.id.Password);
        this.Register = (Button) findViewById(R.id.Register);
        this.Login = (Button) findViewById(R.id.Login);
        this.Register.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String email = MainActivity.this.Email.getText().toString().trim();
                String pwd = MainActivity.this.Password.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    MainActivity.this.Email.setError("Please enter email address");
                } else if (TextUtils.isEmpty(pwd)) {
                    MainActivity.this.Password.setError("Please enter a password");
                } else if (pwd.length() < 6) {
                    MainActivity.this.Password.setError("Password must be>= 6 characters");
                } else {
                    MainActivity.this.startActivity(new Intent(MainActivity.this, AppActivity.class));
                }
            }
        });
        this.Login.setOnClickListener(new OnClickListener() {
            private View view;

            public void onClick(View view) {
                this.view = view;
                MainActivity.this.startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });
    }
}

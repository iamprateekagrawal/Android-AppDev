package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignupPage extends AppCompatActivity {
    EditText et_username, et_password;
    Button signupbutton;
    TextView goto_signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);

        et_username = findViewById(R.id.username_et);
        et_password = findViewById(R.id.password_et);
        signupbutton = findViewById(R.id.signup_bt);
        goto_signin = findViewById(R.id.login_tv);

        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateAccount();
            }
        });

        goto_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupPage.this, LoginPage.class);
                startActivity(intent);
            }
        });
    }
    private void CreateAccount(){
        String login_username, login_password;
        login_username = et_username.getText().toString();
        login_password = et_password.getText().toString();

        SharedPreferences userdetails = getSharedPreferences("USER DETAILS",MODE_PRIVATE);
        SharedPreferences.Editor editor = userdetails.edit();
        editor.putString(login_username, login_password);
        editor.apply();

        Toast.makeText(this, "Account Created Successfully", Toast.LENGTH_LONG).show();
    }
}

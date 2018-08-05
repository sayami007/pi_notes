package com.planetinnovative.notesapplication.activity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.planetinnovative.notesapplication.R;
import com.planetinnovative.notesapplication.app.Constant;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etEmail, etPassword;
    private Button login;
    private String emailText, passwordText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etEmail = findViewById(R.id.email);
        etPassword = findViewById(R.id.password);
        login = findViewById(R.id.email_sign_in_button);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        emailText = etEmail.getText().toString();
        passwordText = etPassword.getText().toString();
        if (emailText.equals("admin") && passwordText.equals("admin")) {


            SharedPreferences pref = getSharedPreferences(Constant.SP_DB_NAME, MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            editor.putString(Constant.USERNAME, "admin");
            editor.putString(Constant.PASSWORD, "admin");
            editor.apply();

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);

            finish();

        } else {
            Toast.makeText(this, "Login Error", Toast.LENGTH_SHORT).show();
        }
    }
}


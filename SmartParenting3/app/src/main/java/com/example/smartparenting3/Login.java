package com.example.smartparenting3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    public static EditText Useremail;
    public static EditText Password;
    public static String user;
    public static String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Useremail = (EditText) findViewById(R.id.useremail);
        Password = (EditText) findViewById(R.id.password);
    }
    public void onClick(View view){
        user = Useremail.getText().toString();
        pass = Password.getText().toString();

        if(view.getId() == R.id.login){
            Intent intent = new Intent(this, HomeScreen.class);
            startActivity(intent);
        }

        if(view.getId()== R.id.signup){
            Intent intent = new Intent(this, SignUp.class);
            startActivity(intent);
        }
}
}
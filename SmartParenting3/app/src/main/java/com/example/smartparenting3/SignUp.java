package com.example.smartparenting3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    public static EditText username;
    public static EditText email;
    public static EditText userpassword;
    public static EditText userphonenumber;
    public static String Username;
    public static String Email;
    public static String Password;
    public static String PhoneNumber;
    private CheckBox myCheckbox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        userpassword = (EditText) findViewById(R.id.userpassword);
        userphonenumber = (EditText) findViewById(R.id.userphonenumber);
        myCheckbox = findViewById(R.id.checkBox);

}
    public void onclick(View view) {

        if (view.getId() == R.id.RegisterForAccount) {

            Username = username.getText().toString();
            Email = email.getText().toString();
             Password= userpassword.getText().toString();
            PhoneNumber = userphonenumber.getText().toString();


            if (myCheckbox.isChecked()) {

                Toast.makeText(SignUp.this, "Checkbox is checked", Toast.LENGTH_SHORT).show();
            } else {

                Toast.makeText(SignUp.this, "Checkbox is unchecked", Toast.LENGTH_SHORT).show();
            }

            }
        if(view.getId() == R.id.loginhere) {
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
        }

            Intent intent = new Intent(this, HomeScreen.class);
            startActivity(intent);


        }

    }

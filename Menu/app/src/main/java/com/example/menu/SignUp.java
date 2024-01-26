package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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

    Button postbtn;

    Connection connection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        userpassword = (EditText) findViewById(R.id.userpassword);
        userphonenumber = (EditText) findViewById(R.id.userphonenumber);
        myCheckbox = findViewById(R.id.checkBox);


        postbtn = findViewById(R.id.RegisterForAccount);
        postbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCreditData();
            }
        });

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

    void addCreditData(){


        Db_Connection conn = new Db_Connection();
        connection = conn.CONN();
        try {
            if (connection != null) {
                String query = "insert into userregistration values('" + username.getText().toString() + "','" + email.getText().toString() + "','" + userpassword.getText().toString() + "','" + userphonenumber.getText().toString() + "')";
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(query);
            }
        } catch (Exception exception) {
            Log.e("Error", exception.getMessage());
        }
    }

}

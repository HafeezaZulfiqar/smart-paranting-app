package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login extends AppCompatActivity {
    public static EditText Useremail;
    public static EditText Password;
    public static String user;
    public static String pass;

    Connection connection;

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


    public void loginCheck(){


        Db_Connection db =new Db_Connection();
        connection = db.CONN();

        if(db != null){
            try {
                String query = "SELECT * FROM userregistration WHERE username = '" + Useremail.getText() + "' AND password = '" + Password.getText() + "' ";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    Intent intent = new Intent(Login.this,HomeScreen.class);
                    startActivity(intent);

                }
                connection.close();
            } catch (Exception ex) {
                Toast.makeText(this, "Invaled Email OR Password", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }

    }
}
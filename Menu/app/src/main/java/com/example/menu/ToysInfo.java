package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ToysInfo extends AppCompatActivity {
ImageButton imgbutton;
Connection connection;

Button postbtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toys_info);
        imgbutton= (ImageButton) findViewById(R.id.toysinfobbackbutton);
        imgbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ToysInfo.this,HomeScreen.class );
                startActivity(intent);
            }
        });


        postbtn = findViewById(R.id.ToyPostButton);
        postbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCreditData();
            }
        });

    }
    void addCreditData(){
        EditText name = (EditText) findViewById(R.id.Nameoftoy);
        EditText number = (EditText) findViewById(R.id.ProsNConsofToys);



        Db_Connection conn = new Db_Connection();
        connection = conn.CONN();
        try {
            if (connection != null) {
                String query = "insert into toys values('" + name.getText().toString() + "','" + number.getText().toString() + "')";
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(query);
            }
        } catch (Exception exception) {
            Log.e("Error", exception.getMessage());
        }
    }
}
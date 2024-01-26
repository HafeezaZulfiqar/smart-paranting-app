package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CareGiverForm extends AppCompatActivity {

    Connection connection;
    Button postbtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_giver_form);

        postbtn = findViewById(R.id.CareGiverPostButton);
        postbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCreditData();
            }
        });
    }

    void addCreditData(){
        EditText name = (EditText) findViewById(R.id.CareGiverName);
        EditText number = (EditText) findViewById(R.id.CareGiverContactno);
        EditText address = (EditText) findViewById(R.id.CareGiverAddress);

        Db_Connection conn = new Db_Connection();
        connection = conn.CONN();
        try {
            if (connection != null) {
                String query = "insert into caregiver values('" + name.getText().toString() + "','"+ number.getText().toString() +"','"+ address.getText().toString() +"')";
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(query);
                Toast.makeText(this, "Data  inserted", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception exception) {
            Toast.makeText(this, "Data not inserted", Toast.LENGTH_SHORT).show();
        }
    }
}
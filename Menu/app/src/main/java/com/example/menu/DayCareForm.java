package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DayCareForm extends AppCompatActivity {
    Connection connection;
    Button postbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_care_form);

        postbtn = findViewById(R.id.DayCarePostButton);
        postbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCreditData();
            }
        });
    }

    void addCreditData(){
        EditText name = (EditText) findViewById(R.id.NAME);
        EditText number = (EditText) findViewById(R.id.NUMBER);
        EditText address = (EditText) findViewById(R.id.ADDRESS);

        Db_Connection conn = new Db_Connection();
        connection = conn.CONN();
        try {
            if (connection != null) {
                String query = "insert into daycare values('" + name.getText().toString() + "','"+ number.getText().toString() +"','"+ address.getText().toString() +"')";
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(query);
                Toast.makeText(this, "Data  inserted", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception exception) {
            Log.e("Error",exception.getMessage());
        }
    }
}
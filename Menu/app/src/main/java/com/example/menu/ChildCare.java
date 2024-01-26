package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ChildCare extends AppCompatActivity {
ImageButton imgbutton;
TextView textView52;
Connection connection;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_care);
        imgbutton= (ImageButton) findViewById(R.id.childcarebackbutton);
        imgbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChildCare.this,HomeScreen.class );
                startActivity(intent);
            }
        });

        storeDatainArrays();
    }

    void storeDatainArrays(){
        textView52 = findViewById(R.id.textView52);
        Db_Connection db =new Db_Connection();
        connection = db.CONN();

        if(db != null){
            try {
                String query = "SELECT  * FROM childcare";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    textView52.setText(resultSet.getString(1));


                }
                connection.close();
            } catch (Exception ex) {
                Log.e("Error", ex.getMessage());
            }
        }
        else{
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }
}
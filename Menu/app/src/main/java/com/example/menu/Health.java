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
import java.sql.SQLException;
import java.sql.Statement;

public class Health extends AppCompatActivity {
ImageButton imgbutton;
Connection connection;
TextView health;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);
        imgbutton= (ImageButton) findViewById(R.id.healthbackbutton);
        imgbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Health.this,HomeScreen.class );
                startActivity(intent);
            }
        });

        storeDatainArrays();
    }
    void storeDatainArrays(){
        health = findViewById(R.id.healthText);
        Db_Connection db =new Db_Connection();
        connection = db.CONN();

        if(db != null){
            try {
                String query = "SELECT  * FROM Health";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    health.setText(resultSet.getString(1));


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
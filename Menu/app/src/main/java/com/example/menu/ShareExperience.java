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
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShareExperience extends AppCompatActivity {
ImageButton imgbutton;
Connection connection;
Button postbtn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_experience);
        imgbutton= (ImageButton) findViewById(R.id.shareexperiencebackbutton);
        imgbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShareExperience.this,HomeScreen.class );
                startActivity(intent);
            }
        });
        postbtn = findViewById(R.id.ShareExperienceButton);
        postbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCreditData();
            }
        });

    }
    void addCreditData(){
        EditText name = (EditText) findViewById(R.id.ShareExperience);


        Db_Connection conn = new Db_Connection();
        connection = conn.CONN();
        try {
            if (connection != null) {
                String query = "insert into userexperience values('" + name.getText().toString() + "')";
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(query);
                Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception exception) {
            Toast.makeText(this, "Data not Inserted", Toast.LENGTH_SHORT).show();
        }
    }
}
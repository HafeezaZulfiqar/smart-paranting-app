package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Blog extends AppCompatActivity {
ImageButton imgbutton;
Connection connection;
TextView name1,name2,name3,blog1,blog2,blog3,date1,date2,date3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        imgbutton= (ImageButton) findViewById(R.id.blogbackbutton);
        imgbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Blog.this,HomeScreen.class );
                startActivity(intent);
            }
        });

        data1();
        data2();
        data3();
    }


    void data1(){
        name1 = findViewById(R.id.textView2);
        blog1 = findViewById(R.id.textView3);
        date1 = findViewById(R.id.textView4);

        Db_Connection db =new Db_Connection();
        connection = db.CONN();

        if(db != null){
            try {
                String query = "SELECT  Top 1 * FROM blog";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    name1.setText(resultSet.getString(1));
                    blog1.setText(resultSet.getString(2));
                    date1.setText(resultSet.getString(3));

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

    void data2(){
        name2 = findViewById(R.id.textView5);
        blog2 = findViewById(R.id.textView6);
        date2 = findViewById(R.id.textView7);

        Db_Connection db =new Db_Connection();
        connection = db.CONN();

        if(db != null){
            try {
                String query = "SELECT * FROM blog where name = 'Ms Saba'";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    name2.setText(resultSet.getString(1));
                    blog2.setText(resultSet.getString(2));
                    date2.setText(resultSet.getString(3));

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

    void data3(){
        name3 = findViewById(R.id.textView8);
        blog3 = findViewById(R.id.textView9);
        date3 = findViewById(R.id.textView10);

        Db_Connection db =new Db_Connection();
        connection = db.CONN();

        if(db != null){
            try {
                String query = "SELECT * FROM blog where name = 'Ms Rija'";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    name3.setText(resultSet.getString(1));
                    blog3.setText(resultSet.getString(2));
                    date3.setText(resultSet.getString(3));

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
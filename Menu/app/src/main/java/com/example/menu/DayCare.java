package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DayCare extends AppCompatActivity {
ImageButton imgbutton;
Button button;

Connection connection;

    ArrayList<String> name,num,add;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_care);
        button=(Button)findViewById(R.id.DayCareFormButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DayCare.this, DayCareForm.class );
                startActivity(intent);
            }
        });
        imgbutton= (ImageButton) findViewById(R.id.daycarebackbutton);
        imgbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DayCare.this,HomeScreen.class );
                startActivity(intent);
            }
        });




        //RecyclerView

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView2);



        name = new ArrayList<>();
        num = new ArrayList<>();
        add = new ArrayList<>();

        storeDatainArrays();
        DayCareCustomeRecyclerViewAdapter customeAdapterRecyclerView = new DayCareCustomeRecyclerViewAdapter(DayCare.this,name,num,add);
        recyclerView.setAdapter(customeAdapterRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(DayCare.this));
    }

    void storeDatainArrays(){
        Db_Connection db =new Db_Connection();
        connection = db.CONN();

        if(db != null){
            try {
                String query = "SELECT  * FROM daycare";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    name.add(resultSet.getString(1));
                    num.add(resultSet.getString(2));
                    add.add(resultSet.getString(2));


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
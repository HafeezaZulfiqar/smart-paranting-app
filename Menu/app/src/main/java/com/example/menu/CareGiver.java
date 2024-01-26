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

public class CareGiver extends AppCompatActivity {

    ArrayList<String> name,num,add;

    RecyclerView recyclerView;
    ImageButton imgbutton;
    Button button;

    Connection connection;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_giver);
        imgbutton= (ImageButton) findViewById(R.id.caregiverbackbutton);
        button=(Button) findViewById(R.id.CareGiveFormButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(CareGiver.this,CareGiverForm.class);
                startActivity(intent);
            }
        });
        imgbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CareGiver.this,HomeScreen.class );
                startActivity(intent);


            }

        });



        //RecyclerView

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);



        name = new ArrayList<>();
        num = new ArrayList<>();
        add = new ArrayList<>();

        storeDatainArrays();
        CareGiverCustomeAdapter customeAdapterRecyclerView = new CareGiverCustomeAdapter(CareGiver.this,name,num,add);
        recyclerView.setAdapter(customeAdapterRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(CareGiver.this));

    }


    void storeDatainArrays(){
        Db_Connection db =new Db_Connection();
        connection = db.CONN();

        if(db != null){
            try {
                String query = "SELECT  * FROM caregiver";
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
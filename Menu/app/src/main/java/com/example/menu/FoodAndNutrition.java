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

public class FoodAndNutrition extends AppCompatActivity {
ImageButton imgbutton;
TextView textView30;
Connection connection;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_and_nutrition);
        imgbutton= (ImageButton) findViewById(R.id.foodnutritionbackbutton);
        imgbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FoodAndNutrition.this,HomeScreen.class );
                startActivity(intent);
            }
        });

        storeDatainArrays();
    }


    void storeDatainArrays(){
        textView30 = findViewById(R.id.textView30);
        Db_Connection db =new Db_Connection();
        connection = db.CONN();

        if(db != null){
            try {
                String query = "SELECT  * FROM Food";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    textView30.setText(resultSet.getString(1));


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

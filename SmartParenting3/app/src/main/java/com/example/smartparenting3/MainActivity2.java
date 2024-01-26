package com.example.smartparenting3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);}
        public void onClick(View view){


            if(view.getId() == R.id.registerbutton){
                Intent intent = new Intent(this, Login.class);
                startActivity(intent);
            }

            if(view.getId()== R.id.signinbutton){
                Intent intent = new Intent(this, SignUp.class);
                startActivity(intent);
            }
        }
    }

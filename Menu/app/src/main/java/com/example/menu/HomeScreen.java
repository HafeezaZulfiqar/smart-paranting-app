package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class HomeScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Menu menu;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);
        /*---------------------Hooks------------------------*/
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        /*---------------------Tool Bar------------------------*/
        setSupportActionBar(toolbar);
        /*---------------------Navigation Drawer Menu------------------------*/
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new
                ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.close_nav, R.string.open_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_view);

    }


    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

       if(menuItem.getItemId() == R.id.blog) {
           Intent intent = new Intent(HomeScreen.this, Blog.class);
           startActivity(intent);

       }
       else if(menuItem.getItemId() == R.id.home){
           Intent intent =new Intent(HomeScreen.this,HomeScreen.class);
           startActivity(intent);
       }
       else if (menuItem.getItemId()==R.id.caregiver) {
           Intent intent= new Intent(HomeScreen.this,CareGiver.class);
           startActivity(intent);
       }
       else if(menuItem.getItemId() == R.id.childcare){
           Intent intent =new Intent(HomeScreen.this,ChildCare.class);
           startActivity(intent);
       }
       else if (menuItem.getItemId()==R.id.childdevelopment) {
           Intent intent= new Intent(HomeScreen.this,ChildDevelopment.class);
           startActivity(intent);
       }
       else if(menuItem.getItemId() == R.id.daycare){
           Intent intent =new Intent(HomeScreen.this,DayCare.class);
           startActivity(intent);
       }
       else if (menuItem.getItemId()==R.id.foodandnutrition) {
           Intent intent= new Intent(HomeScreen.this,FoodAndNutrition.class);
           startActivity(intent);
       }
       else if (menuItem.getItemId()==R.id.givereviewsaboutdoctor) {
           Intent intent= new Intent(HomeScreen.this,GiveReviewsOfDoctor.class);
           startActivity(intent);
       }
       else if (menuItem.getItemId()==R.id.health) {
           Intent intent= new Intent(HomeScreen.this,Health.class);
           startActivity(intent);
       }
       else if (menuItem.getItemId()==R.id.shareexperience) {
           Intent intent= new Intent(HomeScreen.this,ShareExperience.class);
           startActivity(intent);
       }
       else if (menuItem.getItemId()==R.id.toysinfo) {
           Intent intent= new Intent(HomeScreen.this,ToysInfo.class);
           startActivity(intent);
       }
       else if (menuItem.getItemId()==R.id.logout) {
           Intent intent= new Intent(HomeScreen.this,Logout.class);
           startActivity(intent);
       }
       else {

        }
        return false;
    }
}
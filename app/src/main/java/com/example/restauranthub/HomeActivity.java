package com.example.restauranthub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btnRestaurants = findViewById(R.id.btn_restaurants);
        Button btnRecipes = findViewById(R.id.btn_recipes);

        btnRestaurants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, RestaurantListActivity.class));
            }
        });

        btnRecipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, RecipeListActivity.class));
            }
        });
    }
}
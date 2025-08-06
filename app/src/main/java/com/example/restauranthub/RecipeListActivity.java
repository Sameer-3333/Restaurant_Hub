package com.example.restauranthub;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RecipeListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);

        final ArrayList<String> recipes = new ArrayList<>();
        recipes.add("Spaghetti Carbonara");
        recipes.add("Chicken Tikka Masala");
        recipes.add("Vegetable Stir Fry");
        recipes.add("Chocolate Chip Cookies");
        recipes.add("Beef Wellington");

        final ArrayList<String> recipeUrls = new ArrayList<>();
        recipeUrls.add("https://cooking.nytimes.com/recipes/12965-spaghetti-carbonara");
        recipeUrls.add("https://www.recipetineats.com/chicken-tikka-masala/");
        recipeUrls.add("https://natashaskitchen.com/vegetable-stir-fry-recipe/");
        recipeUrls.add("https://www.kingarthurbaking.com/recipes/easy-chocolate-chip-cookies-recipe");
        recipeUrls.add("https://www.simplyrecipes.com/recipes/beef_wellington/");;

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                recipes
        );

        ListView listView = findViewById(R.id.recipe_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String url = recipeUrls.get(position);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
    }
}
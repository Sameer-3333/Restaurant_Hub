package com.example.restauranthub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RestaurantListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);

        ArrayList<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("The Gourmet Kitchen", 4.5f, "Beef Wellington", "1234567890", R.drawable.restaurant1));
        restaurants.add(new Restaurant("Ocean's Catch", 4.2f, "Lobster Thermidor", "2345678901", R.drawable.restaurant2));
        restaurants.add(new Restaurant("Pasta Paradise", 4.0f, "Truffle Pasta", "3456789012", R.drawable.restaurant3));
        restaurants.add(new Restaurant("Burger Barn", 3.8f, "Double Cheese Burger", "4567890123", R.drawable.restaurant4));
        restaurants.add(new Restaurant("Veggie Delight", 4.3f, "Quinoa Salad", "5678901234", R.drawable.restaurant1));

        RestaurantAdapter adapter = new RestaurantAdapter(this, restaurants);

        ListView listView = findViewById(R.id.restaurant_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Restaurant selectedRestaurant = restaurants.get(position);

                Intent intent = new Intent(RestaurantListActivity.this, RestaurantDetailsActivity.class);
                intent.putExtra("name", selectedRestaurant.getName());
                intent.putExtra("rating", selectedRestaurant.getRating());
                intent.putExtra("specialDish", selectedRestaurant.getSpecialDish());
                intent.putExtra("phoneNumber", selectedRestaurant.getPhoneNumber());
                intent.putExtra("imageResource", selectedRestaurant.getImageResource());

                startActivity(intent);
            }
        });
    }
}
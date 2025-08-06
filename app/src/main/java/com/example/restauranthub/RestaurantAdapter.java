package com.example.restauranthub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import java.util.ArrayList;

public class RestaurantAdapter extends ArrayAdapter<Restaurant> {

    public RestaurantAdapter(Context context, ArrayList<Restaurant> restaurants) {
        super(context, 0, restaurants);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Restaurant restaurant = getItem(position);


        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_item_restaurant, parent, false);
        }


        ImageView imageView = convertView.findViewById(R.id.restaurant_image);
        TextView nameTextView = convertView.findViewById(R.id.restaurant_name);
        RatingBar ratingBar = convertView.findViewById(R.id.restaurant_rating);
        TextView dishTextView = convertView.findViewById(R.id.special_dish);

        imageView.setImageResource(restaurant.getImageResource());
        nameTextView.setText(restaurant.getName());
        ratingBar.setRating(restaurant.getRating());
        dishTextView.setText("Specialty: " + restaurant.getSpecialDish());

        return convertView;
    }
}
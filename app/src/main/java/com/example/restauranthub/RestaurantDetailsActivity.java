package com.example.restauranthub;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RestaurantDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        float rating = intent.getFloatExtra("rating", 0);
        String specialDish = intent.getStringExtra("specialDish");
        String phoneNumber = intent.getStringExtra("phoneNumber");
        int imageResource = intent.getIntExtra("imageResource", 0);

        ImageView imageView = findViewById(R.id.detail_image);
        TextView nameTextView = findViewById(R.id.detail_name);
        RatingBar ratingBar = findViewById(R.id.detail_rating);
        TextView dishTextView = findViewById(R.id.detail_special_dish);
        Button contactButton = findViewById(R.id.btn_contact);

        imageView.setImageResource(imageResource);
        nameTextView.setText(name);
        ratingBar.setRating(rating);
        dishTextView.setText("Specialty: " + specialDish);

        contactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setData(Uri.parse("smsto:" + phoneNumber));
                startActivity(smsIntent);
            }
        });
    }
}
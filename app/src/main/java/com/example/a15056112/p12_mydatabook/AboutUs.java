package com.example.a15056112.p12_mydatabook;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class AboutUs extends AppCompatActivity {
    ActionBar ab;
    ImageView ivRP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ivRP = (ImageView) findViewById(R.id.ivRP);

        String iconURL = "https://upload.wikimedia.org/wikipedia/commons/8/80/Republic_Polytechnic_Logo.jpg";

        Picasso.with(AboutUs.this)
                .load(iconURL)
                .placeholder(R.drawable.ajax_loader)
                .error(R.drawable.error)
                .into(ivRP);

    }
}

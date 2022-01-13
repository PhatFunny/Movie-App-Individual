package com.example.moviestreamingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.jsibbold.zoomage.ZoomageView;
import com.squareup.picasso.Picasso;

public class ImageViewActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer);

        //set full screen for the activity

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Intent intent = new Intent();

        ZoomageView zoomageView = findViewById(R.id.zoom_image_view);

        if(intent != null && intent.getExtras() != null)
        {
            if(intent.getExtras().getString("image_url") != null)
            {
                String url = intent.getExtras().getString("image_url");

                Picasso.with(this).load(url).into(zoomageView);
            }
        }
    }
}
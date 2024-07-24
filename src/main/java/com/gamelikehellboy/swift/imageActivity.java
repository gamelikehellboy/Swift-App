package com.gamelikehellboy.swift;

import static android.graphics.Color.*;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

public class imageActivity extends AppCompatActivity {
    private ImageView imageView;
    private RatingBar rateBar;
    private TextView textView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        imageView = findViewById(R.id.imageView2);
        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
        anim.setDuration(2000);
        imageView.startAnimation(anim);
    }
    public void onRate(View view){
        rateBar = findViewById(R.id.ratingBar);
        textView = findViewById(R.id.textView8);
        button = findViewById(R.id.button);
        float rating = rateBar.getRating();
        Snackbar.make(rateBar,"You have given us "+rating+" stars. Thank You!",3000).show();

    }
    public void imageClick(View view){
        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
        imageView.startAnimation(anim);
    }
}
package com.gamelikehellboy.swift;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class screen2Activity extends AppCompatActivity {
    TextView s2textView;
    Button bookCycle;
    Button checkUsage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);
        s2textView = findViewById(R.id.textView4);
        bookCycle = findViewById(R.id.buttonBook);
        checkUsage = findViewById(R.id.checkUsage);
        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.EXTRA_NAME);
        s2textView.setText("Welcome to Swift "+name);
//        bookCycle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(screen2Activity.this, "Coming soon...", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
    public void bookCycleClick(View viewBook){
        Intent bookCycleButton = new Intent(this, bookCycleScreen.class);
//        Toast.makeText(this, "Processing Request...", Toast.LENGTH_SHORT).show();
        Snackbar.make(bookCycle,"Processing Request...",Toast.LENGTH_SHORT).show();
        startActivity(bookCycleButton);
    }

    public void checkUsageClick(View viewUsage){
//        Toast.makeText(this, "Usages will be updated once you book!", Toast.LENGTH_SHORT).show();
        Snackbar.make(checkUsage,"Usages will be updated once you book!",Toast.LENGTH_SHORT).show();
    }

}
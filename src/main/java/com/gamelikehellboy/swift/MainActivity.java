package com.gamelikehellboy.swift;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText editText;
    private  EditText editText2;
    EditText editTextName;
    private TextView emailText;
    private ImageView imageView;
    private TextView passTextView;

    public static final String EXTRA_NAME = "com.gamelikehellboy.mainActivity.SWIFT.sendName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button2);
        editText = findViewById(R.id.editTextTextEmailAddress2);
        editText2 = findViewById(R.id.editTextTextPassword);
        editTextName = findViewById(R.id.editTextTextPersonName2);
        emailText = findViewById(R.id.textView2);
        imageView = findViewById(R.id.imageView);
        passTextView = findViewById(R.id.textView3);
        Intent intent = new Intent(this, screen2Activity.class);
        Intent imageIntent = new Intent(this, imageActivity.class);

//        editText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                emailText.setText("Enter your email address..");
//            }
//        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(imageIntent);

            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String personName = editTextName.getText().toString();
                intent.putExtra(EXTRA_NAME,personName);
                String email = editText.getText().toString();
                String password = editText2.getText().toString();

                if ((email.length()==0)||(password.length()==0)){

                    Snackbar.make(button,"* spaces cannot be empty!",Snackbar.LENGTH_SHORT).show();
                }
                else{
                    if (email.contains("@")&& (email.contains(".com")||email.contains(".in"))){
                        if (password.length() < 8){

//                                Toast.makeText(MainActivity.this, "Password must not be less than 8", Toast.LENGTH_SHORT).show();
                            Snackbar.make(button,"Password must not be less than 8",Snackbar.LENGTH_SHORT).show();


                        }
                        else{
                            if (personName.length() > 0){
//                                Toast.makeText(MainActivity.this, "Welcome to Swift "+ personName, Toast.LENGTH_SHORT).show();
                                Snackbar.make(button,"Welcome to Swift "+personName,Snackbar.LENGTH_SHORT).show();
                                startActivity(intent);
                            }
                            else{
//                                Toast.makeText(MainActivity.this, "Welcome to Swift, Guest User", Toast.LENGTH_SHORT).show();
                                Snackbar.make(button,"Welcome to Swift, Guest User",Snackbar.LENGTH_SHORT).show();
                            }
                        }
                    }
                    else{
//                        Toast.makeText(MainActivity.this, "Invalid Email-Id...", Toast.LENGTH_SHORT).show();
                        Snackbar.make(button,"Invalid Email-Id...",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
   }
}
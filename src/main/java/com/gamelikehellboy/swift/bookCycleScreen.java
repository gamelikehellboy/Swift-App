package com.gamelikehellboy.swift;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class bookCycleScreen extends AppCompatActivity {
    private EditText zip;
    private EditText time;
    private CheckBox checkBox;
    private Button buttonC;
    private EditText phone;
//    private String filename = "appdata.txt";
//    private String filepath = "Internal storage\\Android\\data";
    Intent intent = getIntent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);
        buttonC = findViewById(R.id.button5);
        zip = findViewById(R.id.editTextNumber);
        time = findViewById(R.id.editTextTime);
        checkBox = findViewById(R.id.checkBox);
        phone = findViewById(R.id.editTextPhone);
    }
    public void onBookClick(View view)
    {
        if((zip.getText().toString().isEmpty())||(time.getText().toString().isEmpty())){
            Snackbar.make(buttonC,"The above spaces cannot be empty!",Snackbar.LENGTH_SHORT).show();
        }
        else{
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    if(checkBox.isChecked())
                        Snackbar.make(buttonC, "Thank you for booking a Cycle from us!", 3000).show();
                    else
                        Snackbar.make(buttonC,"Please accept the TOS by clicking on the check box, Thank You!",2000);


                          String data = phone.getText().toString()+","+time.getText().toString();
                          writeToFile("appdata.txt",data);

//                        try {
//                            FileOutputStream fout = new FileOutputStream(appData);
//                            String data = phone.getText().toString()+","+time.getText().toString();
//                            fout.write(data.getBytes());
    //                        fout.close();
//                            appData = new File(getExternalFilesDir(filepath), filename);
//                            Snackbar.make(buttonC,"Your cycle has been booked! Thank you.",2000).show();
//                        } catch (IOException e) {
//                            throw new RuntimeException(e);
//                        }



                }

            });
        }
    }
    public void writeToFile(String filename, String filedata){
        try {
                        Snackbar.make(buttonC,"Your cycle has been booked! Thank you.",2000).show();
//                        File path = getApplicationContext().getFilesDir();
                        String path = "/storage/emulated/0/Documents/";
                        System.out.println(path);
                        FileOutputStream fout = new FileOutputStream(new File(path,filename));
                        String data = phone.getText().toString()+","+time.getText().toString();
                        fout.write(filedata.getBytes());
                        fout.close();

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
    }
    private static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    private static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }
}
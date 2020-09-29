package com.example.projectattitudegratitude;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import android.content.Intent;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void todaysQuote(View view) {
        startActivity(new Intent(MainActivity.this, MainActivity2.class));
    }

    public void todaysGrat(View view) {
        startActivity(new Intent(MainActivity.this, MainActivity3.class));
    }

    public void todaysAff(View view) {
        startActivity(new Intent(MainActivity.this, MainActivity4.class));
    }

    public void todaysJournal(View view) {
        startActivity(new Intent(MainActivity.this, MainActivity5.class));
    }

    public void pastLog(View view) {
    }
}
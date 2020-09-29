package com.example.projectattitudegratitude;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import java.lang.Math;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {
    TextView quoteText;
    Button quoteButton;
    //read in a file of quotes, one quote per line, save each quote to an array
    String q1 = "Don't worry, be happy!";
    String q2 = "Every little thing is going to be alright!";
    String q3 = "Appreciate the little things";
    String [] quotes = new String[] {q1, q2, q3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        quoteText = (TextView) findViewById(R.id.textView2);
        quoteButton = (Button) findViewById(R.id.button6);

        quoteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click- chooses random index of array for quote
                int n = (int)(Math.random() * quotes.length-1);
                quoteText.setText(quotes[n]);

            }
        });
    }


}
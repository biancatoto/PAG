package com.example.projectattitudegratitude;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.*;

public class MainActivity3 extends AppCompatActivity {
    String item1, item2, item3;
    String dailyGrat;
    EditText firstItemInput;
    EditText secondItemInput;
    EditText thirdItemInput;
    Toast toast;
    Button submitGrat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        firstItemInput = (EditText) findViewById(R.id.firstItemInput);
        secondItemInput = (EditText) findViewById(R.id.secondItemInput);
        thirdItemInput = (EditText) findViewById(R.id.thirdItemInput);
        submitGrat = (Button)findViewById(R.id.submitGrat);
        submitGrat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                item1 = firstItemInput.getText().toString();
                item2 = secondItemInput.getText().toString();
                item3 = thirdItemInput.getText().toString();
                dailyGrat = "Today's Gratitude: " + item1 + ", " + item2 + ", " + item3;
                save(v);
            }
        });



    }

    public void save(View v) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.US);
        Date now = new Date();
        String fileName = formatter.format(now) + ".txt";
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(fileName, MODE_PRIVATE);
            fos.write(dailyGrat.getBytes());

            firstItemInput.getText().clear();
            secondItemInput.getText().clear();
            thirdItemInput.getText().clear();
            toast.makeText(this, "Saved to " + getFilesDir() + "/" + fileName, LENGTH_LONG).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
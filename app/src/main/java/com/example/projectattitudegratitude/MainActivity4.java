package com.example.projectattitudegratitude;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

public class MainActivity4 extends AppCompatActivity {

        String it1, it2, it3;
        String dailyAff;
        EditText firstItemIn;
        EditText secondItemIn;
        EditText thirdItemIn;
        Toast toast;
        Button submitAff;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main4);

            firstItemIn = (EditText) findViewById(R.id.firstItemIn);
            secondItemIn = (EditText) findViewById(R.id.secondItemIn);
            thirdItemIn = (EditText) findViewById(R.id.thirdItemIn);
            submitAff = (Button)findViewById(R.id.submitAff);
            submitAff.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    it1 = firstItemIn.getText().toString();
                    it2 = secondItemIn.getText().toString();
                    it3 = thirdItemIn.getText().toString();
                    dailyAff = "Today's Affirmations: " + it1 + ", " + it2 + ", " + it3;
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
                fos.write(dailyAff.getBytes());

                firstItemIn.getText().clear();
                secondItemIn.getText().clear();
                thirdItemIn.getText().clear();
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
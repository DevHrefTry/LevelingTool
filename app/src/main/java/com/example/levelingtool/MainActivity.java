package com.example.levelingtool;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textViewResult, textViewResults;
    EditText editTextFloor, editTextMeasured;
    double floor, measured, result;
    private static final DecimalFormat df = new DecimalFormat("0.00");
    String resultS, resultsS;
    int counter=0;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // using toolbar as ActionBar
        super.setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        textViewResult = (TextView)findViewById(R.id.textViewResult);
        textViewResults = (TextView)findViewById(R.id.textViewResults);
        editTextFloor = (EditText)findViewById(R.id.editTextFloor);
        editTextMeasured = (EditText)findViewById(R.id.editTextMeasured);
        button = (Button)findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                floor = Double.parseDouble(editTextFloor.getText().toString());
                measured = Double.parseDouble(editTextMeasured.getText().toString());
                result = floor - measured;
                resultS = df.format(result);
                textViewResult.setText(resultS);
                resultsS = textViewResults.getText().toString();
                resultsS += "\n"+counter+" point: "+resultS;
                textViewResults.setText(resultsS);
            }
        });
    }
}
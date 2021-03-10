package com.example.task_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button gpaButton,cgpaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gpaButton = (Button) findViewById(R.id.gpaCalButtonId);
        cgpaButton = (Button) findViewById(R.id.cgpaCalButtonId);

        gpaButton.setOnClickListener(this);
        cgpaButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.gpaCalButtonId){
            Intent intent = new Intent(getApplicationContext(),GPA_Calculator.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(getApplicationContext(),CGPA_Calculator.class);
            startActivity(intent);
        }
    }
}

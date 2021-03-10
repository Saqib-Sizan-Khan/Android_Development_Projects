package com.example.task_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CGPA_Calculator extends AppCompatActivity {
    private EditText totalSemEditText,semGpaEditText;
    private Button startCalButton,calButton;
    private TextView calSemText,remainSemText,avgText;

    int totalSemester,c,r;
    double semGpa,sum=0,avg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cgpa_calculator);

        linkUp();

        startCalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCal();
            }
        });

        calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal();
            }
        });
    }

    private void linkUp(){
        totalSemEditText = (EditText) findViewById(R.id.totalSemEditTextId);
        semGpaEditText = (EditText) findViewById(R.id.semGpaEditTextId);


        startCalButton = (Button) findViewById(R.id.scButtonId);
        calButton = (Button) findViewById(R.id.cButtonId);

        calSemText = (TextView) findViewById(R.id.calSemTextId);
        remainSemText = (TextView) findViewById(R.id.remainSemTextId);
        avgText = (TextView) findViewById(R.id.avgTextId);
    }

    public void startCal (){

        semGpaEditText.setText("");
        calSemText.setText("");
        remainSemText.setText("");
        avgText.setText("");

        String ts = totalSemEditText.getText().toString();


        if (ts.equals("")){

            Toast.makeText(getApplicationContext(),"Invalid input. Calcution doesn\'t start",Toast.LENGTH_SHORT).show();
        }

        else {
            totalSemester = Integer.parseInt(ts);

            if (totalSemester <= 0){

                Toast.makeText(getApplicationContext(),"Invalid input. Calcution doesn\'t start",Toast.LENGTH_SHORT).show();
            }

            else {
                c = 0;
                r = totalSemester;

                calSemText.setText("Calculated Semester: "+c);
                remainSemText.setText("Remaining Semester: "+r);

                semGpaEditText.setEnabled(true);
                calButton.setEnabled(true);
            }
        }
    }

    public void cal(){
        String sg = semGpaEditText.getText().toString();

        if (sg.equals("")){

            Toast.makeText(getApplicationContext(),"Invalid input. Can\'t calculate",Toast.LENGTH_SHORT).show();
        }

        else {
            semGpa = Double.parseDouble(sg);

            if(semGpa == 0){
                c--;
                r++;
            }

            sum += semGpa;

            c++;
            r--;

            calSemText.setText("Calculated Semester: "+c);
            remainSemText.setText("Remaining Semester: "+r);

            if(r==0){
                double avg = sum/totalSemester;
                avgText.setText("GPA: "+String.format("%.2f",avg));

                semGpaEditText.setEnabled(false);
                calButton.setEnabled(false);
            }
        }
    }
}

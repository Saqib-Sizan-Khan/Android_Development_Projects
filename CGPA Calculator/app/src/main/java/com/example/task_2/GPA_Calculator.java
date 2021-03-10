package com.example.task_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GPA_Calculator extends AppCompatActivity {
     private EditText subjectEditText, hGpaEditText, lGpaEditText, subGpaEditText, creditEditText;
     private Button startCalButton,calButton;
     private TextView addSubText,remainSubText, resultText,totalCreditText,earnCreditText;

     int totalsubject,c,r;
     double highestGpa,lowestGpa,gpa,credit,sum=0,sumCredit=0, earnCredit =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gpa_calculator);

        linkUp();

        startCalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCalculation();
            }
        });

        calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation();
            }
        });

    }

    private void linkUp(){
        subjectEditText = (EditText) findViewById(R.id.subjectEditTextId);
        hGpaEditText = (EditText) findViewById(R.id.hGpaEditTextId);
        lGpaEditText = (EditText) findViewById(R.id.lGpaEditTextId);
        subGpaEditText = (EditText) findViewById(R.id.subGpaEditTextId);
        creditEditText = (EditText) findViewById(R.id.creditEditTextId);

        startCalButton = (Button) findViewById(R.id.startCalButtonId);
        calButton = (Button) findViewById(R.id.calButtonId);

        addSubText = (TextView) findViewById(R.id.addedSubTextId);
        remainSubText = (TextView) findViewById(R.id.remainSubTextId);
        resultText = (TextView) findViewById(R.id.resultTextId);
        totalCreditText = (TextView) findViewById(R.id.totalCreditTextId);
        earnCreditText = (TextView) findViewById(R.id.earnCreditTextId);
    }

    public void startCalculation (){

        subGpaEditText.setText("");
        creditEditText.setText("");
        addSubText.setText("");
        remainSubText.setText("");
        resultText.setText("");

        String ts = subjectEditText.getText().toString();
        String hg = hGpaEditText.getText().toString();
        String lg = lGpaEditText.getText().toString();

        if (ts.equals("") || hg.equals("") || lg.equals("")){

            Toast.makeText(getApplicationContext(),"Invalid input. Calcution doesn\'t start",Toast.LENGTH_SHORT).show();
        }

        else {
            totalsubject = Integer.parseInt(ts);
            highestGpa = Double.parseDouble(hg);
            lowestGpa = Double.parseDouble(lg);

            if (totalsubject <= 0 || highestGpa <= 0 || lowestGpa < 0){

                Toast.makeText(getApplicationContext(),"Invalid input. Calcution doesn\'t start",Toast.LENGTH_SHORT).show();
            }

            else {
                c = 0;
                r = totalsubject;

                addSubText.setText("Calculated Subjects: "+c);
                remainSubText.setText("Remaining Subjecst: "+r);

                subGpaEditText.setEnabled(true);
                creditEditText.setEnabled(true);
                calButton.setEnabled(true);
            }
        }
    }

    public void calculation(){
        String g = subGpaEditText.getText().toString();
        String cr = creditEditText.getText().toString();

        if (g.equals("") || cr.equals("")){

            Toast.makeText(getApplicationContext(),"Invalid input. Can\'t calculate",Toast.LENGTH_SHORT).show();
        }

        else {
            gpa = Double.parseDouble(g);
            credit = Double.parseDouble(cr);

            if (gpa > highestGpa || credit <= 0){

                Toast.makeText(getApplicationContext(),"Invalid input. Can\'t calculate",Toast.LENGTH_SHORT).show();
            }

            if (gpa < lowestGpa){
                Toast.makeText(getApplicationContext(),"This course GPA added as 0.00",Toast.LENGTH_SHORT).show();

                sumCredit += credit;
                c++;
                r--;

                addSubText.setText("Calculated Subjects: "+c);
                remainSubText.setText("Remaining Subjects: "+r);
            }

            else {
                sum = sum + (gpa*credit);
                sumCredit += credit;
                earnCredit += credit;

                c++;
                r--;

                addSubText.setText("Calculated Subjects: "+c);
                remainSubText.setText("Remaining Subjects: "+r);
            }

            if(r==0){
                if (sumCredit == 0.00){
                    resultText.setText("GPA: 0.00");
                }
                else {
                    double result = sum/earnCredit;
                    resultText.setText("GPA: "+String.format("%.2f",result));
                    totalCreditText.setText("Total Attempted Credit: "+String.format("%.2f",sumCredit));
                    earnCreditText.setText("Total Eraned Credit: "+String.format("%.2f", earnCredit));
                }

                subGpaEditText.setEnabled(false);
                creditEditText.setEnabled(false);
                calButton.setEnabled(false);
            }
        }
    }
}

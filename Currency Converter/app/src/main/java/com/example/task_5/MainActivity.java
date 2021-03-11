package com.example.task_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    String[] currency;
    private Spinner inputSpinner,convertSpinner;
    private Button showButton;
    private EditText inputCurrency;
    private TextView convertCurrency;

    String inputType,convertType;
    boolean isFirstSelected1 = true;
    boolean isFirstSelected2 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currency = getResources().getStringArray(R.array.currency_names);

        inputSpinner = (Spinner) findViewById(R.id.inputSpinnerId);
        convertSpinner = (Spinner) findViewById(R.id.convertSpinnerId);
        showButton = (Button) findViewById(R.id.showButtonId);
        inputCurrency = (EditText) findViewById(R.id.inputEditTextId);
        convertCurrency = (TextView) findViewById(R.id.convertTextViewId);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.item_layout,R.id.textsampleId,currency);
        inputSpinner.setAdapter(adapter);
        convertSpinner.setAdapter(adapter);

        inputSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (isFirstSelected1) {
                    isFirstSelected1 = false;
                } else {
                    Toast.makeText(getApplicationContext(),currency[position]+" is selected for input currency",Toast.LENGTH_SHORT).show();
                }
                inputCurrency.setText("");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        convertSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (isFirstSelected2) {
                    isFirstSelected2 = false;
                } else {
                    Toast.makeText(getApplicationContext(),currency[position]+" is selected for convertion",Toast.LENGTH_SHORT).show();
                }
                convertCurrency.setText("");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inputType = inputSpinner.getSelectedItem().toString();
                convertType = convertSpinner.getSelectedItem().toString();

                if (inputType.equals("Bangladeshi Taka") && convertType.equals("United States Dollar")) {
                    converter(85,false);

                }
                else if (inputType.equals("United States Dollar") && convertType.equals("Bangladeshi Taka")) {
                    converter(85,true);

                }

                else if (inputType.equals("Bangladeshi Taka") && convertType.equals("Kuwaiti Dinar")) {
                    converter(279,false);

                }
                else if (inputType.equals("Kuwaiti Dinar") && convertType.equals("Bangladeshi Taka")) {
                    converter(279,true);
                }

                else if (inputType.equals("Bangladeshi Taka") && convertType.equals("Euro")) {
                    converter(103,false);

                }
                else if (inputType.equals("Euro") && convertType.equals("Bangladeshi Taka")) {
                    converter(103,true);
                }

                else if (inputType.equals("Bangladeshi Taka") && convertType.equals("Japanese Yen")) {
                    converter(0.82,false);

                }
                else if (inputType.equals("Japanese Yen") && convertType.equals("Bangladeshi Taka")) {
                    converter(0.82,true);
                }

                else if (inputType.equals("United States Dollar") && convertType.equals("Kuwaiti Dinar")) {
                    converter(3.29,false);

                }
                else if (inputType.equals("Kuwaiti Dinar") && convertType.equals("United States Dollar")) {
                    converter(3.29,true);
                }

                else if (inputType.equals("United States Dollar") && convertType.equals("Euro")) {
                    converter(1.21,false);

                }
                else if (inputType.equals("Euro") && convertType.equals("United States Dollar")) {
                    converter(1.21,true);
                }

                else if (inputType.equals("United States Dollar") && convertType.equals("Japanese Yen")) {
                    converter(103,true);

                }
                else if (inputType.equals("Japanese Yen") && convertType.equals("United States Dollar")) {
                    converter(103,false);
                }

                else if (inputType.equals("Kuwaiti Dinar") && convertType.equals("Euro")) {
                    converter(2.71,true);

                }
                else if (inputType.equals("Euro") && convertType.equals("Kuwaiti Dinar")) {
                    converter(2.71,false);
                }

                else if (inputType.equals("Kuwaiti Dinar") && convertType.equals("Japanese Yen")) {
                    converter(339,true);
                }
                else if (inputType.equals("Japanese Yen") && convertType.equals("Kuwaiti Dinar")) {
                    converter(339,false);
                }

                else if (inputType.equals("Euro") && convertType.equals("Japanese Yen")) {
                    converter(125,true);
                }
                else if (inputType.equals("Japanese Yen") && convertType.equals("Euro")) {
                    converter(125,false);
                }

                else {
                    convertCurrency.setText(inputCurrency.getText().toString());
                }

            }
        });
    }

    public void converter (double c,boolean op) {

        if (op) {
            double ic = Double.parseDouble(inputCurrency.getText().toString());
            double result = ic * c;
            convertCurrency.setText(new DecimalFormat("##.##").format(result));
        }
        else {
            double ic = Double.parseDouble(inputCurrency.getText().toString());
            double result = ic / c;
            convertCurrency.setText(new DecimalFormat("##.##").format(result));
        }
    }
}
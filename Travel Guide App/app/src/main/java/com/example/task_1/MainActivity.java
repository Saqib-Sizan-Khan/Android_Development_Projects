package com.example.task_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private GridView divisionGridView;
    private String[] divisionName;
    private int[] divisionImage = {R.drawable.dhaka_division,R.drawable.chittagong_division,R.drawable.rajshahi_division,
                                    R.drawable.khulna_division, R.drawable.barishal_division,R.drawable.rangpur_division,
                                    R.drawable.mymensingh_division,R.drawable.sylhet_division};
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.marqueeTextId);
        textView.setSelected(true);

        divisionName = getResources().getStringArray(R.array.divisions);

        divisionGridView = (GridView) findViewById(R.id.divisionGridViewId);
        DivisionAdapter adapter = new DivisionAdapter(divisionImage, divisionName, this);
        divisionGridView.setAdapter(adapter);

        divisionGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(getApplicationContext(), Dhaka_Activity.class);
                    startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(getApplicationContext(), Chittagong_Activity.class);
                    startActivity(intent);
                } else if (position == 2) {
                    Intent intent = new Intent(getApplicationContext(), Rajshahi_Activity.class);
                    startActivity(intent);
                } else if (position == 3) {
                    Intent intent = new Intent(getApplicationContext(), Khulna_Activity.class);
                    startActivity(intent);
                } else if (position == 4) {
                    Intent intent = new Intent(getApplicationContext(), Barishal_Activity.class);
                    startActivity(intent);
                } else if (position == 5) {
                    Intent intent = new Intent(getApplicationContext(), Rangpur_Activity.class);
                    startActivity(intent);
                } else if (position == 6) {
                    Intent intent = new Intent(getApplicationContext(), Mymensingh_Activity.class);
                    startActivity(intent);
                } else if (position == 7) {
                    Intent intent = new Intent(getApplicationContext(), Sylhet_Activity.class);
                    startActivity(intent);
                }
            }
        });
    }
}

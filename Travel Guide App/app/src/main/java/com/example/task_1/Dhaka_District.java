package com.example.task_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class Dhaka_District extends AppCompatActivity {
    private ListView tourSpotListView;
    private String[] tourSpotName;
    private String[] tourSpotDescription;
    private int[] tourSpotImage = {R.drawable.national_martyrs_memorial,R.drawable.lalbagh_fort};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhaka__district);

        tourSpotName = getResources().getStringArray(R.array.dhakaTourSpot_name);
        tourSpotDescription = getResources().getStringArray(R.array.dhakaTourSpot_description);

        tourSpotListView = (ListView) findViewById(R.id.dhakaDisListViewId);
        TourSpot_Adapter adapter = new TourSpot_Adapter(tourSpotImage, tourSpotName,tourSpotDescription,this);
        tourSpotListView.setAdapter(adapter);
    }
}

package com.example.task_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class Tangail_District extends AppCompatActivity {
    private ListView tourSpotListView;
    private String[] tourSpotName;
    private String[] tourSpotDescription;
    private int[] tourSpotImage = {R.drawable.jamuna_bridge,R.drawable.madhupur_garh};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tangail__district);

        tourSpotName = getResources().getStringArray(R.array.tangailTourSpot_name);
        tourSpotDescription = getResources().getStringArray(R.array.tangailTourSpot_description);

        tourSpotListView = (ListView) findViewById(R.id.tangailDisListViewId);
        TourSpot_Adapter adapter = new TourSpot_Adapter(tourSpotImage, tourSpotName,tourSpotDescription,this);
        tourSpotListView.setAdapter(adapter);
    }
}

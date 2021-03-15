package com.example.task_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class Narsingdi_District extends AppCompatActivity {
    private ListView tourSpotListView;
    private String[] tourSpotName;
    private String[] tourSpotDescription;
    private int[] tourSpotImage = {R.drawable.wari_bateshwar};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_narsingdi__district);

        tourSpotName = getResources().getStringArray(R.array.narsingdiTourSpot_name);
        tourSpotDescription = getResources().getStringArray(R.array.narsingdiTourSpot_description);

        tourSpotListView = (ListView) findViewById(R.id.narsingdiDisListViewId);
        TourSpot_Adapter adapter = new TourSpot_Adapter(tourSpotImage, tourSpotName,tourSpotDescription,this);
        tourSpotListView.setAdapter(adapter);
    }
}

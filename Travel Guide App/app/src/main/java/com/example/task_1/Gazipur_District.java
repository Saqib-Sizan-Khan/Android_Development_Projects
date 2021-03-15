package com.example.task_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class Gazipur_District extends AppCompatActivity {
    private ListView tourSpotListView;
    private String[] tourSpotName;
    private String[] tourSpotDescription;
    private int[] tourSpotImage = {R.drawable.bangabandhu_sheikh_mujib_safari_park};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gazipur__district);

        tourSpotName = getResources().getStringArray(R.array.gazipurTourSpot_name);
        tourSpotDescription = getResources().getStringArray(R.array.gazipurTourSpot_description);

        tourSpotListView = (ListView) findViewById(R.id.gazipurDisListViewId);
        TourSpot_Adapter adapter = new TourSpot_Adapter(tourSpotImage, tourSpotName,tourSpotDescription,this);
        tourSpotListView.setAdapter(adapter);
    }
}

package com.example.task_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class Dinajpur_District extends AppCompatActivity {
    private ListView tourSpotListView;
    private String[] tourSpotName;
    private String[] tourSpotDescription;
    private int[] tourSpotImage = {R.drawable.kantaji_temple,R.drawable.sitakot_vihara,R.drawable.shopnopuri};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinajpur__district);

        tourSpotName = getResources().getStringArray(R.array.dinajpurTourSpot_name);
        tourSpotDescription = getResources().getStringArray(R.array.dinajpurTourSpot_description);

        tourSpotListView = (ListView) findViewById(R.id.dinajpurDisListViewId);
        TourSpot_Adapter adapter = new TourSpot_Adapter(tourSpotImage, tourSpotName,tourSpotDescription,this);
        tourSpotListView.setAdapter(adapter);
    }
}

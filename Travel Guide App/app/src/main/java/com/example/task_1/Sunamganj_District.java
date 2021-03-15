package com.example.task_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class Sunamganj_District extends AppCompatActivity {
    private ListView tourSpotListView;
    private String[] tourSpotName;
    private String[] tourSpotDescription;
    private int[] tourSpotImage = {R.drawable.tanguar_haor,R.drawable.chhatak};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sunamganj__district);

        tourSpotName = getResources().getStringArray(R.array.sunamganjTourSpot_name);
        tourSpotDescription = getResources().getStringArray(R.array.sunamganjTourSpot_description);

        tourSpotListView = (ListView) findViewById(R.id.sunamganjDisListViewId);
        TourSpot_Adapter adapter = new TourSpot_Adapter(tourSpotImage, tourSpotName,tourSpotDescription,this);
        tourSpotListView.setAdapter(adapter);
    }
}

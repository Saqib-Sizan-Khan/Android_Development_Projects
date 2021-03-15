package com.example.task_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class Moulvibazar_District extends AppCompatActivity {
    private ListView tourSpotListView;
    private String[] tourSpotName;
    private String[] tourSpotDescription;
    private int[] tourSpotImage = {R.drawable.srimangal,R.drawable.madhabkunda_waterfall,R.drawable.lawachara,R.drawable.baikka_beel};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moulvibazar__district);

        tourSpotName = getResources().getStringArray(R.array.moulvibazarTourSpot_name);
        tourSpotDescription = getResources().getStringArray(R.array.moulvibazarTourSpot_description);

        tourSpotListView = (ListView) findViewById(R.id.moulvibazarDisListViewId);
        TourSpot_Adapter adapter = new TourSpot_Adapter(tourSpotImage, tourSpotName,tourSpotDescription,this);
        tourSpotListView.setAdapter(adapter);
    }
}

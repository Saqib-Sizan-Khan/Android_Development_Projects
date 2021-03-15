package com.example.task_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Khulna_Activity extends AppCompatActivity {
    private ListView khulnaListView;
    private String[] khulnaDistrictName;
    private int[] khulnaDisImage = {R.drawable.bagerhatdis,R.drawable.chuadangadis,R.drawable.jessoredis,R.drawable.jhenaidhadis,
            R.drawable.khulnadis,R.drawable.kushtiadis,R.drawable.maguradis,R.drawable.meherpurdis,
            R.drawable.naraildis,R.drawable.satkhiradis};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khulna_);

        khulnaDistrictName = getResources().getStringArray(R.array.khulna_division);

        khulnaListView = (ListView) findViewById(R.id.khulnaListViewId);
        DistrictAdapter adapter = new DistrictAdapter(khulnaDisImage, khulnaDistrictName,this);
        khulnaListView.setAdapter(adapter);

        khulnaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = khulnaDistrictName[position];
                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
            }
        });
    }
}

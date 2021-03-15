package com.example.task_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Chittagong_Activity extends AppCompatActivity {
    private ListView chittagongListView;
    private String[] chittagongDistrictName;
    private int[] chittagongDisImage = {R.drawable.bandarbandis,R.drawable.brahmanbariadis,R.drawable.chadpurdis,R.drawable.chittagongdis,
                                        R.drawable.comilladis,R.drawable.coxsbazardis,R.drawable.fenidis,R.drawable.khagrachharidis,
                                        R.drawable.lakshmipurdis,R.drawable.noakhalidis,R.drawable.rangamatidis};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chittagong_);

        chittagongDistrictName = getResources().getStringArray(R.array.chittagong_division);

        chittagongListView = (ListView) findViewById(R.id.chittagongListViewId);
        DistrictAdapter adapter = new DistrictAdapter(chittagongDisImage, chittagongDistrictName,this);
        chittagongListView.setAdapter(adapter);

        chittagongListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = chittagongDistrictName[position];
                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
            }
        });
    }
}

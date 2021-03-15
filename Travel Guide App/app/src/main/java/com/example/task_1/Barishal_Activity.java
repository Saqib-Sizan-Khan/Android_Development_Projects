package com.example.task_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Barishal_Activity extends AppCompatActivity {
    private ListView barishalListView;
    private String[] barishalDistrictName;
    private int[] barishalDisImage = {R.drawable.bargunadis,R.drawable.barisaldis,R.drawable.bholadis,
                                        R.drawable.jhalakatidis,R.drawable.patuakhalidis,R.drawable.pirojpurdis};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barishal_);

        barishalDistrictName = getResources().getStringArray(R.array.barishal_division);

        barishalListView = (ListView) findViewById(R.id.barishalListViewId);
        DistrictAdapter adapter = new DistrictAdapter(barishalDisImage, barishalDistrictName,this);
        barishalListView.setAdapter(adapter);

        barishalListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = barishalDistrictName[position];
                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
            }
        });
    }
}

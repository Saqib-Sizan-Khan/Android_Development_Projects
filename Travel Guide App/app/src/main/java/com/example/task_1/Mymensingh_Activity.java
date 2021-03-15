package com.example.task_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Mymensingh_Activity extends AppCompatActivity {
    private ListView mymensinghListView;
    private String[] mymensinghDistrictName;
    private int[] mymensinghDisImage = {R.drawable.jamalpurdis,R.drawable.mymensinghdis,
            R.drawable.netrokonadis,R.drawable.sherpurdis};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mymensingh_);

        mymensinghDistrictName = getResources().getStringArray(R.array.mymensingh_division);

        mymensinghListView = (ListView) findViewById(R.id.mymensinghListViewId);
        DistrictAdapter adapter = new DistrictAdapter(mymensinghDisImage, mymensinghDistrictName,this);
        mymensinghListView.setAdapter(adapter);

        mymensinghListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = mymensinghDistrictName[position];
                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
            }
        });
    }
}

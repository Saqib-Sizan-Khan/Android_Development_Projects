package com.example.task_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Sylhet_Activity extends AppCompatActivity {
    private ListView sylhetListView;
    private String[] sylhetDistrictName;
    private int[] sylhetDisImage = {R.drawable.sylhetdis,R.drawable.moulvibazardis,R.drawable.sunamganjdis,R.drawable.habiganjdis};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sylhet_);

        sylhetDistrictName = getResources().getStringArray(R.array.sylhet_division);

        sylhetListView = (ListView) findViewById(R.id.sylhetListViewId);
        DistrictAdapter adapter = new DistrictAdapter(sylhetDisImage, sylhetDistrictName,this);
        sylhetListView.setAdapter(adapter);

        sylhetListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Intent intent = new Intent(getApplicationContext(),Sylhet_District.class);
                    startActivity(intent);
                }
                else if (position == 1){
                    Intent intent = new Intent(getApplicationContext(),Moulvibazar_District.class);
                    startActivity(intent);
                }
                else if (position == 2){
                    Intent intent = new Intent(getApplicationContext(),Sunamganj_District.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"No such travel spot",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

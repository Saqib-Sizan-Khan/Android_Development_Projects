package com.example.task_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Rangpur_Activity extends AppCompatActivity {
    private ListView rangpurListView;
    private String[] rangpurDistrictName;
    private int[] rangpurDisImage = {R.drawable.dinajpurdis,R.drawable.gaibandhadis,R.drawable.kurigramdis,R.drawable.lalmonirhatdis,
                                    R.drawable.nilphamaridis,R.drawable.panchagarhdis,R.drawable.rangpurdis,R.drawable.thakurgaondis};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rangpur_);

        rangpurDistrictName = getResources().getStringArray(R.array.rangpur_division);

        rangpurListView = (ListView) findViewById(R.id.rangpurListViewId);
        DistrictAdapter adapter = new DistrictAdapter(rangpurDisImage, rangpurDistrictName,this);
        rangpurListView.setAdapter(adapter);

        rangpurListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Intent intent = new Intent(getApplicationContext(), Dinajpur_District.class);
                    startActivity(intent);
                }
                else if (position == 4){
                    Intent intent = new Intent(getApplicationContext(), Nilphamari_District.class);
                    startActivity(intent);
                }
                else if (position == 6){
                    Intent intent = new Intent(getApplicationContext(), Rangpur_District.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"No such travel spot",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

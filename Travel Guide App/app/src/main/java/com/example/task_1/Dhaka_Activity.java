package com.example.task_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Dhaka_Activity extends AppCompatActivity {
    private ListView dhakaListView;
    private String[] dhakaDistrictName;
    private int[] dhakaDisImage = {R.drawable.dhakadis,R.drawable.faridpurdis,R.drawable.gazipurdis,R.drawable.gopalganjdis,
            R.drawable.kishoreganjdis,R.drawable.madaripurdis,R.drawable.manikganjdis,R.drawable.munshiganjdis,
            R.drawable.narayanganjdis,R.drawable.narsingdidis,R.drawable.rajbaridis,R.drawable.shariatpurdis,
            R.drawable.tangaildis};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhaka_);

        dhakaDistrictName = getResources().getStringArray(R.array.dhaka_division);

        dhakaListView = (ListView) findViewById(R.id.dhakaListViewId);
        DistrictAdapter adapter = new DistrictAdapter(dhakaDisImage, dhakaDistrictName,this);
        dhakaListView.setAdapter(adapter);

        dhakaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Intent intent = new Intent(getApplicationContext(), Dhaka_District.class);
                    startActivity(intent);
                }
                else if (position == 2){
                    Intent intent = new Intent(getApplicationContext(), Gazipur_District.class);
                    startActivity(intent);
                }
                else if (position == 3){
                    Intent intent = new Intent(getApplicationContext(), Gopalganj_District.class);
                    startActivity(intent);
                }
                else if (position == 6){
                    Intent intent = new Intent(getApplicationContext(), Manikganj_District.class);
                    startActivity(intent);
                }
                else if (position == 7){
                    Intent intent = new Intent(getApplicationContext(), Munshiganj_District.class);
                    startActivity(intent);
                }
                else if (position == 8){
                    Intent intent = new Intent(getApplicationContext(), Narayanganj_District.class);
                    startActivity(intent);
                }
                else if (position == 9){
                    Intent intent = new Intent(getApplicationContext(), Narsingdi_District.class);
                    startActivity(intent);
                }
                else if (position == 10){
                    Intent intent = new Intent(getApplicationContext(), Rajbari_District.class);
                    startActivity(intent);
                }
                else if (position == 12){
                    Intent intent = new Intent(getApplicationContext(), Tangail_District.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"No such travel spot",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

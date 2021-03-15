package com.example.task_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Rajshahi_Activity extends AppCompatActivity {
    private ListView rajshahiListView;
    private String[] rajshahiDistrictName;
    private int[] rajshahiDisImage = {R.drawable.boguradis,R.drawable.chapainawabganjdis,R.drawable.joypurhatdis,R.drawable.naogaondis,
            R.drawable.natoredis,R.drawable.pabnadis,R.drawable.rajshahidis,R.drawable.sirajganjdis};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rajshahi_);

        rajshahiDistrictName = getResources().getStringArray(R.array.rajshahi_division);

        rajshahiListView = (ListView) findViewById(R.id.rajshahiListViewId);
        DistrictAdapter adapter = new DistrictAdapter(rajshahiDisImage, rajshahiDistrictName,this);
        rajshahiListView.setAdapter(adapter);

        rajshahiListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = rajshahiDistrictName[position];
                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
            }
        });
    }
}

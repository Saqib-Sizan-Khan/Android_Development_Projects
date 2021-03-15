package com.example.task_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TourSpot_Adapter extends BaseAdapter {
    int[] spotImage;
    String[] spotName;
    String[] spotDescription;
    Context context;
    private LayoutInflater inflater;

    public TourSpot_Adapter(int[] spotImage, String[] spotName,String[] spotDescription, Context context) {
        this.spotImage = spotImage;
        this.spotName = spotName;
        this.spotDescription = spotDescription;
        this.context = context;
    }

    @Override
    public int getCount() {
        return spotName.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.tour_spot_layout,parent,false);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.tourSpotImageId);
        TextView textView1 = (TextView) convertView.findViewById(R.id.tourSpotNameId);
        TextView textView2 = (TextView) convertView.findViewById(R.id.tourSpotDesId);

        imageView.setImageResource(spotImage[position]);;
        textView1.setText(spotName[position]);
        textView2.setText(spotDescription[position]);

        return convertView;
    }
}

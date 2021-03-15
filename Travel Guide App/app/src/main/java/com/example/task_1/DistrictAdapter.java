package com.example.task_1;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DistrictAdapter extends BaseAdapter {
    int[] disImage;
    String[] districtName;
    Context context;
    private LayoutInflater inflater;

    public DistrictAdapter(int[] disImage, String[] districtName, Context context) {
        this.disImage = disImage;
        this.districtName = districtName;
        this.context = context;
    }

    @Override
    public int getCount() {
        return districtName.length;
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
            convertView = inflater.inflate(R.layout.listview_layout,parent,false);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.disImageId);
        TextView textView = (TextView) convertView.findViewById(R.id.districtNameId);

        imageView.setImageResource(disImage[position]);;
        textView.setText(districtName[position]);

        return convertView;
    }
}

package com.example.task_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DivisionAdapter extends BaseAdapter {
    int[] divisionImage;
    String[] divisionName;
    Context context;
    private LayoutInflater inflater;

    public DivisionAdapter(int[] divisionImage, String[] divisionName, Context context) {
        this.divisionImage = divisionImage;
        this.divisionName = divisionName;
        this.context = context;
    }

    @Override
    public int getCount() {
        return divisionName.length;
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
            convertView = inflater.inflate(R.layout.gridview_layout,parent,false);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.divisionImageId);
        TextView textView = (TextView) convertView.findViewById(R.id.divisionNameId);

        imageView.setImageResource(divisionImage[position]);;
        textView.setText(divisionName[position]);

        return convertView;
    }
}

package com.example.myhealthnutritiondiet;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class VAdapter extends BaseAdapter {

    Activity activity;
    List<Data> items;
    private LayoutInflater inflater;

    public VAdapter(Activity activity, List<Data> items) {

        this.activity = activity;
        this.items = items;

    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         if (inflater == null);
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

         if (convertView == null) convertView = inflater.inflate(R.layout.list,null);

        TextView date = (TextView) convertView.findViewById(R.id.date);
        TextView angiogenesis1 = (TextView) convertView.findViewById(R.id.angiogenesis1);
        TextView regeneration1 = (TextView) convertView.findViewById(R.id.regeneration1);
        TextView microbiome1 = (TextView) convertView.findViewById(R.id.microbiome1);
        TextView immunity1 = (TextView) convertView.findViewById(R.id.immunity1);
        TextView dna1 = (TextView) convertView.findViewById(R.id.dna1);

        Data data = items.get(position);

        date.setText(data.getDate());
        angiogenesis1.setText(data.getAngiogenesis1());
        regeneration1.setText(data.getRegeneration1());
        microbiome1.setText(data.getMicrobiome1());
        immunity1.setText(data.getImmunity1());
        dna1.setText(data.getDna1());

        return convertView;
    }
}

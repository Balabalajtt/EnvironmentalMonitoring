package com.ute.environmentalmonitoring.work.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ute.environmentalmonitoring.R;

import java.util.ArrayList;

/**
 * Created by 江婷婷 on 2018/5/13.
 */

public class PopAdapter extends BaseAdapter {
    private Context context;
    private ArrayList list;
    public PopAdapter (Context context,ArrayList list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        PopAdapter.ViewHolder vh;
        if (convertView == null) {
            vh = new PopAdapter.ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.location_item, null);
            vh.textview = convertView.findViewById(R.id.tv_location_item);
            convertView.setTag(vh);
        } else {
            vh = (PopAdapter.ViewHolder) convertView.getTag();
        }
        vh.textview.setText(list.get(position) + "");
        return convertView;
    }
    static class ViewHolder {
        TextView textview;
    }
}


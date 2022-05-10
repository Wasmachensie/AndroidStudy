package com.example.mylistview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private List<Bean> data;
    private Context context;

    public MyAdapter(List<Bean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
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
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context)
                .inflate(R.layout.list_item, viewGroup, false);
            holder.textView = convertView.findViewById(R.id.tv1);

            convertView.setTag(holder);

        } else {
            //
            holder = (ViewHolder) convertView.getTag();
        }
        //TextView textView = convertView.findViewById(R.id.tv1);优化
        holder.textView.setText(data.get(position).getName());

        Log.e("Arno", "getView: "+data.get(position).getName());
        return convertView;
    }

    private final class ViewHolder {
        TextView textView;
    }
}

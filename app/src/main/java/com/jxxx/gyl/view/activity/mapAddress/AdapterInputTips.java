package com.jxxx.gyl.view.activity.mapAddress;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.jxxx.gyl.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AdapterInputTips extends BaseAdapter {

    private List<HashMap<String,String>> addressData;
    private LayoutInflater layoutInflater;

    public AdapterInputTips(Context context) {
        layoutInflater=LayoutInflater.from(context);
        addressData=new ArrayList<HashMap<String, String>>() ;


    }

    @Override
    public int getCount() {
        return addressData.size();
    }
    @Override
    public Object getItem(int position) {
        return addressData.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if(convertView == null){
            vh = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.search_list_item, null);
            vh.title = (TextView) convertView.findViewById(R.id.tv_detailAddress);
            vh.text = (TextView) convertView.findViewById(R.id.tv_content);
            convertView.setTag(vh);
        }else{
            vh = (ViewHolder) convertView.getTag();
        }
        vh.title.setText(addressData.get(position).get("name"));
        vh.text.setText(addressData.get(position).get("address"));
        return convertView;
    }

    private class ViewHolder{
        public TextView title;
        public TextView text;
    }

}

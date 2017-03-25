package com.example.ku.bustrack;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ku on 25/3/2017.
 */

public class BusList extends ArrayAdapter <BusInfo> {
    private Activity context;
    private List<BusInfo> busList;

    public BusList(Activity context, List<BusInfo>busList){
        super(context, R.layout.list_layout, busList);
        this.context = context;
        this.busList = busList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout,null, true);

        TextView textViewBusType = (TextView) listViewItem.findViewById(R.id.textViewBusType);
        TextView textViewBusNo = (TextView) listViewItem.findViewById(R.id.textViewBusNo);
        TextView textViewBusCond = (TextView) listViewItem.findViewById(R.id.textViewBusCond);

        BusInfo busInfo = busList.get(position);

        textViewBusType.setText(busInfo.getBusType());
        textViewBusNo.setText(busInfo.getBusNo());
        textViewBusCond.setText(busInfo.getBusCond());

        return listViewItem;
    }
}

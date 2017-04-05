package com.example.ku.bustrack;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ku on 5/4/2017.
 */

public class ScheduleList extends ArrayAdapter <BusSchedule> {
    private Activity context;
    private List<BusSchedule> scheduleList;

    public ScheduleList(Activity context, List<BusSchedule>scheduleList){
        super(context, R.layout.schedule_list, scheduleList);
        this.context = context;
        this.scheduleList = scheduleList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.schedule_list,null, true);

        TextView textViewSchedule = (TextView) listViewItem.findViewById(R.id.textView_schedule);
        TextView textViewBus = (TextView) listViewItem.findViewById(R.id.textView_bus);
        TextView textViewTime = (TextView) listViewItem.findViewById(R.id.textView_time);

        BusSchedule busSchedule = scheduleList.get(position);
        textViewSchedule.setText(busSchedule.getBusSchedule());
        textViewBus.setText(busSchedule.getBusType());
        textViewTime.setText(busSchedule.getBusTime());

        return listViewItem;
    }
}

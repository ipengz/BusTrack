package com.example.ku.bustrack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ScheduleListActivity extends AppCompatActivity {

    ListView listViewSchedule;
    DatabaseReference databaseSchedule;
    List<BusSchedule> scheduleList;
    ScheduleList adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_list);

        scheduleList = new ArrayList<>();
        listViewSchedule = (ListView) findViewById(R.id.listViewSchedule);
        databaseSchedule = FirebaseDatabase.getInstance().getReference("schedule");

        adapter = new ScheduleList(ScheduleListActivity.this,scheduleList);
        listViewSchedule.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseSchedule.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot busSnapshot: dataSnapshot.getChildren()){
                    //DataSnapshot { key = -KftmBTQrAV1ZlQwaC5R, value = {busCond=Operating, busID=-KftmBTQrAV1ZlQwaC5R, busNo=TPM0001, busType=Bus1} }
                    Log.d("fuck activity",busSnapshot.toString());
                    BusSchedule busSchedule = busSnapshot.getValue(BusSchedule.class);
                    Log.d("fuck activity",busSchedule.getBusTime());
                    scheduleList.add(busSchedule);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}

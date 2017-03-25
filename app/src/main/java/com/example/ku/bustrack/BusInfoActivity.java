package com.example.ku.bustrack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;



public class BusInfoActivity extends AppCompatActivity {

    ListView listViewBus;
    DatabaseReference databaseBus;

    List<BusInfo> busList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_info);

        busList = new ArrayList<>();

        listViewBus = (ListView) findViewById(R.id.listViewBus);
        databaseBus = FirebaseDatabase.getInstance().getReference("bus");
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseBus.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot busSnapshot: dataSnapshot.getChildren()){
                    busList.clear();
                    BusInfo businfo = busSnapshot.getValue(BusInfo.class);

                    busList.add(businfo);
                }
                BusList adapter = new BusList(BusInfoActivity.this, busList);
                listViewBus.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}

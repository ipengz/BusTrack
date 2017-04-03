package com.example.ku.bustrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BusScheduleActivity extends AppCompatActivity {

    DatabaseReference databaseSchedule;
    Spinner SpinnerSchedule;
    Spinner SpinnerBus;
    Spinner SpinnerTime;
    Button ButtonSchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_schedule);

        databaseSchedule = FirebaseDatabase.getInstance().getReference("schedule");

        SpinnerSchedule = (Spinner) findViewById(R.id.spinner_schedule);
        SpinnerBus = (Spinner) findViewById(R.id.spinner_bus);
        SpinnerTime = (Spinner) findViewById(R.id.spinner_time);
        ButtonSchedule = (Button) findViewById(R.id.button_schedule);

        ButtonSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scheduleBus();
            }
        });
    }
        private void scheduleBus(){
            String BusSchedule = SpinnerSchedule.getSelectedItem().toString();
            String BusType = SpinnerBus.getSelectedItem().toString();
            String BusTime = SpinnerTime.getSelectedItem().toString();

            String id = databaseSchedule.push().getKey();
            BusInfo bus = new BusInfo(id,BusSchedule,BusType,BusTime);
            databaseSchedule.child(id).setValue(bus);
            Toast.makeText(this,"Bus scheduled", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, MenuActivity.class));

    }
    }


package com.example.ku.bustrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AdminMenuActivity extends AppCompatActivity implements View.OnClickListener {

    Button updateInfo;
    Button updateSchedule;
    Button adminLogout;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

        updateInfo = (Button) findViewById(R.id.button_updateinfo);
        updateSchedule = (Button) findViewById(R.id.button_updateshedule);
        adminLogout = (Button) findViewById(R.id.button_adminLogout);

        updateInfo.setOnClickListener(this);
        updateSchedule.setOnClickListener(this);
        adminLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == updateInfo){
            startActivity(new Intent(this, UpdateBusActivity.class));
        }
        if(v == updateSchedule){
            startActivity(new Intent(this, BusScheduleActivity.class));
        }
        if(v == adminLogout){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, AdminLoginActivity.class));
        }
    }
}

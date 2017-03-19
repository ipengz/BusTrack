package com.example.ku.bustrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    Button locatebusbtn;
    Button businfobtn;
    Button busUpdatebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        locatebusbtn = (Button)(findViewById(R.id.btn_locatebus));
        locatebusbtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent locatebus = new Intent(getApplicationContext(),RequestLocationActivity.class);
                startActivity(locatebus);
                Log.e("Error","Error");

            }
        });
        businfobtn = (Button)(findViewById(R.id.btn_businfo));
        businfobtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent businfo = new Intent(getApplicationContext(),BusInfoActivity.class);
                startActivity(businfo);
                Log.e("Error", "Error");
            }
        });
        busUpdatebtn = (Button)(findViewById(R.id.btn_update));
        busUpdatebtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent busUpdate = new Intent(getApplicationContext(),UpdateBusActivity.class);
                startActivity(busUpdate);
                Log.e("Error","Error");
            }
        });


    }
}

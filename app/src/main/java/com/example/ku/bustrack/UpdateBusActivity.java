package com.example.ku.bustrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateBusActivity extends AppCompatActivity {

    EditText editTextBusPlate;
    Spinner SpinnerBusType;
    Spinner SpinnerOperation;
    Button buttonUpdate;

    DatabaseReference databaseBus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_bus);

        databaseBus = FirebaseDatabase.getInstance().getReference("bus");
        editTextBusPlate = (EditText)findViewById(R.id.editText_BusPlateNo);
        SpinnerBusType = (Spinner) findViewById(R.id.spinner_BusType);
        SpinnerOperation = (Spinner) findViewById(R.id.spinner_Operation);
        buttonUpdate = (Button) findViewById(R.id.button_Update);

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateBus();
                }
        });
    }
    private void updateBus(){
        String BusType = SpinnerBusType.getSelectedItem().toString();
        String BusNo = editTextBusPlate.getText().toString().trim();
        String BusCond = SpinnerOperation.getSelectedItem().toString();

        if(!TextUtils.isEmpty(BusNo)){

            String id = databaseBus.push().getKey();
            BusInfo bus = new BusInfo(id,BusType,BusNo,BusCond);
            databaseBus.child(id).setValue(bus);
            Toast.makeText(this,"Bus updated", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, AdminMenuActivity.class));

        }else{
            Toast.makeText(this, "Please enter bus plate no", Toast.LENGTH_LONG).show();
        }
    }
}

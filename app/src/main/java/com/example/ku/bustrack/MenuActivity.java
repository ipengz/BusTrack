package com.example.ku.bustrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    Button locatebusbtn;
    Button businfobtn;
    Button busUpdatebtn;
    Button logoutbtn;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

        locatebusbtn = (Button)(findViewById(R.id.btn_locatebus));
        businfobtn = (Button)(findViewById(R.id.btn_businfo));
        busUpdatebtn = (Button)(findViewById(R.id.btn_update));
        logoutbtn = (Button)(findViewById(R.id.btn_logout));

        locatebusbtn.setOnClickListener(this);
        businfobtn.setOnClickListener(this);
        busUpdatebtn.setOnClickListener(this);
        logoutbtn.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        if(v == logoutbtn){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

    }
}

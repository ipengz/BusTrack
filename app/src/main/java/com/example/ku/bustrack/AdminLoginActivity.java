package com.example.ku.bustrack;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AdminLoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextusername;
    private EditText editTextpassword;
    private Button loginbtn;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        firebaseAuth = FirebaseAuth.getInstance();


        editTextusername = (EditText)findViewById(R.id.editText_username);
        editTextpassword = (EditText)findViewById(R.id.editText_password);
        loginbtn = (Button) findViewById(R.id.button_login);

        loginbtn.setOnClickListener(this);
        progressDialog = new ProgressDialog(this);

    }
    private void adminUserLogin(){
        String email = editTextusername.getText().toString().trim();
        String password = editTextpassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter email", Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password", Toast.LENGTH_LONG).show();
            return;
        }
        progressDialog.setMessage("Logging in");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override

                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            progressDialog.dismiss();
                            finish();
                            startActivity(new Intent(getApplicationContext(), AdminMenuActivity.class));

                        }else{
                            progressDialog.dismiss();
                            Toast.makeText(AdminLoginActivity.this,"Login Unsuccessful, please try again", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
    public void onClick (View v){
        if(v == loginbtn){
            adminUserLogin();

        }
    }
}

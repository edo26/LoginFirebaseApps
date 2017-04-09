package com.bandung.android.loginfirebaseapps;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    //Binding data
    EditText username,password;
    Button login,daftar;

    //Variabel global
    FirebaseAuth databaseapi;
    FirebaseDatabase fd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inisialisasi awal Firebase
        databaseapi = FirebaseAuth.getInstance();
        fd = FirebaseDatabase.getInstance();

        //Fitur untuk auto-login atau session
        if(databaseapi.getCurrentUser() != null){ //Jika user sudah login maka otomatis masuk
            startActivity(new Intent(MainActivity.this,halamanawal.class));
        }

        //Binding data
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.login);
        daftar = (Button)findViewById(R.id.signup);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tampunguser,tampungpass;
                tampunguser = username.getText().toString().trim();
                tampungpass = password.getText().toString().trim();

                databaseapi.signInWithEmailAndPassword(tampunguser,tampungpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Berhasil login", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity.this,halamanawal.class));
                            finish();
                        }else{
                            Toast.makeText(MainActivity.this, "Error : "+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,regitrasi.class));
            }
        });

    }
}

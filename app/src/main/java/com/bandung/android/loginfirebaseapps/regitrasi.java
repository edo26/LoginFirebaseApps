package com.bandung.android.loginfirebaseapps;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by anggy on 31/03/2017.
 */

public class regitrasi extends AppCompatActivity {

    //Binding data
    EditText username,password,namalengkap,alamat,nomortelpon,kelas;
    Button daftar;

    //Variabel global
    FirebaseAuth databaseapi;
    DatabaseReference data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrasi);

        //Insialisasi firebase
        databaseapi = FirebaseAuth.getInstance();
        data = FirebaseDatabase.getInstance().getReference();


        //Binding data
        username = (EditText)findViewById(R.id.usernamedaftar);
        password = (EditText)findViewById(R.id.passworddaftar);
        daftar = (Button) findViewById(R.id.signupdaftar);
        namalengkap = (EditText)findViewById(R.id.namalengkap);
        alamat = (EditText)findViewById(R.id.alamat);
        nomortelpon = (EditText)findViewById(R.id.nomortelpon);
        kelas = (EditText)findViewById(R.id.kelas);

        final String namalengkap_,alamat_,nomortelpon_,kelas_;

        namalengkap_ = namalengkap.getText().toString().trim();
        alamat_ = alamat.getText().toString().trim();
        nomortelpon_ = nomortelpon.getText().toString().trim();
        kelas_ = kelas.getText().toString().trim();


        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tampunguser,tampungpass;
                tampunguser = username.getText().toString().trim();
                tampungpass = password.getText().toString().trim();

                databaseapi.createUserWithEmailAndPassword(tampunguser,tampungpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            Toast.makeText(regitrasi.this, "Selamat anda telah terdaftar!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(regitrasi.this,MainActivity.class));
                        }else{
                            Toast.makeText(regitrasi.this, "Error : "+task.getException(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });

    }
}

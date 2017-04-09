package com.bandung.android.loginfirebaseapps;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by anggy on 31/03/2017.
 */

public class halamanawal extends AppCompatActivity {

    Button logout;
    TextView namalengkap;
    FirebaseAuth databaseapi;
    DatabaseReference dr;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halamanawal);
        databaseapi = FirebaseAuth.getInstance();

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        logout = (Button)findViewById(R.id.logout);
        namalengkap = (TextView)findViewById(R.id.namalengkaphasil);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseapi.signOut();
                startActivity(new Intent(halamanawal.this,MainActivity.class));
            }
        });
    }
}

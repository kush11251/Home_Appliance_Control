package com.example.homeappliancecontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Switch S1,S2,S3,S4,S5,S6,S7,S8;
    Button button,button1;
    FirebaseDatabase mdatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference;

    Integer B1,B2,B3,B4,B5,B6,B7,B8;
    ButtonState state = new ButtonState(0,0,0,0,0,0,0,0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        S1     = findViewById(R.id.switch1);
        S2     = findViewById(R.id.switch2);
        S3     = findViewById(R.id.switch3);
        S4     = findViewById(R.id.switch4);
        S5     = findViewById(R.id.switch5);
        S6     = findViewById(R.id.switch6);
        S7     = findViewById(R.id.switch7);
        S8     = findViewById(R.id.switch8);
        button = findViewById(R.id.reset);
        button1= findViewById(R.id.set);

        databaseReference = mdatabase.getInstance().getReference();

        S1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                B1 = S1.isChecked() ? 1 : 0;
                state.B1 = B1;
                databaseReference.child("Button State").setValue(state);
            }
        });

        S2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                B2 = S2.isChecked() ? 1 : 0;
                state.B2 = B2;
                databaseReference.child("Button State").setValue(state);
            }
        });

        S3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                B3 = S3.isChecked() ? 1 : 0;
                state.B3 = B3;
                databaseReference.child("Button State").setValue(state);
            }
        });

        S4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                B4 = S4.isChecked() ? 1 : 0;
                state.B4 = B4;
                databaseReference.child("Button State").setValue(state);
            }
        });

        S5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                B5 = S5.isChecked() ? 1 : 0;
                state.B5 = B5;
                databaseReference.child("Button State").setValue(state);
            }
        });

        S6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                B6 = S6.isChecked() ? 1 : 0;
                state.B6 = B6;
                databaseReference.child("Button State").setValue(state);
            }
        });

        S7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                B7 = S7.isChecked() ? 1 : 0;
                state.B7 = B7;
                databaseReference.child("Button State").setValue(state);
            }
        });

        S8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                B8 = S8.isChecked() ? 1 : 0;
                state.B8 = B8;
                databaseReference.child("Button State").setValue(state);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state = new ButtonState(0,0,0,0,0,0,0,0);
                S1.setChecked(false);
                S2.setChecked(false);
                S3.setChecked(false);
                S4.setChecked(false);
                S5.setChecked(false);
                S6.setChecked(false);
                S7.setChecked(false);
                S8.setChecked(false);
                databaseReference.child("Button State").setValue(state);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                B1 = S1.isChecked() ? 1 : 0;
                B2 = S2.isChecked() ? 1 : 0;
                B3 = S3.isChecked() ? 1 : 0;
                B4 = S4.isChecked() ? 1 : 0;
                B5 = S5.isChecked() ? 1 : 0;
                B6 = S6.isChecked() ? 1 : 0;
                B7 = S7.isChecked() ? 1 : 0;
                B8 = S8.isChecked() ? 1 : 0;

                state = new ButtonState(B1,B2,B3,B4,B5,B6,B7,B8);
                databaseReference.child("Button State").setValue(state);
            }
        });
    }
}
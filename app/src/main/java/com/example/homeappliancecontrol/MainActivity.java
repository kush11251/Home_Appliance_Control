package com.example.homeappliancecontrol;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Switch S1,S2,S3,S4,S5,S6,S7,S8;
    Button setButton,getButton,resetButton;
    FirebaseDatabase mdatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference;

    Integer B1,B2,B3,B4,B5,B6,B7,B8;
    Integer X1,X2,X3,X4,X5,X6,X7,X8;
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
        setButton = findViewById(R.id.reset);
        getButton = findViewById(R.id.get);
        resetButton= findViewById(R.id.set);

        databaseReference = mdatabase.getInstance().getReference();

        S1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                B1 = S1.isChecked() ? 1 : 0;
                state.B1 = B1;
                databaseReference.setValue(state);
            }
        });

        S2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                B2 = S2.isChecked() ? 1 : 0;
                state.B2 = B2;
                databaseReference.setValue(state);
            }
        });

        S3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                B3 = S3.isChecked() ? 1 : 0;
                state.B3 = B3;
                databaseReference.setValue(state);
            }
        });

        S4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                B4 = S4.isChecked() ? 1 : 0;
                state.B4 = B4;
                databaseReference.setValue(state);
            }
        });

        S5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                B5 = S5.isChecked() ? 1 : 0;
                state.B5 = B5;
                databaseReference.setValue(state);
            }
        });

        S6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                B6 = S6.isChecked() ? 1 : 0;
                state.B6 = B6;
                databaseReference.setValue(state);
            }
        });

        S7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                B7 = S7.isChecked() ? 1 : 0;
                state.B7 = B7;
                databaseReference.setValue(state);
            }
        });

        S8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                B8 = S8.isChecked() ? 1 : 0;
                state.B8 = B8;
                databaseReference.setValue(state);
            }
        });

        setButton.setOnClickListener(new View.OnClickListener() {
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
                databaseReference.setValue(state);
            }
        });

        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        ButtonState state_get = snapshot.getValue(ButtonState.class);
                        state.B1 = state_get.B1;
                        state.B2 = state_get.B2;
                        state.B3 = state_get.B3;
                        state.B4 = state_get.B4;
                        state.B5 = state_get.B5;
                        state.B6 = state_get.B6;
                        state.B7 = state_get.B7;
                        state.B8 = state_get.B8;

                        if (state.B1 == 1)
                            S1.setChecked(true);
                        else
                            S1.setChecked(false);

                        if (state.B2 == 1)
                            S2.setChecked(true);
                        else
                            S2.setChecked(false);

                        if (state.B3 == 1)
                            S3.setChecked(true);
                        else
                            S3.setChecked(false);

                        if (state.B4 == 1)
                            S4.setChecked(true);
                        else
                            S4.setChecked(false);

                        if (state.B5 == 1)
                            S5.setChecked(true);
                        else
                            S5.setChecked(false);

                        if (state.B6 == 1)
                            S6.setChecked(true);
                        else
                            S6.setChecked(false);

                        if (state.B7 == 1)
                            S7.setChecked(true);
                        else
                            S7.setChecked(false);

                        if (state.B8 == 1)
                            S8.setChecked(true);
                        else
                            S8.setChecked(false);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getApplicationContext(),"Error Fetching Data" + error.toString(),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
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
                databaseReference.setValue(state);
            }
        });
    }
}
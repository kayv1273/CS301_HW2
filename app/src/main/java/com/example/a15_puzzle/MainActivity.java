package com.example.a15_puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SquareModel sm = new SquareModel();
        SquareView sv = new SquareView(sm);
        SquareController sc = new SquareController(sm, sv);
        // Restart button
        Button reStart = findViewById(R.id.start);
        // Buttons in array
        sv.addButton(0,0,findViewById(R.id.b_11));
        sv.addButton(0,1,findViewById(R.id.b_12));
        sv.addButton(0,2,findViewById(R.id.b_13));
        sv.addButton(0,3,findViewById(R.id.b_14));
        sv.addButton(1,0,findViewById(R.id.b_21));
        sv.addButton(1,1,findViewById(R.id.b_22));
        sv.addButton(1,2,findViewById(R.id.b_23));
        sv.addButton(1,3,findViewById(R.id.b_24));
        sv.addButton(2,0,findViewById(R.id.b_31));
        sv.addButton(2,1,findViewById(R.id.b_32));
        sv.addButton(2,2,findViewById(R.id.b_33));
        sv.addButton(2,3,findViewById(R.id.b_34));
        sv.addButton(3,0,findViewById(R.id.b_41));
        sv.addButton(3,1,findViewById(R.id.b_42));
        sv.addButton(3,2,findViewById(R.id.b_43));
        sv.addButton(3,3,findViewById(R.id.b_44));
        reStart.setOnClickListener(sc);
        sv.setOnClick(sc);
        // Shuffles game at start
        sv.shuffle();
    }
}
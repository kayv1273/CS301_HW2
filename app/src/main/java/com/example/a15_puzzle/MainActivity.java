package com.example.a15_puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SquareModel sm = new SquareModel();
        SquareView sv = new SquareView(sm);
        sv.addSquare(0,0,findViewById(R.id.b_11));
        sv.addSquare(0,1,findViewById(R.id.b_12));
        sv.addSquare(0,2,findViewById(R.id.b_13));
        sv.addSquare(0,3,findViewById(R.id.b_14));
        sv.addSquare(1,0,findViewById(R.id.b_21));
        sv.addSquare(1,1,findViewById(R.id.b_22));
        sv.addSquare(1,2,findViewById(R.id.b_23));
        sv.addSquare(1,3,findViewById(R.id.b_24));
        sv.addSquare(2,0,findViewById(R.id.b_31));
        sv.addSquare(2,1,findViewById(R.id.b_32));
        sv.addSquare(2,2,findViewById(R.id.b_33));
        sv.addSquare(2,3,findViewById(R.id.b_34));
        sv.addSquare(3,0,findViewById(R.id.b_41));
        sv.addSquare(3,1,findViewById(R.id.b_42));
        sv.addSquare(3,2,findViewById(R.id.b_43));
        sv.addSquare(3,3,findViewById(R.id.b_44));
        sv.addRestart(findViewById(R.id.start));

        SquareController sc = new SquareController(sm,sv);
        sv.setOnClick(sc);
        sv.shuffle();
    }
}
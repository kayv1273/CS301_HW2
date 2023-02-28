package com.example.a15_puzzle;

import android.view.View;

public class SquareController implements View.OnClickListener{
    SquareView sv;
    SquareModel sm;
    public SquareController(SquareModel sm, SquareView sv) {
        this.sm = sm;
        this.sv = sv;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.start) {
            sv.shuffle();
        } else {
            int swap = v.getId();
            int[] allMoves = sv.canMove();
            for (int i = 0; i < 2; i++) {
                if (allMoves[i] == swap) {
                    sv.swap(v);
                }
            }
        }
    }
}

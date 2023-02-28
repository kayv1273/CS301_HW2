package com.example.a15_puzzle;

import android.view.View;

import java.util.ArrayList;
import java.util.Collections;

public class SquareController implements View.OnClickListener {
    SquareView sv;
    SquareModel sm;
    public SquareController(SquareModel sm, SquareView sv) {
        this.sm = sm;
        this.sv = sv;
    }
    public void shuffle() {
        sm.setErow(3);
        sm.setEcol(3);
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        sv.shuffleText(numbers);
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.start) { shuffle(); }
        else {
            int swap = v.getId();
            ArrayList<Integer> allMoves = sv.canMove();
            if(allMoves.contains(swap)) {
                sv.swap(v);
                if (sv.gameOver()) {
                    // add winngin message
                }
            }
        }
    }
}

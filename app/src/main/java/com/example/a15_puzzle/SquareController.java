// Katherine Vu
package com.example.a15_puzzle;

import android.view.View;
import java.util.ArrayList;
public class SquareController implements View.OnClickListener {
    private SquareModel sm;
    private SquareView sv;
    public SquareController(SquareModel sm, SquareView sv) {
        this.sm = sm;
        this.sv = sv;
    }
    public void onClick(View view) {
        if (view.getId() == R.id.start) { sv.shuffle(); } // Shuffles when restart is clicked
        int swap = view.getId();
        ArrayList<Integer> Moves = sv.canMove();
        if(Moves.contains(swap)) {
            sv.swap(view);
            if(sv.gameOver()) { sv.isWinner(); } // If game won
        }
    }
}

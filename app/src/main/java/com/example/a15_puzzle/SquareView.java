package com.example.a15_puzzle;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SquareView {
    private SquareModel sm;
    private Button[][] squares;
    private Button reStart;

    public SquareView(SquareModel sm) {
        this.sm = sm;
        squares = new Button[4][4];
    }

    public void addSquare(int row, int col, Button b) {
        squares[row][col] = b;
    }

    public void addRestart(Button rs) {
        reStart = rs;
    }

    public void setOnClick(SquareController sc) {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                squares[row][col].setOnClickListener(sc);
            }
        }
        reStart.setOnClickListener(sc);
    }

    public int[] canMove() {
        int[] num = new int[2];
        int row = sm.erow();
        int col = sm.ecol();
        switch (row) {
            case 0:
                num[1] = squares[row + 1][col].getId();
                break;
            case 3:
                num[1] = squares[row - 1][col].getId();
                break;
            default:
                num[1] = squares[row + 1][col].getId();
                num[1] = squares[row - 1][col].getId();
                break;

        }
        switch (col) {
            case 0:
                num[2] = squares[row][col + 1].getId();
                break;
            case 3:
                num[2] = squares[row][col - 1].getId();
                break;
            default:
                num[2] = squares[row][col + 1].getId();
                num[2] = squares[row][col - 1].getId();
                break;
        }
        return num;
    }

    public void swap(View swap) {
        Button click = (Button) swap;
        Button temp = click;
        click = squares[sm.erow()][sm.ecol()];
        squares[sm.erow()][sm.ecol()] = temp;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 0; j++) {
                if (squares[i][j].getId() == click.getId()) {
                    sm.setErow(i);
                    sm.setEcol(j);
                }
            }
        }
    }

    /**
     * public void disable(int row, int col) {
     * squares[row][col].setVisibility(View.INVISIBLE);
     * }
     * public void enable(int row, int col) {
     * squares[row][col].setVisibility(View.VISIBLE);
     * //squares[row][col].setText(Integer.toString(sm.moves()));
     * }
     * public int isVisible(int row, int col) {
     * return squares[row][col].getVisibility();
     * }
     **/
    public void shuffle() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < 16; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
    }

    public void gameOver() {
        String[] numbers = {
                "1", "2", "3", "4",
                "5", "6", "7", "8",
                "9", "10", "11", "12",
                "13", "14", "15"
        };
        int index = 0;
        int count = 0;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (squares[row][col].getText().equals(numbers[index])) {
                    count++;
                }
                if (count == 15) {
                    squares[row][col].setBackgroundColor(Color.GREEN);
                    break;
                }
                index++;
            }
        }
    }
}
package com.example.a15_puzzle;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;
import java.util.Collections;


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
    public void shuffleText(ArrayList<Integer> numbers) {
        int index = 0;
        for(int row = 0; row < 4; row++) {
            for(int col = 0; col < 4; col++) {
                if(index == 15) { break; }
                squares[row][col].setText(Integer.toString(numbers.get(index)));
                index++;
            }
        }
    }
    public ArrayList<Integer> canMove() {
        ArrayList<Integer> num = new ArrayList<>();
        switch (sm.erow()) {
            case 0:
                num.add(squares[sm.erow() + 1][sm.ecol()].getId());
                break;
            case 3:
                num.add(squares[sm.erow() - 1][sm.ecol()].getId());
                break;
            case 1:
            case 2:
                num.add(squares[sm.erow() + 1][sm.ecol()].getId());
                num.add(squares[sm.erow() - 1][sm.ecol()].getId());
                break;

        }
        switch (sm.ecol()) {
            case 0:
                num.add(squares[sm.erow()][sm.ecol() + 1].getId());
                break;
            case 3:
                num.add(squares[sm.erow()][sm.ecol() - 1].getId());
                break;
            case 1:
            case 2:
                num.add(squares[sm.erow()][sm.ecol() + 1].getId());
                num.add(squares[sm.erow()][sm.ecol() - 1].getId());
                break;
        }
        return num;
    }

    public void swap(View swap) {
        Button click = (Button)swap;
        String text = click.getText().toString();

        squares[sm.erow()][sm.ecol()].setVisibility(View.VISIBLE);
        squares[sm.erow()][sm.ecol()].setClickable(true);
        squares[sm.erow()][sm.ecol()].setText(text);
        click.setVisibility(View.VISIBLE);
        click.setClickable(false);
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (squares[row][col].getId() == click.getId()) {
                    sm.setErow(row);
                    sm.setEcol(col);
                }
            }
        }
    }

        public boolean gameOver() {
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
                        return true;
                    }
                    index++;
                }
            }
            return false;
        }
    }
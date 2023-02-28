// Katherine Vu
package com.example.a15_puzzle;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;
import java.util.Collections;
public class SquareView {
    private SquareModel sm;
    private Button[][] buttons;
    public SquareView(SquareModel sm) {
        this.sm = sm;
        buttons = new Button[4][4];
    }
    // Adds buttons by ID
    public void addButton(int row, int col, Button button) { buttons[row][col] = button; }
    // Sets all buttons to be clickable
    public void setOnClick(SquareController sc) {
        for(int row = 0; row < 4; row++) {
            for(int col = 0; col < 4; col++) {
                buttons[row][col].setOnClickListener(sc);
            }
        }
    }
    // Enables buttons to be visible and clickable
    public void enable() {
        for(int row = 0; row < 4; row++) {
            for(int col = 0; col < 4; col++) {
                buttons[row][col].setClickable(true);
                buttons[row][col].setVisibility(View.VISIBLE);
            }
        }
    }
    // Disables null button to be invisible and un-clickable
    public void disable() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (buttons[row][col].getId() == R.id.b_44) {
                    buttons[row][col].setClickable(false);
                    buttons[row][col].setVisibility(View.INVISIBLE);
                    sm.setErow(row);
                    sm.setEcol(col);
                }
            }
        }
    }
    // Shuffles numbers on buttons
    public void shuffle() {
        enable();
        disable();
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i = 1; i <= 15; i++) { numbers.add(i); }
        Collections.shuffle(numbers);
        shuffleText(numbers);
    }
    // Shuffles text on button
    public void shuffleText(ArrayList<Integer> numbers) {
        int index = 0;
        for(int row = 0; row < 4; row++) {
            for(int col = 0; col < 4; col++) {
                if(index == 15) { break; }
                buttons[row][col].setText(Integer.toString(numbers.get(index)));
                index++;
            }
        }
    }
    // Checks where button is movable
    public ArrayList<Integer> canMove() {
        ArrayList<Integer> num = new ArrayList<>();
        switch (sm.erow()) {
            case 0: num.add(buttons[sm.erow() + 1][sm.ecol()].getId()); // edge-case
                    break;
            case 3: num.add(buttons[sm.erow() - 1][sm.ecol()].getId()); // edge-case
                    break;
            case 1:
            case 2:
                    num.add(buttons[sm.erow() - 1][sm.ecol()].getId());
                    num.add(buttons[sm.erow() + 1][sm.ecol()].getId());
                    break;
            }
        switch (sm.ecol()) {
            case 0: num.add(buttons[sm.erow()][sm.ecol() + 1].getId()); // edge-case
                    break;
            case 3: num.add(buttons[sm.erow()][sm.ecol() - 1].getId()); // edge-case
                    break;
            case 1:
            case 2:
                    num.add(buttons[sm.erow()][sm.ecol() + 1].getId());
                    num.add(buttons[sm.erow()][sm.ecol() - 1].getId());
                    break;
        }
        return num;
    }
    // Swaps the adjacent button with the null button
    public void swap(View view) {
        Button clickedButton = (Button)view;
        String num = clickedButton.getText().toString(); // Text of clicked button
        // Null button becomes filled in
        buttons[sm.erow()][sm.ecol()].setVisibility(View.VISIBLE);
        buttons[sm.erow()][sm.ecol()].setClickable(true);
        buttons[sm.erow()][sm.ecol()].setText(num);
        // Clicked button becomes null
        clickedButton.setVisibility(View.INVISIBLE);
        clickedButton.setClickable(false);
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(buttons[i][j].getId() == clickedButton.getId()) {
                    // New null coordinates
                    sm.setErow(i);
                    sm.setEcol(j);
                }
            }
        }
    }
    // Indicates if game is won
    public boolean gameOver() {
        String[] text = {
                "1", "2", "3", "4",
                "5", "6", "7", "8",
                "9", "10", "11", "12",
                "13", "14", "15"
        }; // To check if array matches with index
        int index = 0;
        int count = 0;
        for(int row = 0; row < 4; row++) {
            for(int col = 0; col < 4; col++) {
                if (buttons[row][col].getText().equals(text[index])) {
                    count++;
                }
                index++;
                if (index == 15) {
                    break;
                }
            }
        }
        if (count == 15) {
            return true;
        }
        return false;
    }
    // Will say yay on every button when won
    public void isWinner() {
        for(int row = 0; row < 4; row++) {
            for(int col = 0; col < 4; col++) {
                buttons[row][col].setText("YAY");
            }
        }
    }
}
package com.example.a15_puzzle;

public class SquareModel {
    // Variables for empty row and col
    int erow;
    int ecol;
    int moves;
    public int erow() { return erow; }
    public int ecol() {return ecol; }
    public void setErow(int row) { erow = row; }
    public void setEcol(int col) { ecol = col; }
    public int moves() { return moves; }
    public void addMoves() { moves++; }
}

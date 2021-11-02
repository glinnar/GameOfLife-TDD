package com.example;

import java.util.Arrays;

public class Gameboard {


    /*
     1. Any live cell with fewer than two live neighbors dies, as if caused by
underpopulation.
 2. Any live cell with more than three live neighbors dies, as if by
overcrowding.
 3. Any live cell with two or three live neighbors lives on to the next
generation.
 4. Any dead cell with exactly three live neighbors becomes a live cell.
    *
    *
    * */
    private int boardWidth;
    private int boardHeight;
    int[][] board;

    public Gameboard(int width, int height) {
        this.boardWidth = width;
        this.boardHeight = height;
        this.board = new int[width][height];
    }

    public int getBoardWidth() {
        return boardWidth;
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public int[][] getBoard() {
        return board;
    }


    public void printGameBoard() {
        System.out.println("---");
        for (int y = 0; y < boardHeight; y++) {
            String line = "|";
            for (int x = 0; x < boardHeight; x++) {
                if (this.board[x][y] == 0) {
                    line += ".";
                } else {
                    line += "*";
                }
            }
            line += "|";
            System.out.println(line);

        }
        System.out.println("---\n");
    }

    public void addCells(int x , int y){
        this.board[x][y] = 1;


    }


}

package com.example;

public class Gameboard {

    private int width;
    private int height;
    int[][] board;

    public Gameboard(int width, int height) {
        this.width = width;
        this.height = height;
        this.board = new int[width][height];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getBoard() {
        return board;
    }


    public void printGameBoard(){
        System.out.println("---");
        for (int y = 0; y < height; y++) {
            String line = "|";
            for(int x = 0; x<height; x++){
                if(this.board[x][y] == 0){
                    line += ".";
                }else {
                    line += "*";
                }
            }
            line += "|";
            System.out.println(line);

        }
        System.out.println("---\n");
    }


}

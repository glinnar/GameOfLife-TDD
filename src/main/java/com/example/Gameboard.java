package com.example;

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
    private int[][] board;
    public final static int ALIVE = 1;
    public final static int DEAD = 0;


    public Gameboard(int width, int height) {
        this.boardWidth = width;
        this.boardHeight = height;
         this.board= new int[width][height];
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


    public void addLivingCells(int x, int y) {
        board[x][y] = ALIVE;
    }

    public void deleteLivingCells(int x, int y) {
        board[x][y] = DEAD;
    }

    public int getLivingCellsCloseBy(int x, int y) {
        int amount = 0;

        amount += cellExistWithinBoard(x - 1, y - 1);
        amount += cellExistWithinBoard(x, y - 1);
        amount += cellExistWithinBoard(x + 1, y - 1);

        amount += cellExistWithinBoard(x - 1, y);
        amount += cellExistWithinBoard(x + 1, y);

        amount += cellExistWithinBoard(x - 1, y + 1);
        amount += cellExistWithinBoard(x, y + 1);
        amount += cellExistWithinBoard(x + 1, y + 1);

        return amount;
    }

    public int cellExistWithinBoard(int x, int y) {
        if (x < 0 || x >= boardWidth) {
            return 0;
        } else {
            if (y < 0 || y >= boardHeight) {
                return 0;
            }
        }
        return this.board[x][y];
    }

    public void generateNewGenearationOfCells() {

        int[][] newBoard = new int[boardWidth][boardHeight];

        for (int y = 0; y < boardHeight; y++) {
            for (int x = 0; x < boardWidth; x++) {

                int aliveNeighbours = getLivingCellsCloseBy(x, y);

                if (cellExistWithinBoard(x, y) == 1) {
                    if (aliveNeighbours < 2) {
                        newBoard[x][y] = DEAD;
                    } else if (aliveNeighbours == 2 || aliveNeighbours == 3) {
                        newBoard[x][y] = ALIVE;
                    } else {
                        newBoard[x][y] = DEAD;
                    }
                } else {
                    if (aliveNeighbours == 3) {
                        newBoard[x][y] = ALIVE;
                    }
                }
            }
        }
        board = newBoard;
    }


    public boolean cellIsAlive(int x, int y) {

        return board[x][y] == ALIVE;
    }

    public boolean cellIsDead(int x, int y) {
        return board[x][y] == DEAD;


    }

    public boolean cellIsDeadWithTreeLivingCellsCloseBy(int x, int y){
        int livingCellsCloseBy = getLivingCellsCloseBy(x,y);

        return cellIsDead(x,y) && livingCellsCloseBy == 3;
    }

//    public boolean cellIsAliveAndHasMoreThanThreeLivingCellsCloseBy(int x , int y){
//
//    }


}

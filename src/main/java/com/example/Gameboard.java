package com.example;

public class Gameboard {


    private int boardWidth;
    private int boardHeight;
    private int[][] board;
    public final static int ALIVE = 1;
    public final static int DEAD = 0;


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

                // if (cellExistWithinBoard(x, y) == 1) {

                //thisCellIsAliveAndHasLessThanTwoLivingNeighbours(y, x
                if (cellIsAliveAndHaslessThanTwoLivingCellsCloseBy(x, y)) {
                    newBoard[x][y] = DEAD;

                    //thisCellIsAliveAndHasTwoOrThreeLivingNeighbours(y, x)
                } else if (cellHas2Or3LivingCellsCloseby(x, y)) {
                    newBoard[x][y] = ALIVE;

                    //(thisCellIsAliveAndHasMoreThanThreeLivingNeighbours(y, x)) {
                } else if (cellIsAliveAndHasMoreThanThreeLivingCellsCloseBy(x, y)) {
                    newBoard[x][y] = DEAD;

                } else if (cellIsDeadWithTreeLivingCellsCloseBy(x, y)) {
                    newBoard[x][y] = ALIVE;

                }
                else{
                    newBoard[x][y] = board[x][y];
                }

                //(thisCellIsDeadAndHasThreeLivingNeighbours(y, x)
            }
        }
        //}
        board = newBoard;
    }


    public boolean cellIsAlive(int x, int y) {

        return board[x][y] == ALIVE;
    }

    public boolean cellIsDead(int x, int y) {
        return board[x][y] == DEAD;


    }

    private boolean cellIsDeadWithTreeLivingCellsCloseBy(int x, int y) {
        int livingCellsCloseBy = getLivingCellsCloseBy(x, y);

        return cellIsDead(x, y) && livingCellsCloseBy == 3;
    }

    private boolean cellIsAliveAndHasMoreThanThreeLivingCellsCloseBy(int x, int y) {
        int livingCellsCloseBy = getLivingCellsCloseBy(x, y);

        return cellIsAlive(x, y) && livingCellsCloseBy > 3;

    }

    private boolean cellHas2Or3LivingCellsCloseby(int x, int y) {
        int livingCellsCloseBy = getLivingCellsCloseBy(x, y);

        return cellIsAlive(x, y) && (livingCellsCloseBy == 2 || livingCellsCloseBy == 3);
    }

    private boolean cellIsAliveAndHaslessThanTwoLivingCellsCloseBy(int x, int y) {
        int livingCellsCloseBy = getLivingCellsCloseBy(x, y);

        return cellIsAlive(x, y) && livingCellsCloseBy < 2;
    }


}

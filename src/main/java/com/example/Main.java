package com.example;

public class Main {
    public static void main(String[] args) {


        Gameboard gameboard = new Gameboard(8, 5);

        gameboard.addLivingCells(2, 2);
        gameboard.addLivingCells(3, 2);
        gameboard.addLivingCells(4, 2);

        gameboard.addLivingCells(4, 4);
        gameboard.addLivingCells(3, 3);
        gameboard.addLivingCells(2, 1);

        gameboard.printGameBoard();

        for (int i = 0; i <= 5; i++) {
            gameboard.generateNewGenerationOfCells();

            gameboard.printGameBoard();

        }


    }
}

package com.prabirmsp;

import java.io.Console;

public class Main {

    public static void main(String[] args) {

        final int width = 100;
        final int height = 60;
        final int randomPercent = 50;

        // print title
        System.out.printf("\n Conway's Game of Life\n\n");

        // set initial game board
        GameBoard initialBoard = new GameBoard(width, height);

        // set random board
        initialBoard.randomizeBoard(randomPercent);

        // draw initial board
        Output.drawBoard(initialBoard);
        Output.printDetails(initialBoard, 0);

        System.out.println("-- End of initial Board --");
        Output.pause();

        // create new board
        GameBoard newBoard;
        try {
            newBoard = (GameBoard) initialBoard.clone();

            int iterationNumber = 0;

            while (true) {
                newBoard.iterate();
                Output.drawBoard(newBoard);
                Output.printDetails(newBoard, ++iterationNumber);
                Output.pause();
            }
        } catch (CloneNotSupportedException c) {
        }
    }


}

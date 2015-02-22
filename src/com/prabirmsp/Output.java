package com.prabirmsp;

/**
 * Created by prabir on 2/21/15.
 */
public class Output {


    public static void drawBoard(GameBoard gameBoard) {

        System.out.printf("╔");
        for (int i = 0; i < (2 * gameBoard.getWidth()); i++)
            System.out.printf("═");
        System.out.printf("╗\n");


        for (int y = 0; y < gameBoard.getHeight(); y++) {
            System.out.printf("║");
            for (int x = 0; x < gameBoard.getWidth(); x++) {
                if (gameBoard.getState(x, y))
                    System.out.printf("██");
                else
                    System.out.printf("░░");
            }
            System.out.printf("║\n");
        }

        System.out.printf("╚");
        for (int i = 0; i < (2 * gameBoard.getWidth()); i++)
            System.out.printf("═");
        System.out.printf("╝\n");

    }

    public static void printDetails(GameBoard gameBoard, int iterationNumber) {
        System.out.printf("Live Cell Count: %6d     Iteration: %d\n", gameBoard.getLiveCount(), iterationNumber);
    }

    public static void pause() {
        System.out.println("Press Enter to continue... ");
        try {
            char in = (char) System.in.read();
        } catch (Exception e) {
        }
    }

}

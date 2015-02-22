package com.prabirmsp;

import java.util.Random;

/**
 * Created by prabir on 2/20/15.
 */
public class GameBoard implements Cloneable {

    private boolean mGameBoard[][];
    private int mWidth;
    private int mHeight;

    public boolean[][] getGameBoard() {
        return mGameBoard;
    }

    public int getWidth() {
        return mWidth;
    }

    public int getHeight() {
        return mHeight;
    }


    // GameBoard constructor 1
    public GameBoard(int width, int height) {
        mWidth = width;
        mHeight = height;
        mGameBoard = new boolean[width][height];
    }

    // GameBoard constructor 2
    public GameBoard(GameBoard board) {
        this.mGameBoard = board.mGameBoard;
    }

    // clone object
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void toggle(int x, int y) {
        mGameBoard[x][y] = !mGameBoard[x][y];
    }

    public boolean getState(int x, int y) {
        return mGameBoard[x][y];
    }

    public void setLive(int x, int y) {
        mGameBoard[x][y] = true;
    }

    public void setDead(int x, int y) {
        mGameBoard[x][y] = false;
    }

    public void resetBoard() {
        mGameBoard = new boolean[mWidth][mHeight];
    }

    public void randomizeBoard(int percentLiving) {
        Random random = new Random();
        for (int y = 0; y < mHeight; y++) {
            for (int x = 0; x < mWidth; x++) {
                if (random.nextInt(100) < percentLiving)
                    mGameBoard[x][y] = true;
            }
        }
    }

    public int getLiveCount() {
        int liveCount = 0;
        for (int y = 0; y < mHeight; y++)
            for (int x = 0; x < mWidth; x++)
                if (mGameBoard[x][y])
                    liveCount++;
        return liveCount;
    }

    public int getLiveNeighbors(int x, int y) {
        int liveNeighbors = 0;

        for (int i = y - 1; i < y + 2; i++) {     // check rows
            if ((i >= 0) && (i < mHeight)) {      // check if rows exist
                for (int j = x - 1; j < x + 2; j++) {  // check columns
                    if ((j >= 0) && (j < mWidth)) {     // check if columns exist
                        if (!((i == y) && (j == x)))
                            if (mGameBoard[j][i])
                                liveNeighbors++;
                    }
                }
            }
        }
        return liveNeighbors;
    }

    public void iterate () {
        try {
            GameBoard oldBoard = (GameBoard) super.clone();
            this.resetBoard();
            for (int i = 0; i < mHeight; i++) {
                for (int j = 0; j < mWidth; j++) {
                    int liveNeighbors = oldBoard.getLiveNeighbors(j, i);
                    // RULES
                    if (oldBoard.getState(j, i)) { // 1, 2, 3
                        if (liveNeighbors == 2 || liveNeighbors == 3)
                            this.setLive(j, i);
                    } else if (liveNeighbors == 3) { // 4
                        this.setLive(j, i);
                    }
                }
            }
        }catch (CloneNotSupportedException c){}
    }



}

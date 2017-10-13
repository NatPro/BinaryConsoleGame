package control;

import model.DecimalNumber;

import java.util.Random;

public class Level {

    private int difficulty;
    private int bitLength;
    private DecimalNumber decimalNumber;

    public Level(int difficulty) {
        this.difficulty = difficulty;
        decimalNumber = new DecimalNumber(getRandomNumber(difficulty/4, difficulty));
    }

    private int getRandomNumber(int min, int max) {
        Random rand = new Random();
        int number = rand.nextInt((max - min) + 1) + min;
        return number;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getBitLength() {
        return bitLength;
    }

    public void setBitLength(int bitLength) {
        this.bitLength = bitLength;
    }

    public DecimalNumber getDecimalNumber() {
        return decimalNumber;
    }

    public void setDecimalNumber(DecimalNumber decimalNumber) {
        this.decimalNumber = decimalNumber;
    }
}

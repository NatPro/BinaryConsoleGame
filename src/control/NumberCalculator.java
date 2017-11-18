package control;

import model.Config;
import java.util.Random;

public class NumberCalculator {

    public static int getDifficulty(int score) {
        return score / Config.POINTS_TO_NEXT_LEVEL + 2;
    }

    public static int getDecimal(int difficulty) {
        return createRandomNumber(difficulty);
    }

    public static String getBinary(int number) {
        return createBinaryRepresentation(number);
    }

    private static int createRandomNumber(int difficulty) {
        return getRandomNumber(difficulty / 4, difficulty);
    }

    private static int getRandomNumber(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    private static String createBinaryRepresentation(int decimalNr) {
        String binaryString = Integer.toBinaryString(decimalNr);
        return binaryFillUpWithLeadingZeros(binaryString);
    }

    private static String binaryFillUpWithLeadingZeros(String binaryString) {
        if (binaryString.length() == Config.MAX_NUMBER_OF_CARDS) {
            return binaryString;
        }

        String filledUpString = binaryString;
        for (int i = 0; i < Config.MAX_NUMBER_OF_CARDS - binaryString.length(); i++) {
            filledUpString = "0" + filledUpString;
        }

        return filledUpString;
    }

}

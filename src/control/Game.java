package control;

import model.Config;
import view.AsciiCardPrinter;
import view.InputHandler;

public class Game {

    private int score;
    private AsciiCardPrinter cardPrinter = new AsciiCardPrinter();
    private boolean quit;

    public void start() {
        while (isRunning()) {
            nextRound();
        }
    }

    private boolean isRunning() {
        return score >= 0 && !quit;
    }

    private void nextRound() {
        int difficulty = NumberCalculator.getDifficulty(score);
        int decimalNumber = NumberCalculator.getDecimal(difficulty);
        String binaryNumber = NumberCalculator.getBinary(decimalNumber);

        cardPrinter.printBinary(binaryNumber);
        InputHandler inputHandler = new InputHandler();
        inputHandler.askQuestion();

        if (inputHandler.wantsToQuitGame()) {
            quit = true;
        } else {
            boolean answerIsCorrect = checkAnswerRight(inputHandler.getAnswer(), decimalNumber);
            if (answerIsCorrect) {
                handleCorrectAnswer();
            } else {
                handleWrongAnswer(decimalNumber);
            }
        }
    }

    private boolean checkAnswerRight(int input, int correctAnswer) {
        return input == correctAnswer;
    }

    private void handleCorrectAnswer() {
        System.out.println(Config.MESSAGE_RIGHT_ANSWER);
        updatePoints(Config.POINTS_RIGHT_ANSWER);
    }

    private void handleWrongAnswer(int decimalNumber) {
        System.out.println(Config.MESSAGE_WRONG_ANSWER);
        System.out.println(Config.MESSAGE_CORRECT_ANSWER + decimalNumber);
        updatePoints(Config.POINTS_WRONG_ANSWER);
        checkGameOver();
    }

    private void checkGameOver() {
        if (score < 0) {
            showGameOver();
        }
    }

    private void showGameOver() {
        System.out.println(Config.MESSAGE_GAME_OVER);
    }

    private void updatePoints(int earnedPoints) {
        score += earnedPoints;
        showPoints();
    }

    private void showPoints() {
        String pointMessage = Config.MESSAGE_COUNT_POINTS;
        if (score == 1 || score == -1) {
            pointMessage = Config.MESSAGE_COUNT_POINT;
        }
        System.out.println(pointMessage.replace(Config.REPLACE_MARKER, Integer.toString(score)));
    }
}
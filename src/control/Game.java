package control;

import model.Config;
import view.AsciiCardPrinter;
import view.InputHandler;
import view.MessagePrinter;

public class Game {

    private int score;
    private final AsciiCardPrinter cardPrinter = new AsciiCardPrinter();
    private boolean quit;

    public void start() {
        while (isActive()) {
            playRound();
        }
    }

    private boolean isActive() {
        return score >= 0 && !quit;
    }

    /*
    This method contains the main game logic.
     */
    private void playRound() {
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
        MessagePrinter.printRight();
        updatePoints(Config.POINTS_RIGHT_ANSWER);
    }

    private void handleWrongAnswer(int decimalNumber) {
        MessagePrinter.printWrong(decimalNumber);
        updatePoints(Config.POINTS_WRONG_ANSWER);
        checkGameOver();
    }

    private void checkGameOver() {
        if (score < 0) {
            MessagePrinter.showGameOver();
        }
    }

    private void updatePoints(int earnedPoints) {
        score += earnedPoints;
        MessagePrinter.showPoints(score);
    }
}
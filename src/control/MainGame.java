package control;

import model.AsciiCard;
import model.Config;
import view.AsciiCardPrinter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainGame {

    private static ArrayList<AsciiCard> cards;

    private static Level level;
    private static boolean gameIsOver = false;

    private static int points;
    private static int pointsPerRightAnswer = 1;
    private static int pointsPerWrongAnswer = -1;

    private static int pointsToNextLevel = pointsPerRightAnswer * 2;

    public static void main(String[] args) {
        startGame();
        while (!gameIsOver) {
            playGame();
        }
    }

    private static void playGame() {
        level = new Level(points / pointsToNextLevel + 2);
        String binary = level.getDecimalNumber().getBinaryRepresentation();
        cards = CardGenerator.getAsciiCards(binary);
        AsciiCardPrinter ac = new AsciiCardPrinter(cards);
        ac.paintCardsToConsole();

        System.out.println(Config.INPUT_PROMPT);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int i = Integer.parseInt(br.readLine());
            boolean inputIsCorrect = checkAnswer(i, level.getDecimalNumber().getValue());
            if (inputIsCorrect) {
                handleCorrectInput();
            } else {
                handleWrongInput();
            }
        } catch (NumberFormatException nfe) {
            System.err.println("Invalid Format!");
            handleWrongInput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void startGame() {

    }

    private static boolean checkAnswer(int input, int correctAnswer) {
        return input == correctAnswer;
    }

    private static void handleCorrectInput() {
        System.out.println(Config.MESSAGE_RIGHT_ANSWER);
        updatePoints(pointsPerRightAnswer);
    }

    private static void handleWrongInput() {
        System.out.println(Config.MESSAGE_WRONG_ANSWER);
        System.out.println(Config.MESSAGE_CORRECT_ANSWER + level.getDecimalNumber().getValue());
        updatePoints(pointsPerWrongAnswer);
        checkGameOver();
    }

    private static void checkGameOver() {
        if (points <= 0) {
            gameIsOver = true;
            showGameOver();
        }
    }

    private static void showGameOver() {
        System.out.println(Config.MESSAGE_GAME_OVER);
    }

    private static void updatePoints(int earnedPoints) {
        points += earnedPoints;
        showPoints();
    }

    private static void showPoints() {
        String pointMessage = Config.MESSAGE_COUNT_POINTS;
        if (points == 1 || points == -1) {
            pointMessage = Config.MESSAGE_COUNT_POINT;
        }
        System.out.println(pointMessage.replace(Config.REPLACE_MARKER, points + ""));
    }
}
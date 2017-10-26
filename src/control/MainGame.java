package control;

import view.AsciiCards;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainGame {

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
        AsciiCards ac = new AsciiCards();
        ac.paintCardsToConsole(binary);

        System.out.println("Dezimalzahl: ");
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
        System.out.println("RICHTIG!!");
        updatePoints(pointsPerRightAnswer);
    }

    private static void handleWrongInput() {
        System.out.println("██████ FALSCH!! ██████");
        System.out.println("Die richtige Antwort ist: " + level.getDecimalNumber().getValue());
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
        System.out.println("Du hast verloren!!");
    }

    private static void updatePoints(int earnedPoints) {
        points += earnedPoints;
        showPoints();
    }

    private static void showPoints() {
        if (points == 1 || points == -1) {
            System.out.println("Du hast jetzt " + points + " Punkt.");
            return;
        }
        System.out.println("Du hast jetzt " + points + " Punkte.");
    }
}
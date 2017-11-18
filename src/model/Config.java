package model;

public class Config {

    private Config() {
        // private constructor to hide implicit public one
    }

    public static final int MAX_NUMBER_OF_CARDS = 6;
    public static final int CARD_HEIGHT = 10;

    public static final int POINTS_RIGHT_ANSWER = 1;
    public static final int POINTS_WRONG_ANSWER = -1;
    public static final int POINTS_TO_NEXT_LEVEL = 2;

    public static final String MESSAGE_BINARY = "Darstellung als Binärzahl: ";
    public static final String MESSAGE_QUIT = "(x beendet das Spiel)";
    public static final String MESSAGE_DECIMAL = "Umrechnung in Dezimalzahl: ";

    public static final String REPLACE_MARKER = "%s";
    public static final String MESSAGE_RIGHT_ANSWER = "RICHTIG!!";
    public static final String MESSAGE_WRONG_ANSWER = "██████ FALSCH!! ██████";
    public static final String MESSAGE_CORRECT_ANSWER = "Die richtige Antwort lautet: ";
    public static final String MESSAGE_GAME_OVER = "Du hast verloren!";
    public static final String MESSAGE_COUNT_POINTS = "Dein Punktestand: " + REPLACE_MARKER + " Punkte.";
    public static final String MESSAGE_COUNT_POINT = "Dein Punktestand: " + REPLACE_MARKER + " Punkt.";
    public static final String MESSAGE_INVALID_INPUT = "Das war keine Zahl, bitte noch mal eingeben.";
}
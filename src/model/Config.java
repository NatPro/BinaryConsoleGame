package model;

public class Config {

    public static final int CARD_HEIGHT = 10;
    public static final int CARD_WIDTH = 15;

    public static final String INPUT_PROMPT = "Dezimalzahl: ";

    public static final int POINTS_RIGHT_ANSWER = 1;
    public static final int POINTS_WRONG_ANSWER = -1;

    public static final String REPLACE_MARKER = "%s";

    public static final String MESSAGE_RIGHT_ANSWER = "RICHTIG!!";
    public static final String MESSAGE_WRONG_ANSWER = "██████ FALSCH!! ██████";
    public static final String MESSAGE_CORRECT_ANSWER = "Die richtige Antwort lautet: ";
    public static final String MESSAGE_GAME_OVER = "Du hast verloren!";
    public static final String MESSAGE_COUNT_POINTS = "Dein Punktestand: " + REPLACE_MARKER + " Punkte.";
    public static final String MESSAGE_COUNT_POINT = "Dein Punktestand: " + REPLACE_MARKER + " Punkt.";


}

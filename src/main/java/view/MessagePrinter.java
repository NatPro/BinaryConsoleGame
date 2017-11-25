package view;

import model.Config;

public class MessagePrinter {

    private MessagePrinter() {
        // private constructor to hide implicit public one
    }

    public static void printRight() {
        System.out.println(Config.MESSAGE_RIGHT_ANSWER);
    }

    public static void printWrong(int rightAnswer) {
        System.out.println(Config.MESSAGE_WRONG_ANSWER);
        System.out.println(Config.MESSAGE_CORRECT_ANSWER + rightAnswer);
    }

    public static void showPoints(int score) {
        String pointMessage = Config.MESSAGE_COUNT_POINTS;
        if (score == 1 || score == -1) {
            pointMessage = Config.MESSAGE_COUNT_POINT;
        }
        System.out.println(pointMessage.replace(Config.REPLACE_MARKER, Integer.toString(score)));
    }

    public static void showGameOver() {
        System.out.println(Config.MESSAGE_GAME_OVER);
    }
}

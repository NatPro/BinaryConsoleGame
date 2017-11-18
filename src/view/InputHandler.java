package view;

import model.Config;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputHandler {

    private boolean wantsToQuitGame = false;
    private boolean validInput = true;
    private int answer;

    public void askQuestion() {
        do {
            System.out.println(Config.MESSAGE_QUIT);
            System.out.println(Config.MESSAGE_DECIMAL);
            readInputFromConsole();
        } while (!validInput);
    }

    private void readInputFromConsole() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = br.readLine();
            checkQuit(input);
            if (!wantsToQuitGame) {
                convertNumber(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkQuit(String input) {
        wantsToQuitGame = input.equals("x") || input.equals("X");
    }

    private void convertNumber(String input) {
        try {
            answer = Integer.parseInt(input);
            validInput = true;
        } catch (NumberFormatException nfe) {
            validInput = false;
            printError();
        }
    }

    private void printError() {
        System.out.println(Config.MESSAGE_INVALID_INPUT);
    }

    public boolean wantsToQuitGame() {
        return wantsToQuitGame;
    }

    public int getAnswer() {
        return answer;
    }
}
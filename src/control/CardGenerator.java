package control;

import model.AsciiCard;

import java.util.ArrayList;

public class CardGenerator {

    private static ArrayList<AsciiCard> cards = new ArrayList<>();


    public static ArrayList<AsciiCard> getAsciiCards(String binary) {
        AsciiCard card;

        for (int i=0; i<binary.length(); i++) {
            card = new AsciiCard(getBinaryValue(binary, i));
            cards.add(card);
        }

        return cards;
    }

    private static int getBinaryValue(String binary, int i) {
        return Integer.parseInt(binary.charAt(i)+"");
    }


}

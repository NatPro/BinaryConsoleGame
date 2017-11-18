package control;

import model.AsciiCard;
import java.util.ArrayList;

public class CardGenerator {

    public static ArrayList<AsciiCard> getAsciiCards(String binary) {
        ArrayList<AsciiCard> cards = new ArrayList<>();
        for (int i=0; i<binary.length(); i++) {
            AsciiCard card = new AsciiCard(getBinaryValue(binary, i));
            cards.add(card);
        }
        return cards;
    }

    private static int getBinaryValue(String binary, int i) {
        return Integer.parseInt(binary.charAt(i)+"");
    }
}

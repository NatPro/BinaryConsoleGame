package control;

import model.AsciiCard;
import java.util.ArrayList;
import java.util.List;

public class CardGenerator {

    private CardGenerator() {
        // private constructor to hide implicit public one
    }

    public static List<AsciiCard> getAsciiCards(String binary) {
        ArrayList<AsciiCard> cards = new ArrayList<>();
        for (int i=0; i<binary.length(); i++) {
            AsciiCard card = new AsciiCard(getBinaryValue(binary, i));
            cards.add(card);
        }
        return cards;
    }

    private static int getBinaryValue(String binary, int i) {
        return Integer.parseInt(Character.toString(binary.charAt(i)));
    }
}

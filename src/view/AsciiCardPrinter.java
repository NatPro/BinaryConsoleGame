package view;

import model.AsciiCard;
import model.Config;

import java.util.ArrayList;

public class AsciiCardPrinter {


    private final ArrayList<AsciiCard> cards;

    public AsciiCardPrinter(ArrayList<AsciiCard> cards) {

        this.cards = cards;
    }

    public void paintCardsToConsole() {
        // ToDo what if card.representation.size() < CARD_HEIGHT??? null  null null null
        for (int height = 0; height < Config.CARD_HEIGHT; height++) {
            for (int i = 0; i < cards.size(); i++) {
                System.out.print(cards.get(i).getRepresentationLine(height));
                System.out.print("  ");
            }
            System.out.println("");
        }

    }


}

package view;

import control.CardGenerator;
import model.AsciiCard;
import model.Config;

import java.util.ArrayList;

public class AsciiCardPrinter {

    public void printBinary(String binaryNumber) {
        ArrayList<AsciiCard> cards = CardGenerator.getAsciiCards(binaryNumber);
        System.out.println(Config.MESSAGE_BINARY);
        printCardsToConsole(cards);
    }
    private void printCardsToConsole(ArrayList<AsciiCard> cards) {
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

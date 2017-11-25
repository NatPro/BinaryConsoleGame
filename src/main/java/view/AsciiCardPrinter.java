package view;

import control.CardGenerator;
import model.AsciiCard;
import model.Config;
import java.util.List;

public class AsciiCardPrinter {

    public void printBinary(String binaryNumber) {
        List<AsciiCard> cards = CardGenerator.getAsciiCards(binaryNumber);
        System.out.println(Config.MESSAGE_BINARY);
        printCardsToConsole(cards);
    }

    private void printCardsToConsole(List<AsciiCard> cards) {
        for (int height = 0; height < AsciiCard.CARD_HEIGHT; height++) {
            for (AsciiCard card : cards) {
                System.out.print(card.getRepresentationLine(height));
                System.out.print("  ");
            }
            System.out.println("");
        }
    }
}

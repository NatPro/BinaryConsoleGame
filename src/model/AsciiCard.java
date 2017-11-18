package model;

public class AsciiCard {

    private int value;
    private String[] representation;
    
    public AsciiCard(int zeroOrOne) {
        value = zeroOrOne;
        setRepresentation();
    }

    private void setRepresentation() {
        representation = new String[Config.CARD_HEIGHT];
        if (value == 0) {
            representZeroCard();
        } else {
            representOneCard();
        }
    }

    private void representZeroCard() {
        representation[0] = "╔═════════════╗";
        representation[1] = "║             ║";
        representation[2] = "║  #########  ║";
        representation[3] = "║  #       #  ║";
        representation[4] = "║  #       #  ║";
        representation[5] = "║  #       #  ║";
        representation[6] = "║  #       #  ║";
        representation[7] = "║  #########  ║";
        representation[8] = "║             ║";
        representation[9] = "╚═════════════╝";
    }

    private void representOneCard() {
        representation[0] = "╔═════════════╗";
        representation[1] = "║             ║";
        representation[2] = "║      #      ║";
        representation[3] = "║      #      ║";
        representation[4] = "║      #      ║";
        representation[5] = "║      #      ║";
        representation[6] = "║      #      ║";
        representation[7] = "║      #      ║";
        representation[8] = "║             ║";
        representation[9] = "╚═════════════╝";
    }

    public String getRepresentationLine(int lineNumber) {
        return representation[lineNumber];
    }
}
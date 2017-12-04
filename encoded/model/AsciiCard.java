package model;

public class AsciiCard {

    public static final int CARD_HEIGHT = 10;

    private final int value;
    private String[] representation;

    public AsciiCard(int zeroOrOne) {
        value = zeroOrOne;
        setRepresentation();
    }

    private void setRepresentation() {
        representation = new String[CARD_HEIGHT];
        if (value == 0) {
            representZeroCard();
        } else {
            representOneCard();
        }
    }

    private void representZeroCard() {
        representation[0] = "\u00e2\u0095\u0094\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0097";
        representation[1] = "\u00e2\u0095\u0091             \u00e2\u0095\u0091";
        representation[2] = "\u00e2\u0095\u0091  #########  \u00e2\u0095\u0091";
        representation[3] = "\u00e2\u0095\u0091  #       #  \u00e2\u0095\u0091";
        representation[4] = "\u00e2\u0095\u0091  #       #  \u00e2\u0095\u0091";
        representation[5] = "\u00e2\u0095\u0091  #       #  \u00e2\u0095\u0091";
        representation[6] = "\u00e2\u0095\u0091  #       #  \u00e2\u0095\u0091";
        representation[7] = "\u00e2\u0095\u0091  #########  \u00e2\u0095\u0091";
        representation[8] = "\u00e2\u0095\u0091             \u00e2\u0095\u0091";
        representation[9] = "\u00e2\u0095\u009a\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u009d";
    }

    private void representOneCard() {
        representation[0] = "\u00e2\u0095\u0094\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0097";
        representation[1] = "\u00e2\u0095\u0091             \u00e2\u0095\u0091";
        representation[2] = "\u00e2\u0095\u0091      #      \u00e2\u0095\u0091";
        representation[3] = "\u00e2\u0095\u0091      #      \u00e2\u0095\u0091";
        representation[4] = "\u00e2\u0095\u0091      #      \u00e2\u0095\u0091";
        representation[5] = "\u00e2\u0095\u0091      #      \u00e2\u0095\u0091";
        representation[6] = "\u00e2\u0095\u0091      #      \u00e2\u0095\u0091";
        representation[7] = "\u00e2\u0095\u0091      #      \u00e2\u0095\u0091";
        representation[8] = "\u00e2\u0095\u0091             \u00e2\u0095\u0091";
        representation[9] = "\u00e2\u0095\u009a\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u0090\u00e2\u0095\u009d";
    }

    public String getRepresentationLine(int lineNumber) {
        return representation[lineNumber];
    }
}

package model;

public class AsciiCard {

    private static final String TOP_LEFT_CORNER = "╔";
    private static final String TOP_RIGHT_CORNER = "╗";
    private static final String LOWER_LEFT_CORNER = "╚";
    private static final String LOWER_RIGHT_CORNER = "╝";
    private static final String FRAME_HORIZONTAL = "═";
    private static final String FRAME_VERTICAL = "║";
    private static final String FRAME_BORDER_MARGIN = "  ";
    private static final String SIGN = "#";
    private static final String NO_SIGN = " ";

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
        int zeroWidth = Config.CARD_WIDTH - 2 * FRAME_VERTICAL.length() - 2 * FRAME_BORDER_MARGIN.length();
        int innerWidth = zeroWidth - 2 * SIGN.length();
        representation[0] = topCardFrame();                                                                                                                     // "╔═══════════════╗"
        representation[1] = emptyLine();                                                                                                                        // "║             ║"
        representation[2] = FRAME_VERTICAL + FRAME_BORDER_MARGIN + loopStringNtimes(SIGN, zeroWidth) + FRAME_BORDER_MARGIN + FRAME_VERTICAL;                    // "║  #########  ║"
        representation[3] = FRAME_VERTICAL + FRAME_BORDER_MARGIN + SIGN + loopStringNtimes(NO_SIGN, innerWidth) + SIGN + FRAME_BORDER_MARGIN + FRAME_VERTICAL;  // "║  #       #  ║"
        representation[4] = FRAME_VERTICAL + FRAME_BORDER_MARGIN + SIGN + loopStringNtimes(NO_SIGN, innerWidth) + SIGN + FRAME_BORDER_MARGIN + FRAME_VERTICAL;  // "║  #       #  ║"
        representation[5] = FRAME_VERTICAL + FRAME_BORDER_MARGIN + SIGN + loopStringNtimes(NO_SIGN, innerWidth) + SIGN + FRAME_BORDER_MARGIN + FRAME_VERTICAL;  // "║  #       #  ║"
        representation[6] = FRAME_VERTICAL + FRAME_BORDER_MARGIN + SIGN + loopStringNtimes(NO_SIGN, innerWidth) + SIGN + FRAME_BORDER_MARGIN + FRAME_VERTICAL;  // "║  #       #  ║"
        representation[7] = FRAME_VERTICAL + FRAME_BORDER_MARGIN + loopStringNtimes(SIGN, zeroWidth) + FRAME_BORDER_MARGIN + FRAME_VERTICAL;                    // "║  #########  ║"
        representation[8] = emptyLine();                                                                                                                        // "║             ║"
        representation[9] = lowerCardFrame();                                                                                                                   // "╚═══════════════╝"
    }

    private void representOneCard() {
        // TODO if WIdth is even, than no +1 neccessary...
        int visualHalf = (Config.CARD_WIDTH - 4) / 2 + 1;
        representation[0] = topCardFrame();                                                                                                          // "╔═══════════════╗"
        representation[1] = emptyLine();                                                                                                             // "║             ║"
        representation[2] = FRAME_VERTICAL + loopStringNtimes(NO_SIGN, visualHalf) + SIGN + loopStringNtimes(NO_SIGN, visualHalf) + FRAME_VERTICAL;  // "║      #      ║"
        representation[3] = FRAME_VERTICAL + loopStringNtimes(NO_SIGN, visualHalf) + SIGN + loopStringNtimes(NO_SIGN, visualHalf) + FRAME_VERTICAL;  // "║      #      ║"
        representation[4] = FRAME_VERTICAL + loopStringNtimes(NO_SIGN, visualHalf) + SIGN + loopStringNtimes(NO_SIGN, visualHalf) + FRAME_VERTICAL;  // "║      #      ║"
        representation[5] = FRAME_VERTICAL + loopStringNtimes(NO_SIGN, visualHalf) + SIGN + loopStringNtimes(NO_SIGN, visualHalf) + FRAME_VERTICAL;  // "║      #      ║"
        representation[6] = FRAME_VERTICAL + loopStringNtimes(NO_SIGN, visualHalf) + SIGN + loopStringNtimes(NO_SIGN, visualHalf) + FRAME_VERTICAL;  // "║      #      ║"
        representation[7] = FRAME_VERTICAL + loopStringNtimes(NO_SIGN, visualHalf) + SIGN + loopStringNtimes(NO_SIGN, visualHalf) + FRAME_VERTICAL;  // "║      #      ║"
        representation[8] = emptyLine();                                                                                                             // "║             ║"
        representation[9] = lowerCardFrame();                                                                                                        // "╚═══════════════╝"
    }

    private String topCardFrame() {
        return TOP_LEFT_CORNER + loopStringNtimes(FRAME_HORIZONTAL, Config.CARD_WIDTH - 2) + TOP_RIGHT_CORNER;
    }

    private String emptyLine() {
        return FRAME_VERTICAL + loopStringNtimes(NO_SIGN, Config.CARD_WIDTH - 2) + FRAME_VERTICAL;
    }

    private String lowerCardFrame() {
        return LOWER_LEFT_CORNER + loopStringNtimes(FRAME_HORIZONTAL, Config.CARD_WIDTH - 2) + LOWER_RIGHT_CORNER;
    }

    private String loopStringNtimes(String signToLoop, int times) {
        String loopedSign = "";
        for (int i = 0; i < times; i++) {
            loopedSign += signToLoop;
        }
        return loopedSign;
    }

    public String getRepresentationLine(int lineNumber) {
        return representation[lineNumber];
    }
}
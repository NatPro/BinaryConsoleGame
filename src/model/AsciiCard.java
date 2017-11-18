package model;

public class AsciiCard {

    private int value;
    private String sign;
    private String borderMargin = "  ";
    private String noSign = " ";
    private String[] representation;

    private String topLeftCorner = "╔";
    private String topRightCorner = "╗";
    private String lowerLeftCorner = "╚";
    private String lowerRightCorner = "╝";

    private String frameHorizontal = "═";
    private String frameVertical = "║";

    public AsciiCard(int zeroOrOne) {
        value = zeroOrOne;
        setSign();
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

    private void setSign() {
        sign = "#";
        // might make different signs depending on the value
        //sign = value == 1 ? "#" : "+";
    }

    private void representZeroCard() {
        representation[0] = topCardFrame();   // "╔═══════════════╗"
        representation[1] = emptyLine();      // "║             ║"
        int zeroWidth = Config.CARD_WIDTH - 2 * frameVertical.length() - 2 * borderMargin.length();
        int innerWidth = zeroWidth - 2 * sign.length();
        representation[2] = frameVertical + borderMargin + loopStringNtimes(sign, zeroWidth) + borderMargin + frameVertical;
        representation[3] = frameVertical + borderMargin + sign + loopStringNtimes(noSign, innerWidth) + sign + borderMargin + frameVertical;
        representation[4] = frameVertical + borderMargin + sign + loopStringNtimes(noSign, innerWidth) + sign + borderMargin + frameVertical;
        representation[5] = frameVertical + borderMargin + sign + loopStringNtimes(noSign, innerWidth) + sign + borderMargin + frameVertical;
        representation[6] = frameVertical + borderMargin + sign + loopStringNtimes(noSign, innerWidth) + sign + borderMargin + frameVertical;
        representation[7] = frameVertical + borderMargin + loopStringNtimes(sign, zeroWidth) + borderMargin + frameVertical;
        representation[8] = emptyLine();      // "║             ║"
        representation[9] = lowerCardFrame(); // "╚═══════════════╝"
    }

    private void representOneCard() {
        representation[0] = topCardFrame();   // "╔═══════════════╗"
        representation[1] = emptyLine();      // "║             ║"
        // TODO if WIdth is even, than no +1 neccessary...
        int visualHalf = (Config.CARD_WIDTH - 4) / 2 + 1;
        representation[2] = frameVertical + loopStringNtimes(noSign, visualHalf) + sign + loopStringNtimes(noSign, visualHalf) + frameVertical;
        representation[3] = frameVertical + loopStringNtimes(noSign, visualHalf) + sign + loopStringNtimes(noSign, visualHalf) + frameVertical;
        representation[4] = frameVertical + loopStringNtimes(noSign, visualHalf) + sign + loopStringNtimes(noSign, visualHalf) + frameVertical;
        representation[5] = frameVertical + loopStringNtimes(noSign, visualHalf) + sign + loopStringNtimes(noSign, visualHalf) + frameVertical;
        representation[6] = frameVertical + loopStringNtimes(noSign, visualHalf) + sign + loopStringNtimes(noSign, visualHalf) + frameVertical;
        representation[7] = frameVertical + loopStringNtimes(noSign, visualHalf) + sign + loopStringNtimes(noSign, visualHalf) + frameVertical;
        representation[8] = emptyLine();      // "║             ║"
        representation[9] = lowerCardFrame(); // "╚═══════════════╝"
    }

    private String topCardFrame() {
        return topLeftCorner + loopStringNtimes(frameHorizontal, Config.CARD_WIDTH - 2) + topRightCorner;
    }

    private String emptyLine() {
        return frameVertical + loopStringNtimes(noSign, Config.CARD_WIDTH - 2) + frameVertical;
    }

    private String lowerCardFrame() {
        return lowerLeftCorner + loopStringNtimes(frameHorizontal, Config.CARD_WIDTH - 2) + lowerRightCorner;
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

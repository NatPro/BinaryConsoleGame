package view;

public class AsciiCards {

    private int cardHeight = 6;
    private int cardWidth = 17;

    private String horizontalFrame = "\u2550";
    private String verticalFrame = "\u2551";
    private String frameHorizontal = "═";
    //private String frameVertical = "║";
    private String frameVertical = "║";

    //  private char signOne = 35;
    private String signZero = "#";
    private String signOne = "#";
    private String signEmpty = " ";

    public AsciiCards() {
    }

    public void paintCardsToConsole(String binary) {
        int numberOfCards = binary.length();

        printTopFrame(numberOfCards);
        for (int j = 0; j < cardHeight; j++) {
            for (int i = 0; i < numberOfCards; i++) {
                if (binary.charAt(i) == '1') {
                    printOneCard();
                }
                if (binary.charAt(i) == '0') {
                    if (j == 0 || j == cardHeight - 1) {
                        printZeroHorizontalLine();
                        continue;
                    }
                    printZeroCard();
                }
            }
            System.out.println("");

        }
        printBottomFrame(numberOfCards);
    }

    private void printTopFrame(int length) {
        fullLineTop(length);
        emptyLine(length);

    }

    private void fullLineTop(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print("╔");
            for (int j = 0; j < cardWidth-2; j++) {
                System.out.print(frameHorizontal);
            }
            System.out.print("╗");
            System.out.print("  ");
        }
        System.out.println("");
    }

    private void emptyLine(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(frameVertical);
            for (int j = 0; j < cardWidth - 2; j++) {
                System.out.print(signEmpty);
            }
            System.out.print(frameVertical + signEmpty + signEmpty);
        }
        System.out.print("\n");
    }

    private void printZeroCard() {
        System.out.print(frameVertical);
        for (int j = 0; j < cardWidth - 2; j++) {
            if (j == 3 || j == cardWidth - 6) {
                System.out.print(signZero);
                continue;
            }
            System.out.print(signEmpty);
        }
        System.out.print(frameVertical + signEmpty + signEmpty);
    }

    private void printZeroHorizontalLine() {
        System.out.print(frameVertical + signEmpty + signEmpty+ signEmpty);
        for (int j = 0; j < cardWidth - 8; j++) {
            System.out.print(signZero);
        }
        System.out.print(signEmpty + signEmpty+ signEmpty + frameVertical + signEmpty + signEmpty);
    }

    private void printOneCard() {
        System.out.print(frameVertical);
        for (int j = 0; j < cardWidth - 2; j++) {
            if (j == cardWidth / 2 - 1) {
                System.out.print(signOne);
            } else {
                System.out.print(signEmpty);
            }
        }
        System.out.print(frameVertical + signEmpty + signEmpty);
    }

    private void printBottomFrame(int length) {
        emptyLine(length);
        fullLineBottom(length);
    }

    private void fullLineBottom(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print("╚");
            for (int j = 0; j < cardWidth-2; j++) {
                System.out.print(frameHorizontal);
            }
            System.out.print("╝");
            System.out.print("  ");
        }
        System.out.println("");
    }
}

package model;

public class BinaryNumber {

    private int value;
    private String binaryString;

    public BinaryNumber(int decimalNr) {
        this.value = decimalNr;
        binaryString = Integer.toBinaryString(decimalNr);
        binaryString = fillUpWithLeadingZeros(binaryString);
    }

    private String fillUpWithLeadingZeros(String binaryString) {
        if (binaryString.length() == 6) {
            return binaryString;
        }
        String filledUpString = binaryString;

        for (int i = 0; i < 6 - binaryString.length(); i++) {
            filledUpString = "0" + filledUpString;
        }

        return filledUpString;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getBinaryString() {
        return binaryString;
    }

    public void setBinaryString(String binaryString) {
        this.binaryString = binaryString;
    }
}

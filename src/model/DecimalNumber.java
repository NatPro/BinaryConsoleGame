package model;

public class DecimalNumber {

    int value;
    BinaryNumber bin;

    public DecimalNumber() {
        value = 7;
        bin = new BinaryNumber(7);
    }

    public DecimalNumber(int randomNumber) {
        value = randomNumber;
        bin = new BinaryNumber(value);
    }

    public String getBinaryRepresentation() {
        return bin.getBinaryString();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryNumber getBin() {
        return bin;
    }

    public void setBin(BinaryNumber bin) {
        this.bin = bin;
    }
}

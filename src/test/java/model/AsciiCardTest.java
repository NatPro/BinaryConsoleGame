package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AsciiCardTest {
    @Test
    void getRepresentationLine() {
        assertEquals(10, AsciiCard.CARD_HEIGHT);
    }
}
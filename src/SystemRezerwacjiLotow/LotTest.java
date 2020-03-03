package SystemRezerwacjiLotow;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class LotTest {

    Date dataW1 = new Date(2019,9,11,17,30);
    Date dataP1 = new Date(2019,9,15,18,45);
    Lot test = new Lot("Warszawa Chopina","WAWCHO","Budapeszt","BUD", dataW1, dataP1, 2.5, 70, 400);

    @org.junit.jupiter.api.Test
    void nowaCena1_1() {
        assertEquals(440, test.nowaCena1_1());
    }

    @org.junit.jupiter.api.Test
    void nowaCena1_25() {
        assertEquals(500, test.nowaCena1_25());
    }
}
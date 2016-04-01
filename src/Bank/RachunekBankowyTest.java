package Bank;

import operacjaBankowa.OperacjaBankowaWplata;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by inf113149 on 2016-03-18.
 */
public class RachunekBankowyTest {
    RachunekBankowy rachunekBankowy;

    public RachunekBankowyTest() {
        rachunekBankowy = new RachunekBankowy(1);
    }

    @Test
    public void testWyplata() throws Exception {
        rachunekBankowy.setSaldo(1000);
        double kwota = 100;
        rachunekBankowy.wyplata(kwota);
        assertEquals(1000 - kwota, rachunekBankowy.getSaldo(), 0.001d);
    }

    @Test
    public void testWyplataMinus() throws Exception {
        rachunekBankowy.setSaldo(1000);
        double kwota = -100;
        boolean result = rachunekBankowy.wyplata(kwota);
        assertFalse(result);
        assertEquals(1000, rachunekBankowy.getSaldo(), 0.001d);
    }

    @Test
    public void testWyplataZero() throws Exception {
        rachunekBankowy.setSaldo(1000);
        double kwota = 0;
        boolean result = rachunekBankowy.wyplata(kwota);
        assertFalse(result);
        assertEquals(1000, rachunekBankowy.getSaldo(), 0.001d);
    }

    @Test
    public void testWplata() throws Exception {
        rachunekBankowy.setSaldo(1000);
        double kwota = 100;
        rachunekBankowy.wplata(kwota);
        assertEquals(1000 + kwota, rachunekBankowy.getSaldo(), 0.001d);
    }

    @Test
    public void testWplataMinus() throws Exception {
        rachunekBankowy.setSaldo(1000);
        double kwota = -100;
        boolean result = rachunekBankowy.wplata(kwota);
        assertFalse(result);
        assertEquals(1000, rachunekBankowy.getSaldo(), 0.001d);
    }

    @Test
    public void testWplataZero() throws Exception {
        rachunekBankowy.setSaldo(1000);
        double kwota = 0;
        boolean result = rachunekBankowy.wplata(kwota);
        assertFalse(result);
        assertEquals(1000, rachunekBankowy.getSaldo(), 0.001d);
    }


    @Test
    public void testDodajDoHistorii() throws Exception {
        OperacjaBankowaWplata operacjaBankowaWplata = new OperacjaBankowaWplata(rachunekBankowy);
        rachunekBankowy.dodajDoHistorii(operacjaBankowaWplata);
        boolean res = rachunekBankowy.getHistoria().czyZawiera(operacjaBankowaWplata);
        assertTrue(res);
    }
}
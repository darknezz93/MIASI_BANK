package Bank;

import operacjaBankowa.OperacjaBankowaWplata;
import operacjaBankowa.OperacjaBankowaWyplata;
import org.junit.Test;
import rachunekBankowy.RachunekBankowy;

import static org.junit.Assert.*;

/**
 * Created by inf113149 on 2016-03-18.
 */
public class RachunekBankowyTest {
    RachunekBankowy rachunekBankowy;
    OperacjaBankowaWyplata operacjaBankowaWyplata;
    OperacjaBankowaWplata operacjaBankowaWplata;

    public RachunekBankowyTest() {
        rachunekBankowy = new RachunekBankowy(1);
        //operacjaBankowaWyplata = new OperacjaBankowaWyplata(this.rachunekBankowy);
        //operacjaBankowaWplata = new OperacjaBankowaWplata(this.rachunekBankowy);
    }

    @Test
    public void testWyplata() throws Exception {

        rachunekBankowy.setSaldo(1000);
        double kwota = 100;
        operacjaBankowaWyplata = new OperacjaBankowaWyplata(this.rachunekBankowy, kwota);

        operacjaBankowaWyplata.wykonajOperacje();

        assertEquals(1000 - kwota, rachunekBankowy.getSaldo(), 0.001d);
    }

    @Test
    public void testWyplataMinus() throws Exception {
        rachunekBankowy.setSaldo(1000);
        double kwota = -100;

        operacjaBankowaWyplata = new OperacjaBankowaWyplata(this.rachunekBankowy, kwota);
        boolean result = operacjaBankowaWyplata.wykonajOperacje();

        assertFalse(result);
        assertEquals(1000, rachunekBankowy.getSaldo(), 0.001d);
    }

    @Test
    public void testWyplataZero() throws Exception {

        rachunekBankowy.setSaldo(1000);
        double kwota = 0;

        operacjaBankowaWyplata = new OperacjaBankowaWyplata(this.rachunekBankowy, kwota);
        boolean result = operacjaBankowaWyplata.wykonajOperacje();

        assertFalse(result);
        assertEquals(1000, rachunekBankowy.getSaldo(), 0.001d);
    }

    @Test
    public void testWplata() throws Exception {

        rachunekBankowy.setSaldo(1000);
        double kwota = 100;

        operacjaBankowaWplata = new OperacjaBankowaWplata(this.rachunekBankowy, kwota);

        operacjaBankowaWplata.wykonajOperacje();

        assertEquals(1000 + kwota, rachunekBankowy.getSaldo(), 0.001d);
    }

    @Test
    public void testWplataMinus() throws Exception {

        rachunekBankowy.setSaldo(1000);
        double kwota = -100;

        operacjaBankowaWplata = new OperacjaBankowaWplata(this.rachunekBankowy, kwota);
        boolean result = operacjaBankowaWplata.wykonajOperacje();

        assertFalse(result);
        assertEquals(1000, rachunekBankowy.getSaldo(), 0.001d);
    }

    @Test
    public void testWplataZero() throws Exception {

        rachunekBankowy.setSaldo(1000);
        double kwota = 0;

        operacjaBankowaWplata = new OperacjaBankowaWplata(this.rachunekBankowy, kwota);
        boolean result =  operacjaBankowaWplata.wykonajOperacje();

        assertFalse(result);
        assertEquals(1000, rachunekBankowy.getSaldo(), 0.001d);
    }


    @Test
    public void testDodajDoHistorii() throws Exception {
        int kwota = 10;
        rachunekBankowy.setSaldo(1000);

        OperacjaBankowaWplata operacjaBankowaWplata = new OperacjaBankowaWplata(rachunekBankowy, kwota);
        rachunekBankowy.dodajDoHistorii(operacjaBankowaWplata);
        boolean res = rachunekBankowy.getHistoria().czyZawiera(operacjaBankowaWplata);
        assertTrue(res);
    }
}
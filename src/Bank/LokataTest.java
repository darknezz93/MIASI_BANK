package Bank;

import com.odsetki.Odsetki;
import com.odsetki.OdsetkiLokata;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by inf113149 on 2016-03-18.
 */
public class LokataTest {
    private static final double testOprocentowanie = 10;
    //public Lokata lokata = new Lokata(1, new OdsetkiLokata(testOprocentowanie), 100, new Date(System.currentTimeMillis() - 200000000));

    @Test
    public void testRozwiazLokate() throws Exception {
        Odsetki odsetki = new Odsetki();
        odsetki.setState(new OdsetkiLokata(10));
        Lokata lokata = new Lokata(1, odsetki, 100, new Date(System.currentTimeMillis() - 200000000), 10);
        double saldo = lokata.getSaldo();
        boolean result = lokata.rozwiazLokate();
        assertTrue(result);
        assertEquals(lokata.getSaldo(), odsetki.naliczOdsetki(saldo), 0.001d);
    }

    @Test
    public void testRozwiazLokateDataPozniejsza() throws Exception {
        Odsetki odsetki = new Odsetki();
        odsetki.setState(new OdsetkiLokata(10));
        Lokata lokata = new Lokata(1, odsetki, 100, new Date(System.currentTimeMillis() + 200000000), 10);
        double saldo = lokata.getSaldo();
        boolean result = lokata.rozwiazLokate();
        assertFalse(result);
        assertEquals(saldo, lokata.getSaldo(), 0.001d);
    }


}
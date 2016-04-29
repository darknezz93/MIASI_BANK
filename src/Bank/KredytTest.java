package Bank;

import com.odsetki.Odsetki;
import com.odsetki.OdsetkiKredytowe;
import org.junit.Test;
import rachunekBankowy.RachunekBankowy;

import static org.junit.Assert.*;

public class KredytTest{



    @Test
    public void wezKredytTest() {
        RachunekBankowy rachunek = new RachunekBankowy(356789563);
        //OdsetkiKredytowe odset = new OdsetkiKredytowe(10);
        Odsetki odsetki = new Odsetki();
        odsetki.setState(new OdsetkiKredytowe(10));

        rachunek.setSaldo(100);
        Kredyt kredyt = new Kredyt(rachunek, 100, odsetki);
        kredyt.wezKredyt();
        assertEquals(rachunek.getSaldo(), 200, 0.001d);
    }

    @Test
    public void splacKredytTest() {
        RachunekBankowy rachunek = new RachunekBankowy(356789563);
        Odsetki odsetki = new Odsetki();
        odsetki.setState(new OdsetkiKredytowe(10));

        rachunek.setSaldo(1000);
        Kredyt kredyt = new Kredyt(rachunek, 100, odsetki);
        kredyt.wezKredyt();
        boolean result = kredyt.splacKredyt(kredyt.kwotaDoSplacenia());
        assertTrue(result);
        assertEquals(rachunek.getSaldo(), 990, 0.001d);
    }

}
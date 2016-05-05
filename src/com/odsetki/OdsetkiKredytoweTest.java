package com.odsetki;

import org.junit.Test;

import static org.junit.Assert.*;

public class OdsetkiKredytoweTest {


    @Test
    public void naliczOdsetkiTest() {

        Odsetki odsetki = new Odsetki();
        odsetki.setState(new OdsetkiKredytowe(20));
        double result = odsetki.naliczOdsetki(100.0);
        assertEquals(result, 120.0, 0.001d);
    }


}
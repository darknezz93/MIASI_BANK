package com.odsetki;

import org.junit.Test;

import static org.junit.Assert.*;

public class OdsetkiKredytoweTest {


    @Test
    public void naliczOdsetkiTest() {

        OdsetkiKredytowe odsetkiKredytowe = new OdsetkiKredytowe(20);
        double result = odsetkiKredytowe.naliczOdsetki(100.0);
        assertEquals(result, 80.0,  0.001d);
    }



}
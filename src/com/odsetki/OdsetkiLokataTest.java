package com.odsetki;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OdsetkiLokataTest {


    @Test
    public void naliczOdsetkiTest() {

        OdsetkiLokata odsetkiLokata = new OdsetkiLokata(20);
        double result = odsetkiLokata.naliczOdsetki(100.0);
        assertEquals(result, 120.0,  0.001d);
    }

}
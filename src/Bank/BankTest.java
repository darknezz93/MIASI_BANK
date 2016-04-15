package Bank;

import operacjaBankowa.OperacjaBankowaWplata;

import static org.junit.Assert.*;

/**
 * Created by inf113149 on 2016-03-18.
 */
public class BankTest {

    private Bank bank;

    public BankTest(){
        initBankTest();
    }

    private void initBankTest() {
        bank = new Bank();
        //bank.zalozKonto();
        //bank.zalozKonto();
    }

    @org.junit.Test
    public void testDodajDoHistoriiBanku() throws Exception {
        RachunekBankowy rachunekBankowy = bank.zalozKonto();
        int kwota = 10;
        OperacjaBankowaWplata operacjaBankowaWplata = new OperacjaBankowaWplata(rachunekBankowy, kwota);
        bank.dodajDoHistoriiBanku(operacjaBankowaWplata);
        boolean res = bank.getHistoria().czyZawiera(operacjaBankowaWplata);
        assertTrue(res);
    }


    @org.junit.Test
    public void testZalozKonto() throws Exception {
        RachunekBankowy rachunekBankowy = bank.zalozKonto();
        boolean res = bank.czyKontoIstnieje(rachunekBankowy);
        assertTrue(res);
    }

}
package Bank;

import org.junit.Test;
import org.mockito.Mockito;
import rachunekBankowy.RachunekBankowy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


/**
 * Created by inf113149 on 2016-04-01.
 */
public class RaportTest {

    private final Bank mockedBank;
    private final List<RachunekBankowy> defaultList;

    public RaportTest(){
        Bank test = Mockito.mock(Bank.class);
        this.defaultList = getDefaultList();
        when(test.getRachunkiBankowe()).thenReturn(defaultList);
        this.mockedBank = test;
    }

    private List<RachunekBankowy> getDefaultList() {
        List<RachunekBankowy> result = new ArrayList<>();
        for (int i = 1000; i < 100000; i++) {
            RachunekBankowy rachunekBankowy = new RachunekBankowy(i);
            rachunekBankowy.setSaldo(100+i);
            if(i%15==0){
                rachunekBankowy.setDebet(new Debet(100+i));
            }
            result.add(rachunekBankowy);
        }
        return result;
    }

    @Test
    public void testPobierzRachunkiSaldoWiekszeRowne() throws Exception {
        RachunekBankowy rachunekBankowy = (new Raport()).pobierzRachunekONajwiekszymSaldzie(mockedBank);
        assertEquals(rachunekBankowy, defaultList.get(defaultList.size()-1));
    }

    @Test
    public void testPobierzRachunkiSaldoMniejsze() throws Exception {

    }

    @Test
    public void testPobierzRachunekONajwiekszymSaldzie() throws Exception {

    }
}
package Bank;

import java.util.ArrayList;
import java.util.List;

import operacjaBankowa.OperacjaBankowa;
import rachunekBankowy.RachunekBankowy;

public class Bank {

    private String nazwaBanku;
    private List<RachunekBankowy> rachunkiBankowe = new ArrayList<RachunekBankowy>();
    private static Historia historia = new Historia();

    public Historia getHistoria() {
        return historia;
    }

    public void setHistoria(Historia historia) {
        this.historia = historia;
    }

    public static void dodajDoHistoriiBanku(OperacjaBankowa operacja) {
        //historia.operacje.add(operacja);
        historia.dodajElement(operacja);
    }

    public List<RachunekBankowy> getRachunkiBankowe() {
        return rachunkiBankowe;
    }

    public RachunekBankowy zalozKonto() {
        RachunekBankowy r = new RachunekBankowy(getUniqueAccountNumber());
        System.out.println("Numer konta:" + r.numerRachunku);
        rachunkiBankowe.add(r);
        return r;
    }

    public boolean czyKontoIstnieje(RachunekBankowy rachunekBankowy) {
        return rachunkiBankowe.contains(rachunekBankowy);
    }

    private long getUniqueAccountNumber() {
        long max = 0;
        if (rachunkiBankowe.size() > 0) {
            max = rachunkiBankowe.get(0).numerRachunku;
        }
        for (int i = 1; i < rachunkiBankowe.size(); i++) {
            if (rachunkiBankowe.get(i).numerRachunku > max) {
                max = rachunkiBankowe.get(i).numerRachunku;
            }
        }
        return max + 1;
    }
}

package Bank;

import java.util.ArrayList;
import java.util.List;

import operacjaBankowa.OperacjaBankowa;
import rachunekBankowy.DebetowyRachunekBankowy;
import rachunekBankowy.IRachunekBankowy;
import rachunekBankowy.RachunekBankowy;
import raport.PayoffHigherThanReport;
import raport.SaldoHigherThanReport;

public class Bank {

    private String nazwaBanku;
    private List<IRachunekBankowy> rachunkiBankowe = new ArrayList<IRachunekBankowy>();
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

    public List<IRachunekBankowy> getRachunkiBankowe() {
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
            max = rachunkiBankowe.get(0).getNumerKonta();
        }
        for (int i = 1; i < rachunkiBankowe.size(); i++) {
            if (rachunkiBankowe.get(i).getNumerKonta() > max) {
                max = rachunkiBankowe.get(i).getNumerKonta();
            }
        }
        return max + 1;
    }

    public boolean ustawDebetDlaKonta(IRachunekBankowy konto, int maksDebet) {
        int i = rachunkiBankowe.indexOf(konto);
        if (i >= 0 && rachunkiBankowe.remove(konto)) {
            rachunkiBankowe.add(i, new DebetowyRachunekBankowy(konto, new Debet(maksDebet)));
            return true;
        }
        return false;
    }

    public boolean usuńDebetZKonta(DebetowyRachunekBankowy konto) {
        int i = rachunkiBankowe.indexOf(konto);
        IRachunekBankowy opakowane = konto.getChild();
        if (i >= 0 && konto.getSaldoDebetu() == 0d && opakowane != null) {
            rachunkiBankowe.remove(konto);
            rachunkiBankowe.add(i, opakowane);
            return true;
        }
        return false;
    }

    public String getSaldoHigherThanReport(double valueToCompare) {
        SaldoHigherThanReport report = new SaldoHigherThanReport(valueToCompare);
        for (int i = 0; i < rachunkiBankowe.size(); i++) {
            rachunkiBankowe.get(i).accept(report);
        }
        return report.generateReport();
    }

    public String getPayoffHigherThanReport(double valueToCompare) {
        PayoffHigherThanReport report = new PayoffHigherThanReport(valueToCompare);
        historia.acceptBankOperations(report);
        return report.generateReport();
    }
}

package rachunekBankowy;

import operacjaBankowa.OperacjaBankowa;
import raport.interfaces.IBankAccountReportable;

/**
 * Created by inf113149 on 2016-04-22.
 */
public interface IRachunekBankowy extends IBankAccountReportable{
    boolean wplata(double kwota);
    boolean wyplata(double kwota);
    double getSaldo();
    void setSaldo(double saldo);
    void dodajDoHistorii(OperacjaBankowa operacjaBankowa);
    long getNumerKonta();
    boolean haveDebet();
    IRachunekBankowy getChild();
    String getFullAccountReport();
}

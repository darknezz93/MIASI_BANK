package rachunekBankowy;

import Bank.Debet;
import com.sun.istack.internal.NotNull;
import operacjaBankowa.OperacjaBankowa;

/**
 * Created by inf113149 on 2016-04-22.
 */
public class DebetowyRachunekBankowy implements IRachunekBankowy {

    private IRachunekBankowy opakowanyRachunekBankowy;
    private Debet debet;

    public DebetowyRachunekBankowy(@NotNull IRachunekBankowy opakowanyRachunekBankowy, Debet debet) {
        this.opakowanyRachunekBankowy = opakowanyRachunekBankowy;
        this.debet = debet;
    }


    @Override
    public boolean wplata(double kwota) {
        if (kwota <= 0d) {
            return false;
        }

        double saldoDebetu = debet.getSaldoDebetu();
        if (saldoDebetu > 0) {
            if (kwota < saldoDebetu) {
                debet.odejmijZSalda(kwota);
                return true;
            } else {
                double diff = kwota - saldoDebetu;
                if (opakowanyRachunekBankowy.wplata(diff)) {
                    debet.odejmijZSalda(saldoDebetu);
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return opakowanyRachunekBankowy.wplata(kwota);
        }
    }

    @Override
    public boolean wyplata(double kwota) {
        if (kwota <= 0d) {
            return false;
        }
        double saldo = opakowanyRachunekBankowy.getSaldo();
        double saldoDebet = debet.getSaldoDebetu();
        if (saldo > kwota) {
            return opakowanyRachunekBankowy.wyplata(kwota);
        } else if (debet.getMaksDebet() - saldoDebet > kwota) {
            debet.dodajDoSalda(kwota);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public double getSaldo() {
        return opakowanyRachunekBankowy.getSaldo() - debet.getSaldoDebetu();
    }

    @Override
    public void setSaldo(double saldo) {
        if (saldo >= 0) {
            debet.setSaldoDebetu(0d);
            opakowanyRachunekBankowy.setSaldo(saldo);
        } else {
            opakowanyRachunekBankowy.setSaldo(0d);
            debet.setSaldoDebetu(-saldo);
        }
    }

    @Override
    public void dodajDoHistorii(OperacjaBankowa operacjaBankowa) {
        opakowanyRachunekBankowy.dodajDoHistorii(operacjaBankowa);
    }

    @Override
    public boolean haveDebet() {
        return true;
    }

    @Override
    public IRachunekBankowy getChild() {
        return opakowanyRachunekBankowy;
    }
}

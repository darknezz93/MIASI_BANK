package raport;

import operacjaBankowa.OperacjaBankowaKredyt;
import operacjaBankowa.OperacjaBankowaLokata;
import operacjaBankowa.OperacjaBankowaWplata;
import operacjaBankowa.OperacjaBankowaWyplata;
import raport.interfaces.IBankOperationReportVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by inf113149 on 2016-04-29.
 */
public class PayoffHigherThanReport implements IBankOperationReportVisitor {
    private double valueToCompare;
    private List<OperacjaBankowaWyplata> locals;

    public PayoffHigherThanReport(double valueToCompare) {
        this.valueToCompare = valueToCompare;
        locals = new ArrayList<>();
    }

    @Override
    public void visitOperacjaBankowaKredyt(OperacjaBankowaKredyt operacja) {

    }

    @Override
    public void visitOperacjaBankowaLokata(OperacjaBankowaLokata operacja) {

    }

    @Override
    public void visitOperacjaBankowaWplata(OperacjaBankowaWplata operacja) {

    }

    @Override
    public void visitOperacjaBankowaWyplata(OperacjaBankowaWyplata operacja) {
        if (operacja.getKwota() > valueToCompare) {
            locals.add(operacja);
        }
    }

    public String generateReport() {
        String result = "";
        for (int i = 0; i < locals.size(); i++) {
            result += locals.get(i).getNumerKonta() + "\t" + locals.get(i).getKwota() + "\n";
        }
        return result;
    }
}

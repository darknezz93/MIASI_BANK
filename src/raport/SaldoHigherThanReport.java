package raport;

import rachunekBankowy.DebetowyRachunekBankowy;
import rachunekBankowy.IRachunekBankowy;
import rachunekBankowy.RachunekBankowy;
import raport.interfaces.IBankAccountReportVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by inf113149 on 2016-04-29.
 */
public class SaldoHigherThanReport implements IBankAccountReportVisitor {
    private double valueToCompare;
    private List<IRachunekBankowy> locals;

    public SaldoHigherThanReport(double valueToCompare){
        this.valueToCompare = valueToCompare;
        locals = new ArrayList<>();
    }

    @Override
    public void visitRachunekBankowy(RachunekBankowy rachunekBankowy) {
        if(rachunekBankowy.getSaldo()>valueToCompare){
            locals.add(rachunekBankowy);
        }
    }

    @Override
    public void visitDebetowyRachunekBankowy(DebetowyRachunekBankowy rachunekBankowy) {
        if(rachunekBankowy.getSaldo()>valueToCompare){
            locals.add(rachunekBankowy);
        }
    }

    public String generateReport(){
        String result = "";
        for (int i=0; i<locals.size(); i++){
            result += locals.get(i).getNumerKonta() + "\t" + locals.get(i).getSaldo() + "\n";
        }
        return result;
    }
}

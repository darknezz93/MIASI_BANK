package raport;

import operacjaBankowa.*;
import rachunekBankowy.DebetowyRachunekBankowy;
import rachunekBankowy.IRachunekBankowy;
import rachunekBankowy.RachunekBankowy;
import raport.interfaces.IBankAccountReportVisitor;
import raport.interfaces.IBankOperationReportVisitor;

import java.util.List;

/**
 * Created by inf113149 on 2016-04-29.
 */
public class FullAccountReport implements IBankAccountReportVisitor, IBankOperationReportVisitor {
    private IRachunekBankowy rachunekBankowy;
    private List<OperacjaBankowa> locals;

    @Override
    public void visitRachunekBankowy(RachunekBankowy rachunekBankowy) {
        this.rachunekBankowy = rachunekBankowy;
    }

    @Override
    public void visitDebetowyRachunekBankowy(DebetowyRachunekBankowy rachunekBankowy) {
        this.rachunekBankowy = rachunekBankowy;
    }

    @Override
    public void visitOperacjaBankowaKredyt(OperacjaBankowaKredyt operacja) {
        //TODO
    }

    @Override
    public void visitOperacjaBankowaLokata(OperacjaBankowaLokata operacja) {
        //TODO
    }

    @Override
    public void visitOperacjaBankowaWplata(OperacjaBankowaWplata operacja) {
        locals.add(operacja);
    }

    @Override
    public void visitOperacjaBankowaWyplata(OperacjaBankowaWyplata operacja) {
        locals.add(operacja);
    }

    @Override
    public void visitOperacjaBankowaPrzelew(OperacjaBankowaPrzelew operacja) {
        locals.add(operacja);
    }

    public String generateRerort() {
        String res = "" + rachunekBankowy.getNumerKonta() + "\n" + rachunekBankowy.getSaldo() + "\n\n";
        for (int i = 0; i < locals.size(); i++) {
            OperacjaBankowa operationIth = locals.get(i);
            double sign = operationIth instanceof OperacjaBankowaWyplata ? -1d : 1d;
            res += sign * operationIth.getKwota() + "\n";
        }
        return res;
    }
}

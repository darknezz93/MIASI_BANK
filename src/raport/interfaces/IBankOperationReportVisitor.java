package raport.interfaces;

import operacjaBankowa.OperacjaBankowaKredyt;
import operacjaBankowa.OperacjaBankowaLokata;
import operacjaBankowa.OperacjaBankowaWplata;
import operacjaBankowa.OperacjaBankowaWyplata;
/**
 * Created by inf113149 on 2016-04-29.
 */
public interface IBankOperationReportVisitor {
    void visitOperacjaBankowaKredyt(OperacjaBankowaKredyt operacja);
    void visitOperacjaBankowaLokata(OperacjaBankowaLokata operacja);
    void visitOperacjaBankowaWplata(OperacjaBankowaWplata operacja);
    void visitOperacjaBankowaWyplata(OperacjaBankowaWyplata operacja);
}

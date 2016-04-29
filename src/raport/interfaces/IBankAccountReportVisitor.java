package raport.interfaces;

import rachunekBankowy.DebetowyRachunekBankowy;
import rachunekBankowy.RachunekBankowy;

/**
 * Created by inf113149 on 2016-04-29.
 */
public interface IBankAccountReportVisitor {
    void visitRachunekBankowy(RachunekBankowy rachunekBankowy);
    void visitDebetowyRachunekBankowy(DebetowyRachunekBankowy rachunekBankowy);
}

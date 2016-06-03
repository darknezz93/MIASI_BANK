package operacjaBankowa;

import rachunekBankowy.RachunekBankowy;
import raport.interfaces.IBankOperationReportVisitor;

/**
 * Created by inf113149 on 2016-06-03.
 */
public class OperacjaBankowaPrzelew extends OperacjaBankowa{

    private final RachunekBankowy nadawca;
    private final RachunekBankowy odbiorca;
    private final double kwota;

    public OperacjaBankowaPrzelew(RachunekBankowy nadawca, RachunekBankowy odbiorca, double kwota){
        this.nadawca = nadawca;
        this.odbiorca = odbiorca;
        this.kwota = kwota;
    }

    @Override
    protected boolean operacja() {
        OperacjaBankowaWyplata wyplata = new OperacjaBankowaWyplata(nadawca, kwota);
        OperacjaBankowaWplata wplata = new OperacjaBankowaWplata(odbiorca, kwota);
        boolean res1 = wyplata.wykonajOperacje();
        if(res1){
            boolean res2 = wplata.wykonajOperacje();
            if(res2){
                return true;
            }
        }
        return false;
    }

    @Override
    public double getKwota() {
        return kwota;
    }

    @Override
    public void accept(IBankOperationReportVisitor visitor) {
        visitor.visitOperacjaBankowaPrzelew(this);
    }
}

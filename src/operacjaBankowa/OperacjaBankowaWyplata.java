package operacjaBankowa;

import Bank.Historia;
import Bank.RachunekBankowy;

public class OperacjaBankowaWyplata extends OperacjaBankowa{

	private RachunekBankowy rachunekBankowy;
	private double kwota;
	public OperacjaBankowaWyplata(RachunekBankowy rachunekBankowy){
		this.rachunekBankowy = rachunekBankowy;
	}
	
	@Override
	protected boolean operacja() {
		boolean res = rachunekBankowy.wyplata(kwota);
		if(res){
			rachunekBankowy.dodajDoHistorii(this);
		}
		return res;
	}
	
	public boolean wyplac(double kwota){
		this.kwota = kwota;
		return wykonajOperacje();
	}
}

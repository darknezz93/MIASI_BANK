package operacjaBankowa;

import Bank.Historia;
import Bank.RachunekBankowy;

public class OperacjaBankowaWplata extends OperacjaBankowa{

	private RachunekBankowy rachunekBankowy;
	private double kwota;
	
	
	public OperacjaBankowaWplata(RachunekBankowy rachunekBankowy){
		this.rachunekBankowy = rachunekBankowy;
	}
	
	@Override
	protected boolean operacja() {
		boolean res = rachunekBankowy.wplata(kwota);
		if(res){
			rachunekBankowy.dodajDoHistorii(this);
		}
		return res;
	}
	
	public boolean wplac(double kwota){
		this.kwota = kwota;
		return wykonajOperacje();
	}

}

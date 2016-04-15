package operacjaBankowa;

import Bank.Historia;
import Bank.RachunekBankowy;

public class OperacjaBankowaWplata extends OperacjaBankowa{

	private RachunekBankowy rachunekBankowy;
	private double kwota;
	
	
	public OperacjaBankowaWplata(RachunekBankowy rachunekBankowy, double kwota){
		this.rachunekBankowy = rachunekBankowy;
		this.kwota = kwota;
	}
	
	@Override
	protected boolean operacja() {
		boolean res = wplata(kwota);
		if(res){
			rachunekBankowy.dodajDoHistorii(this);
		}
		return res;
	}

	public boolean wplata(double kwota) {
		if (kwota > 0) {
			rachunekBankowy.setSaldo(rachunekBankowy.getSaldo() + kwota);
			return true;
		}
		return false;
	}
	
	public boolean wplac(double kwota){
		this.kwota = kwota;
		return wykonajOperacje();
	}

}

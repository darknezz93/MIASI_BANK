package operacjaBankowa;

import Bank.Historia;
import Bank.RachunekBankowy;

public class OperacjaBankowaWyplata extends OperacjaBankowa{

	private RachunekBankowy rachunekBankowy;
	private double kwota;
	public OperacjaBankowaWyplata(RachunekBankowy rachunekBankowy, double kwota){

		this.rachunekBankowy = rachunekBankowy;
		this.kwota = kwota;
	}
	
	@Override
	protected boolean operacja() {
		//boolean res = rachunekBankowy.wyplata(kwota);
		boolean res = wyplata(kwota);
		if(res){
			rachunekBankowy.dodajDoHistorii(this);
		}
		return res;
	}

	public boolean wyplata(double kwota) {
		if(kwota<=0){
			return false;
		}

		if (rachunekBankowy.getSaldo() >= kwota || (rachunekBankowy.getDebet() != null || rachunekBankowy.getSaldo() + rachunekBankowy.getDebet().getMaksDebet() > kwota)) {
			rachunekBankowy.setSaldo(rachunekBankowy.getSaldo() - kwota);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean wyplac(double kwota){
		this.kwota = kwota;
		return wykonajOperacje();
	}
}

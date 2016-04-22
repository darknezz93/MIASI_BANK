package operacjaBankowa;

import rachunekBankowy.RachunekBankowy;

public class OperacjaBankowaWplata extends OperacjaBankowa{

	private RachunekBankowy rachunekBankowy;
	private double kwota;
	
	
	public OperacjaBankowaWplata(RachunekBankowy rachunekBankowy, double kwota){
		this.rachunekBankowy = rachunekBankowy;
		this.kwota = kwota;
	}
	
	@Override
	protected boolean operacja() {
		rachunekBankowy.dodajDoHistorii(this);
		return wplata(kwota);
	}

	public boolean wplata(double kwota) {
		return rachunekBankowy.wplata(kwota);
	}
}

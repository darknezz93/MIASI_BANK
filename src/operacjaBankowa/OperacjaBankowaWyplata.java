package operacjaBankowa;

import rachunekBankowy.RachunekBankowy;

public class OperacjaBankowaWyplata extends OperacjaBankowa{

	private RachunekBankowy rachunekBankowy;
	private double kwota;
	public OperacjaBankowaWyplata(RachunekBankowy rachunekBankowy, double kwota){

		this.rachunekBankowy = rachunekBankowy;
		this.kwota = kwota;
	}
	
	@Override
	protected boolean operacja() {
		rachunekBankowy.dodajDoHistorii(this);
		return wyplata(kwota);
	}

	public boolean wyplata(double kwota) {
		return rachunekBankowy.wyplata(kwota);
	}
}

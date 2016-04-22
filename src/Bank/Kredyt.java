package Bank;

import operacjaBankowa.OperacjaBankowaWplata;
import operacjaBankowa.OperacjaBankowaWyplata;

import com.odsetki.OdsetkiKredytowe;
import rachunekBankowy.RachunekBankowy;

public class Kredyt {

	private RachunekBankowy rachunek;
	private OdsetkiKredytowe odsetki;

    public double getKwota() {
        return kwota;
    }

    private double kwota;

	public Kredyt(RachunekBankowy rachunek, double kwota, OdsetkiKredytowe odsetki){
		this.rachunek = rachunek;
		this.odsetki = odsetki;
		this.kwota = kwota;
	}
	
	public boolean wezKredyt(){
		OperacjaBankowaWplata operacja = new OperacjaBankowaWplata(rachunek, kwota);
		return operacja.wykonajOperacje();
	}
	
	public double kwotaDoSplacenia(){
		return odsetki.naliczOdsetki(kwota);
	}
	
	public boolean splacKredyt(double kwota){
        System.out.println(kwotaDoSplacenia());
        System.out.println(kwota);
		if(kwota==kwotaDoSplacenia()){
			OperacjaBankowaWyplata operacja = new OperacjaBankowaWyplata(rachunek, kwota);
			return operacja.wykonajOperacje();
		}
		else{
			return false;
		}
	}
	
}

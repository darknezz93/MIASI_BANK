package operacjaBankowa;
import Bank.Bank;
import Bank.Historia;


public abstract class OperacjaBankowa {
	
	
	public boolean wykonajOperacje() {
		boolean wynik = operacja();
		
		Bank.dodajDoHistoriiBanku(this);
		
		return wynik;
	}

	protected abstract boolean operacja();
	
}

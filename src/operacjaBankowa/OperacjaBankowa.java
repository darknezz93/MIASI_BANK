package operacjaBankowa;
import Bank.Bank;
import raport.interfaces.IBankOperationReportable;


public abstract class OperacjaBankowa implements IBankOperationReportable{
	
	
	public boolean wykonajOperacje() {
		boolean wynik = operacja();
		
		Bank.dodajDoHistoriiBanku(this);
		
		return wynik;
	}

	protected abstract boolean operacja();

	public abstract double getKwota();
	
}

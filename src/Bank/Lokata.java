package Bank;

import java.util.Date;

import com.odsetki.OdsetkiLokata;
import rachunekBankowy.RachunekBankowy;

public class Lokata extends RachunekBankowy {
	private Date dataRozwiazania;
	private boolean czyAktywna;
	private OdsetkiLokata odsetkiLokata;

	public Lokata(long uniqueAccountNumber, OdsetkiLokata odsetkiLokata, double saldo, Date datarozwiazania) {
		super(uniqueAccountNumber);
		this.odsetkiLokata = odsetkiLokata;
		this.dataRozwiazania = datarozwiazania;
		this.czyAktywna = true;
		this.setSaldo(saldo);
	}

	public boolean rozwiazLokate() {
		Date currentDate = new Date(System.currentTimeMillis());
		if(this.czyAktywna && (this.dataRozwiazania.before(currentDate))) {
			this.setSaldo(odsetkiLokata.naliczOdsetki(this.getSaldo()));
			System.out.println("Lokata została rozwiązana pomyślnie.");
			return true;
		} else {
			System.out.println("Lokata została wcześniej zamknięta.");
			return false;
		}
		
	}
	
	public boolean zerwijLokate() {
		if(this.czyAktywna) {
			this.czyAktywna = false;
			return true;
		} else {
			System.out.println("Lokata została wcześniej zamknięta.");
			return false;
		}
	}
	
	
	
}

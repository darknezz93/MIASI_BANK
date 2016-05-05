package Bank;

import java.util.Date;

import com.odsetki.Odsetki;
import com.odsetki.OdsetkiLokata;
import rachunekBankowy.RachunekBankowy;

public class Lokata extends RachunekBankowy {
	private Date dataRozwiazania;
	private boolean czyAktywna;
	private Odsetki odsetki;
    private double oprocentowanie;

	public Lokata(long uniqueAccountNumber, Odsetki odsetki, double saldo, Date datarozwiazania, double oprocentowanie) {
		super(uniqueAccountNumber);
		this.odsetki= odsetki;
		this.dataRozwiazania = datarozwiazania;
		this.czyAktywna = true;
        this.oprocentowanie = oprocentowanie;
		this.setSaldo(saldo);
	}

	public boolean rozwiazLokate() {
		Date currentDate = new Date(System.currentTimeMillis());
        //odsetki.setState(new OdsetkiLokata(oprocentowanie));
		if(this.czyAktywna && (this.dataRozwiazania.before(currentDate))) {
			this.setSaldo(odsetki.naliczOdsetki(this.getSaldo()));
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


	@Override
	public long getNumerKonta() {
		return super.getNumerKonta();
	}
}

package rachunekBankowy;

import java.util.Date;

import Bank.Debet;
import Bank.Historia;
import operacjaBankowa.OperacjaBankowa;

public class RachunekBankowy implements IRachunekBankowy{
	
	public long numerRachunku;
	private Date dataZalozenia;
	private double saldo;
	private Debet debet;
	private Historia historia;

	public RachunekBankowy(long uniqueAccountNumber){
		numerRachunku = uniqueAccountNumber;
		dataZalozenia = new Date(System.currentTimeMillis());
		saldo = 0;
		historia = new Historia();
	}

	
	public boolean wyplata(double kwota) {
		if(kwota<=0){
			return false;
		}

		if (saldo >= kwota || (debet != null || saldo + debet.getMaksDebet() > kwota)) {
			saldo -= kwota;
			return true;
		} else {
			return false;
		}
	}

	public boolean wplata(double kwota) {
		if (kwota > 0) {
			this.saldo += kwota;
			return true;
		}
		return false;
	}

	public Debet getDebet() {
		return debet;
	}

	public void setDebet(Debet debet) {
		this.debet = debet;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Historia getHistoria() {
		return historia;
	}

	public void dodajDoHistorii(OperacjaBankowa operacjaBankowa){
		historia.dodajElement(operacjaBankowa);
	}

	@Override
	public long getNumerKonta() {
		return numerRachunku;
	}

	@Override
	public boolean haveDebet() {
		return false;
	}

	@Override
	public IRachunekBankowy getChild() {
		return null;
	}


}

package Bank;

public class Debet {

	private double maksDebet;
	private double saldoDebetu = 0d;

	public Debet(double maksDebet) {
		this.maksDebet = maksDebet;
	}

	public double getMaksDebet() {
		return maksDebet;
	}

	public double getSaldoDebetu() {
		return saldoDebetu;
	}

	public void dodajDoSalda(double kwota){
		saldoDebetu+=kwota;
	}

	public void odejmijZSalda(double kwota){
		saldoDebetu-=kwota;
	}

	public void setSaldoDebetu(double saldoDebetu) {
		this.saldoDebetu = saldoDebetu;
	}
}

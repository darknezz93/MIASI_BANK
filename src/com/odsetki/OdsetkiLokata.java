package com.odsetki;

public class OdsetkiLokata implements OdsetkiState {
	private double oprocentowanie;
	
	public OdsetkiLokata(double oprocentowanie){
		this.oprocentowanie = oprocentowanie;
	}
	
	/*@Override
	public double naliczOdsetki(Double kwota) {
		return (kwota + kwota*oprocentowanie/100);
	}*/

	public double naliczOdsetki(Double kwota) {
		return (kwota + kwota*oprocentowanie/100);
	}
	

}

package com.odsetki;

import Bank.Historia;

public class OdsetkiKredytowe implements OdsetkiState {
	
	private double oprocentowanie;
	
	public OdsetkiKredytowe(double oprocentowanie){
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

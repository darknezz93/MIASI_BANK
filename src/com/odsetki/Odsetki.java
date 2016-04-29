package com.odsetki;

public class Odsetki {

	//double naliczOdsetki(Double kwota);

	private OdsetkiState state;

	public OdsetkiState getState() {
		return state;
	}

	public void setState(OdsetkiState state) {
		this.state = state;
	}

	public double naliczOdsetki(Double kwota) {
		if (state != null) {
			return state.naliczOdsetki(kwota);
		} else {
			System.out.println("status unknown");
		}
		return 0;
	}
}

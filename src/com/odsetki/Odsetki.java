package com.odsetki;

public class Odsetki {

	//double naliczOdsetki(Double kwota);


    private double kwota;

	private OdsetkiState state;

	public OdsetkiState getState() {
		return state;
	}

	public void setState(OdsetkiState state) {
		this.state = state;
	}

	public double naliczOdsetki(Double kwota) {
        double result = 0;
		if(state != null) {
            result = state.naliczOdsetki(kwota);
        } else {
            System.out.println("Unknown state");
        }
        return result;
	}
}

package Bank;
import java.util.ArrayList;
import java.util.List;

import operacjaBankowa.OperacjaBankowa;

public class Historia {
	
	private List<OperacjaBankowa> operacje = new ArrayList<>();

	public void dodajElement(OperacjaBankowa operacja) {
		operacje.add(operacja);
	}

	public boolean czyZawiera(OperacjaBankowa operacja){
		return operacje.contains(operacja);
	}
}

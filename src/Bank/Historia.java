package Bank;
import java.util.ArrayList;
import java.util.List;

import operacjaBankowa.OperacjaBankowa;
import raport.interfaces.IBankOperationReportVisitor;

public class Historia {
	
	private List<OperacjaBankowa> operacje = new ArrayList<>();

	public void dodajElement(OperacjaBankowa operacja) {
		operacje.add(operacja);
	}

	public boolean czyZawiera(OperacjaBankowa operacja){
		return operacje.contains(operacja);
	}

	public void acceptBankOperations(IBankOperationReportVisitor visitor){
		for(int i=0; i<operacje.size(); i++){
			operacje.get(i).accept(visitor);
		}
	}
}

package Bank;

import rachunekBankowy.RachunekBankowy;

import java.util.ArrayList;
import java.util.List;

public class Raport {


    public List<RachunekBankowy> pobierzRachunkiSaldoWiekszeRowne(Bank bank, double saldo) {
        List<RachunekBankowy> rachunki = bank.getRachunkiBankowe();
        List<RachunekBankowy> rachunkiWynikowe = new ArrayList<RachunekBankowy>();

        for (int i = 0; i < rachunki.size(); i++) {
            if (rachunki.get(i).getSaldo() >= saldo) {
                rachunkiWynikowe.add(rachunki.get(i));
            }
        }
        return rachunkiWynikowe;
    }

    public List<RachunekBankowy> pobierzRachunkiSaldoMniejsze(Bank bank, double saldo) {
        List<RachunekBankowy> rachunki = bank.getRachunkiBankowe();
        List<RachunekBankowy> rachunkiWynikowe = new ArrayList<RachunekBankowy>();

        for (int i = 0; i < rachunki.size(); i++) {
            if (rachunki.get(i).getSaldo() < saldo) {
                rachunkiWynikowe.add(rachunki.get(i));
            }
        }
        return rachunkiWynikowe;
    }


    public RachunekBankowy pobierzRachunekONajwiekszymSaldzie(Bank bank) {
        List<RachunekBankowy> rachunki = bank.getRachunkiBankowe();


        if (rachunki.size() > 0) {
            RachunekBankowy najwiekszyRachunek = rachunki.get(0);

            for (int i = 1; i < rachunki.size(); i++) {
                if (rachunki.get(i).getSaldo() > najwiekszyRachunek.getSaldo()) {
                    najwiekszyRachunek = rachunki.get(i);
                }
            }
            return najwiekszyRachunek;
        }
        return null;
    }


}

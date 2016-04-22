package Bank;

import rachunekBankowy.IRachunekBankowy;
import rachunekBankowy.RachunekBankowy;

import java.util.ArrayList;
import java.util.List;

public class Raport {


    public List<IRachunekBankowy> pobierzRachunkiSaldoWiekszeRowne(Bank bank, double saldo) {
        List<IRachunekBankowy> rachunki = bank.getRachunkiBankowe();
        List<IRachunekBankowy> rachunkiWynikowe = new ArrayList<>();

        for (int i = 0; i < rachunki.size(); i++) {
            if (rachunki.get(i).getSaldo() >= saldo) {
                rachunkiWynikowe.add(rachunki.get(i));
            }
        }
        return rachunkiWynikowe;
    }

    public List<IRachunekBankowy> pobierzRachunkiSaldoMniejsze(Bank bank, double saldo) {
        List<IRachunekBankowy> rachunki = bank.getRachunkiBankowe();
        List<IRachunekBankowy> rachunkiWynikowe = new ArrayList<>();

        for (int i = 0; i < rachunki.size(); i++) {
            if (rachunki.get(i).getSaldo() < saldo) {
                rachunkiWynikowe.add(rachunki.get(i));
            }
        }
        return rachunkiWynikowe;
    }


    public IRachunekBankowy pobierzRachunekONajwiekszymSaldzie(Bank bank) {
        List<IRachunekBankowy> rachunki = bank.getRachunkiBankowe();


        if (rachunki.size() > 0) {
            IRachunekBankowy najwiekszyRachunek = rachunki.get(0);

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

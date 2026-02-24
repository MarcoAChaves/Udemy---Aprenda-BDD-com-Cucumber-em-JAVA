package services;

import entities.Filme;
import entities.NotaAluguel;

import java.util.Calendar;

public class AluguelService {

    public NotaAluguel alugar(Filme filme) {
        NotaAluguel nota = new NotaAluguel();
        nota.setPreco(filme.getAuguel());
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        nota.setDataEntrega(cal.getTime());
        filme.setEstoque(filme.getEstoque()-1);
        return nota;
    }
}

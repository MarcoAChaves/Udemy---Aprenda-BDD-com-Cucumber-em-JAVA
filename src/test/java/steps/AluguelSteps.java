package steps;

import entities.Filme;
import entities.NotaAluguel;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import services.AluguelService;

import java.util.Calendar;
import java.util.Date;

public class AluguelSteps {
    private Filme filme;
    private AluguelService aluguel = new AluguelService();
    private NotaAluguel nota;

    @Dado("um filme com estoque de {int} unidades")
    public void um_filme_com_estoque_de_unidades(int int1) {
        filme = new Filme();
        filme.setEstoque(int1);
    }

    @Dado("que o preço do aluguel seja R$ {int}")
    public void que_o_preço_do_aluguel_seja_r$(int int1) {
        filme.setAluguel(int1);
    }

    @Quando("alugar")
    public void alugar() {
        nota = aluguel.alugar(filme);
    }

    @Entao("o preço do  aluguel será R$ {int}")
    public void o_preço_do_aluguel_será_r$(int int1) {
        Assert.assertEquals(int1, nota.getPreco());
    }

    @Entao("a data de entrega será no dia seguinte")
    public void a_data_de_entrega_será_no_dia_seguinte() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);

        Date dataRetorno = nota.getDataEntrega();
        Calendar calRetorno = Calendar.getInstance();
        calRetorno.setTime(dataRetorno);

        Assert.assertEquals(cal.get(Calendar.DAY_OF_MONTH), calRetorno.get(Calendar.DAY_OF_MONTH));
        Assert.assertEquals(cal.get(Calendar.MONTH), calRetorno.get(Calendar.MONTH));
        Assert.assertEquals(cal.get(Calendar.YEAR), calRetorno.get(Calendar.YEAR));

    }

    @Entao("o estoque do filme será {int} unidade")
    public void o_estoque_do_filme_será_unidade(int int1) {
        Assert.assertEquals(int1, filme.getEstoque());
    }

}


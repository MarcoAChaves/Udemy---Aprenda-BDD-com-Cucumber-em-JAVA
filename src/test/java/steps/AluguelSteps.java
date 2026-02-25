package steps;

import entities.Filme;
import entities.NotaAluguel;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import services.AluguelService;
import utils.DateUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AluguelSteps {
    private Filme filme;
    private AluguelService aluguel = new AluguelService();
    private NotaAluguel nota;
    private String erro;
    private String tipoAluguel;

    @Dado("^um filme com estoque de (\\d+) unidades$")
    public void filme_com_estoque_de_unidades(int arg1) throws Throwable {
        filme = new Filme();
        filme.setEstoque(arg1);
    }

    @Dado("^que o preço do aluguel seja R\\$ (\\d+)$")
    public void que_o_preço_do_aluguel_seja_r$(int arg1) throws Throwable {
        filme.setAluguel(arg1);
    }

    @Quando("^alugar$")
    public void alugar() throws Throwable {
        try {
            nota = aluguel.alugar(filme, tipoAluguel);
        } catch (RuntimeException e) {
            erro = e.getMessage();
        }
    }

    @Entao("^o preço do aluguel será R\\$ (\\d+)$")
    public void o_preço_do_aluguel_será_r$(int arg1) throws Throwable {
        Assert.assertEquals(arg1, nota.getPreco());
    }

    @Entao("^o estoque do filme será (\\d+) unidade$")
    public void o_estoque_do_filme_será_unidade(int arg1) throws Throwable {
        Assert.assertEquals(arg1, filme.getEstoque());
    }

    @Entao("^não será possivel por falta de estoque$")
    public void não_será_possivel_por_falta_de_estoque() throws Throwable {
        Assert.assertEquals("Filme sem Estoque", erro);
    }

    @Dado("^que o tipo do aluguel seja (.*)$")
    public void que_o_tipo_do_aluguel_seja_extendido(String tipo) throws Throwable{
        tipoAluguel = tipo;
    }

    @Entao("^a data de entrega será em (\\d+) dias?$")
    public void a_data_de_entrega_será_em_dias(int arg1)throws Throwable{
        Date dataEsperada = DateUtils.obterDataDiferencaDias(arg1);
        Date dataReal = nota.getDataEntrega();

        DateFormat format = new SimpleDateFormat("dd,MM,yyyy");
        Assert.assertEquals(format.format(dataEsperada), format.format(dataReal));
    }

    @Entao("^a pontuação recebida será de (\\d+) pontos$")
    public void a_pontuação_recebida_será_de_pontos(int arg1)throws Throwable{
        Assert.assertEquals(arg1, nota.getPontuacao());
    }
}


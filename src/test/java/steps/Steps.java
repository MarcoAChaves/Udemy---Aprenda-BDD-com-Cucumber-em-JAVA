package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Steps {

    @Given("criei o arquivo corretamente")
    public void criei_o_arquivo_corretamente() throws Throwable {
        System.out.println("passou aqui");
    }

    @When("executar o teste")
    public void executar_o_teste() throws Throwable {

    }

    @Then("a especificacao deve finalizar com sucesso")
    public void a_especificacao_deve_finalizar_com_sucesso() throws Throwable {

    }

    private int contador = 0;

    @Given("o valor do contador e {int}")
    public void o_valor_do_contador_e(int int1) throws Throwable {
        contador = int1;
    }

    @When("eu encrementar em {int}")
    public void eu_encrementar_em(int int1) throws Throwable {
        contador = contador + int1;
    }

    @Then("o valor do contador sera {int}")
    public void o_valor_do_contador_sera(int int1) throws Throwable {
        System.out.println(int1);
        System.out.println(contador);
        Assert.assertTrue(int1 == contador);
    }

    Date entrega = new Date();

    @Given("que a entrega seria dia {int}\\/{int}\\/{int}")
    public void que_a_entrega_seria_dia(int int1, Integer int2, Integer int3) throws Throwable {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, int1);
        cal.set(Calendar.MONTH, int2 - 1);
        cal.set(Calendar.YEAR, int3);
        entrega = cal.getTime();
    }

    @When("a entrega atrasa em (\\d+) (dia|dias|mes|meses)$")
    public void a_entrega_atrasa_em_dias(int int1, String tempo) throws Throwable {
        Calendar cal = Calendar.getInstance();
        cal.setTime(entrega);
        if (tempo.equals("dias")) {
            cal.add(Calendar.DAY_OF_MONTH, int1);
        }
        if (tempo.equals("meses")) {
            cal.add(Calendar.MONTH, int1);
        }
        entrega = cal.getTime();
    }

    @Then("a entrega sera feita no dia (\\d{2}\\/\\d{2}\\/\\d{4})$")
    public void a_entrega_sera_feita_no_dia(String data) throws Throwable {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = format.format(entrega);
        Assert.assertEquals(data, dataFormatada);
    }

    @Given("^o ticket( especial)? é (A.\\d{3})$")
    public void o_ticket_é_af(String tipo, String arg1) throws Throwable {
    }

    @Given("^o valor da passagem é R\\$ (\\d+),(\\d+)$")
    public void o_valor_da_passagem_é_r$(int int1, int int2) throws Throwable {
    }

    @Given("o nome do passageiro é \"(.{5,20})\"$")
    public void o_nome_do_passageiro_é(String string) throws Throwable {

    }

    @Given("o telefone do passageiro é (9\\d{3}-\\d{4})$")
    public void o_telefone_do_passageiro_é(String telefone) throws Throwable {
    }

    @When("criar os steps")
    public void criar_os_steps() throws Throwable {
    }

    @Then("o teste vai funcionar")
    public void o_teste_vai_funcionar() throws Throwable {
    }
}
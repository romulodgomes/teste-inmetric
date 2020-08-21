package br.com.inmetrics.teste.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;

import br.com.inmetrics.teste.pageobjects.CadastroFuncionarioPO;
import br.com.inmetrics.teste.pageobjects.FuncionariosPO;
import br.com.inmetrics.teste.support.DriverFactory;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class FuncionarioSteps {
	private FuncionariosPO funcionarioPage = PageFactory.initElements(DriverFactory.getChromeDriver(), FuncionariosPO.class);
	private CadastroFuncionarioPO cadastroFuncionarioPage = PageFactory.initElements(DriverFactory.getChromeDriver(), CadastroFuncionarioPO.class);
	private Integer totalFuncionarios;
	private Integer totalFuncionariosAposExclusao;
	
	@Quando("que eu clico no botão Novo Funcionário")
	public void que_eu_clico_no_botão_novo_funcionário() {
		funcionarioPage.clickNovoFuncionario();
	}

	@Então("o sistema apresenta a tela de cadastro de funcionário")
	public void o_sistema_apresenta_a_tela_de_cadastro_de_funcionário() {
		cadastroFuncionarioPage.verificarExibicao();
	}

	@Quando("eu preencho o campo Nome com {string}")
	public void eu_preencho_o_campo_nome_com(String nome) {
		cadastroFuncionarioPage.preencherNome(nome);
	}

	@Quando("eu preencho o campo CPF com {string}")
	public void eu_preencho_o_campo_cpf_com(String cpf) {
		cadastroFuncionarioPage.preencherCPF(cpf);
	}

	@Quando("eu preencho o campo Cargo com {string}")
	public void eu_preencho_o_campo_cargo_com(String cargo) {
		cadastroFuncionarioPage.preencherCargo(cargo);
	}

	@Quando("eu preencho o campo Salário com {string}")
	public void eu_preencho_o_campo_salário_com(String salario) {
		cadastroFuncionarioPage.preencherSalario(salario);
	}

	@Quando("eu seleciono o campo Sexo com {string}")
	public void eu_seleciono_o_campo_sexo_com(String sexo) {
		cadastroFuncionarioPage.selecionarSexo(sexo);
	}

	@Quando("eu marco o Tipo de Contratação {string}")
	public void eu_marco_o_tipo_de_contratação(String tipo) {
	    cadastroFuncionarioPage.marcarTipoContratacao(tipo);
	}

	@Quando("eu preencho o campo Admissão com {string}")
	public void eu_preencho_o_campo_admissão_com(String dataAdmissao) {
	    cadastroFuncionarioPage.preencherAdmissao(dataAdmissao);
	}

	@Quando("eu clico no botão Enviar")
	public void eu_clico_no_botão_enviar() {
		cadastroFuncionarioPage.clickEnviar();
	}
	
	@Entao("o sistema apresenta a mensagem de sucesso {string}")
	public void o_sistema_apresenta_a_mensagem_de_sucesso(String msg) {
		funcionarioPage.verificarMensagemSucesso(msg);
	}
	
	@Entao("o sistema apresenta a listagem de funcionários")
	public void o_sistema_apresenta_a_listagem_de_funcionários() {
		funcionarioPage.verificarExibicaoTabela();
	}

	@Quando("eu clico no botão Excluir Funcionário do primeiro funcionário da lista")
	public void eu_clico_no_botão_excluir_funcionário_do_primeiro_funcionário_da_lista() {
		totalFuncionarios = funcionarioPage.getTotalFuncionarios();
		funcionarioPage.clickExcluirPrimeiroRegistro();
		totalFuncionariosAposExclusao = funcionarioPage.getTotalFuncionarios();
	}

	@Entao("o sistema remove o primeiro funcionário da lista de funcionários")
	public void o_sistema_remove_o_primeiro_funcionário_da_lista_de_funcionários() {
		assertTrue("Usuário não foi excluido", totalFuncionarios > totalFuncionariosAposExclusao);
	}

	@Quando("eu clico no botão Editar Funcionário do primeiro funcionário da lista")
	public void eu_clico_no_botão_editar_funcionário_do_primeiro_funcionário_da_lista() {
		funcionarioPage.clickEditarPrimeiroRegistro();
	}

	@Quando("eu altero o nome do usuário para {string}")
	public void eu_altero_o_nome_do_usuário_para(String nome) {
		cadastroFuncionarioPage.alterarNome(nome);
	}
}

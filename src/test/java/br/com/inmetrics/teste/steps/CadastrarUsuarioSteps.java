package br.com.inmetrics.teste.steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.openqa.selenium.support.PageFactory;

import br.com.inmetrics.teste.pageobjects.CadastreSePO;
import br.com.inmetrics.teste.pageobjects.LoginPO;
import br.com.inmetrics.teste.support.DriverFactory;
import br.com.inmetrics.teste.support.GetTimeExecution;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class CadastrarUsuarioSteps {
	private LoginPO loginPage;
	private CadastreSePO cadastreSePage = PageFactory.initElements( DriverFactory.getChromeDriver(), CadastreSePO.class);
	private DateFormat format = new SimpleDateFormat("ddMMyyyyHHmmss");
	
	
	@Dado("que acessei a url {string}")
	public void que_acessei_a_url(String url) {
	   DriverFactory.getChromeDriver().get(url);
	   loginPage = PageFactory.initElements( DriverFactory.getChromeDriver(), LoginPO.class);
	}

	@Quando("eu clico no botao Cadastre-se no navbar")
	public void eu_clico_no_botao_cadastre_se_no_navbar() {
		loginPage.cliqueCadastreSeNav();
		cadastreSePage = PageFactory.initElements( DriverFactory.getChromeDriver(), CadastreSePO.class);
	}

	@Entao("o sistema apresenta a página de cadastro do usuário")
	public void o_sistema_apresenta_a_página_de_cadastro_do_usuário() {
		cadastreSePage.verificarTitulo();
	}
	
	@Quando("eu clico no botao Cadastre-se no container")
	public void eu_clico_no_botao_cadastre_se_no_container() {
		loginPage.cliqueCadastreSeContainer();
		cadastreSePage = PageFactory.initElements( DriverFactory.getChromeDriver(), CadastreSePO.class);
	}
	
	@Quando("eu preencho o nome do usuário {string}")
	public void eu_preencho_o_nome_do_usuário(String user) {
		cadastreSePage.preencherUsuario(user + format.format(GetTimeExecution.getTime()));
	}

	@Quando("eu preencho a senha {string}")
	public void eu_preencho_a_senha(String password) {
		cadastreSePage.preencherSenha(password);
	}

	@Quando("eu preencho a confirmação da senha {string}")
	public void eu_preencho_a_confirmação_da_senha(String password) {
		cadastreSePage.preencherConfirmacaoPassword(password);
	}

	@Quando("clico no botão cadastrar")
	public void clico_no_botão_cadastrar() {
		cadastreSePage.cliqueBotaoCadastrar();
	}

	@Entao("o sistema apresenta a página de login")
	public void o_sistema_apresenta_a_página_de_login() {
		loginPage.verificarTitulo();
	}

	@Entao("o sistema apresenta mensagem de sucessos")
	public void o_sistema_apresenta_mensagem_de_sucessos() {
	    throw new AssertionError("Essa mensagem não foi implementada");
	}
	
	@Entao("o sistema apresenta a mensagem {string}")
	public void o_sistema_apresenta_a_mensagem(String string) {
		cadastreSePage.verificarMensagem(string);  
	}

}

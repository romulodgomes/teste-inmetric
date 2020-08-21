package br.com.inmetrics.teste.steps;

import org.openqa.selenium.support.PageFactory;

import br.com.inmetrics.teste.pageobjects.LoginPO;
import br.com.inmetrics.teste.support.DriverFactory;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class LoginSteps {
	LoginPO loginPage = PageFactory.initElements( DriverFactory.getChromeDriver(), LoginPO.class);
	
	@Quando("clico no botão Entre")
	public void clico_no_botão_entre() {
		loginPage.cliqueEntrar();
	}

	@Entao("o sistema apresenta a listagem de funcionarios")
	public void o_sistema_apresenta_a_listagem_de_funcionarios() {
	   
	}
}

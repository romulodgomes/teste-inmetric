package br.com.inmetrics.teste.pageobjects;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPO {
	@FindBy(name = "username")
	private WebElement username;
	
	@FindBy(name = "pass")
	private WebElement pass;
	
	@FindBy(css = ".login100-form-btn")
	protected WebElement buttonEntre;
	
	@FindBy(css = "[href=\"/accounts/signup/\"]")
	private List<WebElement> linkCadastreSe;
	
	@FindBy(css = ".login100-form-title")
	protected WebElement titulo;

	public void cliqueCadastreSeNav() {
		linkCadastreSe.get(0).click();
	}

	public void cliqueCadastreSeContainer() {
		linkCadastreSe.get(1).click();
	}

	public void verificarTitulo() {
		assertTrue("A página de login não foi apresentada", titulo.getText().trim().toUpperCase().equals("LOGIN"));
	}
	
	public void preencherUsuario(String user) {
		username.sendKeys(user);
	}
	
	public void preencherSenha(String password) {
		pass.sendKeys(password);
	}
	
	public void cliqueEntrar() {
		buttonEntre.click();
	}
}

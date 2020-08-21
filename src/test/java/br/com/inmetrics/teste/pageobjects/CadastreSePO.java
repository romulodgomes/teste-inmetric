package br.com.inmetrics.teste.pageobjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CadastreSePO extends LoginPO {
	
	@FindBy(name = "confirmpass")
	private WebElement confirmpass;
	
	@FindBy(tagName = "form")
	private WebElement formulario;

	public void verificarTitulo() {
		assertTrue("A página de cadastro não foi apresentada", titulo.getText().trim().toUpperCase().equals("CADASTRE-SE"));
	}
	
	public void preencherConfirmacaoPassword(String password) {
		confirmpass.sendKeys(password);
	}

	public void cliqueBotaoCadastrar() {
		buttonEntre.click();
		
	}

	public void verificarMensagem(String string) {
		assertTrue(formulario.getText().contains(string));
	}
}

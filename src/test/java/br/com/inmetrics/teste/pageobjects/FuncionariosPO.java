package br.com.inmetrics.teste.pageobjects;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FuncionariosPO {
	
	private WebElement tabela;
	private WebElement tabela_info;

	@FindBy(css = ".alert")
	private WebElement mensagem;
	
	
	@FindBy(css = "#delete-btn")	
	private List<WebElement> listButtonExcluirFuncionario;
	
	@FindBy(css = "[href^=\"/empregados/edit/\"]")
	private List<WebElement> listButtonEditarFuncionario;
	
	
	@FindBy(css = "[href=\"/empregados/new_empregado\"]")
	private WebElement linkNovoFuncionario;
	
	public void verificarExibicaoTabela(){
		assertTrue("Sistema não apresentou a tela de funcionarios",tabela.isDisplayed());
	}
	
	public void clickNovoFuncionario() {
		linkNovoFuncionario.click();
	}
	
	public void verificarMensagemSucesso(String msg) {
		assertTrue("Mensagem de sucesso não foi apresentada, ou está incorreta. Mensagem esperada: "+ msg + "Mensagem atual: " + mensagem.getText(),mensagem.getText().contains(msg));
	}

	public void clickExcluirPrimeiroRegistro() {
		listButtonExcluirFuncionario.get(0).click();
	}

	public Integer getTotalFuncionarios() {
		String texto = tabela_info.getText().trim();
		String[] textoSeparado = texto.split(" ");
		String textoQuantidadeFuncionarios = textoSeparado[textoSeparado.length-1];
		
		return Integer.valueOf(textoQuantidadeFuncionarios);
	}

	public void clickEditarPrimeiroRegistro() {
		listButtonEditarFuncionario.get(0).click();
	}
	
}

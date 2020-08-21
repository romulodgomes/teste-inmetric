package br.com.inmetrics.teste.pageobjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CadastroFuncionarioPO {
	
	@FindBy(css = ".wrap-cadastro100")
	private WebElement areaFormulario;
	private WebElement inputNome;
	private WebElement inputCargo;
	private WebElement cpf;
	private WebElement clt;
	private WebElement pj;
	private WebElement inputAdmissao;

	@FindBy(name = "sexo")
	private WebElement sexo;

	@FindBy(name = "salario")
	private WebElement salario;
	
	@FindBy(css = "input[type=\"submit\"]")
	private WebElement buttonEnviar;
	
	@FindBy(css = "input[value=\"Cancelar\"]")
	private WebElement buttonCancelar;	
	
	public void preencherNome(String nome) {
		inputNome.sendKeys(nome);
	}
	
	public void preencherCargo(String cargo) {
		inputCargo.sendKeys(cargo);
	}
	
	public void preencherCPF(String cpf) {
		this.cpf.sendKeys(cpf);
	}
	
	public void preencherSalario(String salario) {
		this.salario.sendKeys(salario);
	}
	
	public void selecionarSexo(String sexo) {
		Select selectSexo = new Select(this.sexo);
		selectSexo.selectByVisibleText(sexo);
	}
	
	public void marcarTipoContratacao(String tipo) {
		if(tipo.trim().toLowerCase().equals("clt")) {
			clt.click();
		}
		else if(tipo.trim().toLowerCase().equals("pj")) {
			pj.click();
		}
		else throw new RuntimeException("Tipo de Contratação invalido");
	}
	
	public void preencherAdmissao(String dataAdmissao) {
		this.inputAdmissao.sendKeys(dataAdmissao);
	}
	
	public void clickEnviar() {
		buttonEnviar.click();
	}
	
	public void clickCancelar() {
		buttonCancelar.click();
	}

	public void verificarExibicao() {
		assertTrue("Formulário de cadastro de funcionario não foi apresentado", areaFormulario.isDisplayed());
	}

	public void alterarNome(String nome) {
		inputNome.clear();
		inputNome.sendKeys(nome);
	}
}

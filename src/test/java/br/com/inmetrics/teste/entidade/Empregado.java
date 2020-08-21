package br.com.inmetrics.teste.entidade;

public class Empregado {
	public Integer empregadoId;
	public String admissao;
	public String cargo;
	public String comissao;
	public String cpf;
	public String departamentoId;
	public String nome;
	public String salario;
	public String sexo;
	public String tipoContratacao;
	public Acesso acesso;
	
	public String getAdmissao() {
		return admissao;
	}
	
	public void setAdmissao(String admissao) {
		this.admissao = admissao;
	}
	
	public String getCargo() {
		return cargo;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public String getComissao() {
		return comissao;
	}
	
	public void setComissao(String comissao) {
		this.comissao = comissao;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getDepartamentoId() {
		return departamentoId;
	}
	
	public void setDepartamentoId(String departamentoId) {
		this.departamentoId = departamentoId;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSalario() {
		return salario;
	}
	
	public void setSalario(String salario) {
		this.salario = salario;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getTipoContratacao() {
		return tipoContratacao;
	}
	
	public void setTipoContratacao(String tipoContratacao) {
		this.tipoContratacao = tipoContratacao;
	}	
}

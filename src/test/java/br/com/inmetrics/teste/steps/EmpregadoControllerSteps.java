package br.com.inmetrics.teste.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.json.simple.JSONObject;

import br.com.inmetrics.teste.entidade.Empregado;
import br.com.inmetrics.teste.pageobjects.EmpregadoControllerPO;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class EmpregadoControllerSteps {

	private EmpregadoControllerPO empregadoControllerPO = new EmpregadoControllerPO();
	private List<Empregado> listaEmpregados;
	private Empregado empregadoEditado;

	@Dado("que a URL Base da api é {string}")
	public void que_a_url_base_da_api_é(String url) {
		empregadoControllerPO.setBaseUrl(url);
	}

	@Dado("que eu crio um json para criar um empregado")
	public void que_eu_crio_um_json_para_criar_um_empregado() {
		empregadoControllerPO.setPostEmpregadoJson(new JSONObject());
	}

	@Dado("preencho a admissao do empregado {string}")
	public void preencho_a_admissao_do_empregado(String admissao) {
		empregadoControllerPO.getPostEmpregadoJson().put("admissao", admissao);
	}

	@Dado("preencho o cargo do empregado {string}")
	public void preencho_o_cargo_do_empregado(String cargo) {
		empregadoControllerPO.getPostEmpregadoJson().put("cargo", cargo);
	}

	@Dado("preencho a comissão do empregado {string}")
	public void preencho_a_comissão_do_empregado(String comissao) {
		empregadoControllerPO.getPostEmpregadoJson().put("comissao", comissao);
	}

	@Dado("preencho o cpf do empregado {string}")
	public void preencho_o_cpf_do_empregado(String cpf) {
		empregadoControllerPO.getPostEmpregadoJson().put("cpf", cpf);
	}

	@Dado("preencho o departamentoId do empregado {string}")
	public void preencho_o_departamento_id_do_empregado(String departamentoId) {
		empregadoControllerPO.getPostEmpregadoJson().put("departamentoId", departamentoId);
	}

	@Dado("preencho o nome do empregado {string}")
	public void preencho_o_nome_do_empregado(String nome) {
		empregadoControllerPO.getPostEmpregadoJson().put("nome", nome);
	}

	@Dado("preencho o salario do empregado {string}")
	public void preencho_o_salario_do_empregado(String salario) {
		empregadoControllerPO.getPostEmpregadoJson().put("salario", salario);
	}

	@Dado("preencho o sexo do empregado {string}")
	public void preencho_o_sexo_do_empregado(String sexo) {
		empregadoControllerPO.getPostEmpregadoJson().put("sexo", sexo);
	}

	@Dado("preencho o tipoContratacao do empregado {string}")
	public void preencho_o_tipo_contratacao_do_empregado(String tipoContratacao) {
		empregadoControllerPO.getPostEmpregadoJson().put("tipoContratacao", tipoContratacao);
	}

	@Quando("executo a requisição do tipo post")
	public void executo_a_requisição_do_tipo_post() {
		empregadoControllerPO.criarEmpregado();
	}

	@Então("o codigo da resposta da api deve ser {string}")
	public void o_codigo_da_resposta_da_api_deve_ser(String code) {
		assertEquals(
				"Codigo da resposta do webserver diferente do esperado. Codigo: "
						+ empregadoControllerPO.getPostEmpregadoResponse().getStatusCode(),
				code, String.valueOf(empregadoControllerPO.getPostEmpregadoResponse().getStatusCode()));
	}

	@Então("a resposta deve conter um Json com os dados do usuário criado")
	public void a_resposta_deve_conter_um_json_com_os_dados_do_usuário_criado() {
		assertTrue(
				"Não foi devidamente cadastrado um empregado. Json da resposta:\n"
						+ empregadoControllerPO.getPostEmpregadoResponse().getBody(),
				empregadoControllerPO.getEmpregadoId() > 0);
	}

	@Dado("que eu cadastrei um empregado")
	public void que_eu_cadastrei_um_empregado() {
		empregadoControllerPO.getEmpregadoCadastrado();
	}

	@Quando("executo a requisição do tipo get no path {string}, junto ao id de um empregado")
	public void executo_a_requisição_do_tipo_get_no_path_junto_ao_id_de_um_empregado(String path) {
		empregadoControllerPO.consultaEmpregado(path);
	}

	@Então("a resposta do servidor deve conter um Json com os dados do usuário pesquisado")
	public void a_resposta_do_servidor_deve_conter_um_json_com_os_dados_do_usuário_pesquisado() {
		assertTrue(empregadoControllerPO.getGetEmpregadoCadastrado().jsonPath().getString("nome").contains("Teste"));
	}

	@Quando("executo a requisição do tipo get no path {string}")
	public void executo_a_requisição_do_tipo_get_no_path(String path) {
		listaEmpregados = empregadoControllerPO.consultaTodosEmpregados(path);
	}

	@Então("a resposta do servidor deve conter um Json com os dados de todos os usuários cadastrados")
	public void a_resposta_do_servidor_deve_conter_um_json_com_os_dados_de_todos_os_usuários_cadastrados() {
		assertTrue(listaEmpregados.size() > 1);
	}

	@Quando("executo a requisição do tipo put no path {string}, junto ao id de um empregado")
	public void executo_a_requisição_do_tipo_put_no_path_junto_ao_id_de_um_empregado(String path) {
		empregadoEditado = empregadoControllerPO.editarEmpregado(path);
		
	}

	@Então("a resposta do servidor deve conter um Json com os dados do usuário editado")
	public void a_resposta_do_servidor_deve_conter_um_json_com_os_dados_do_usuário_editado() {
		assertTrue(empregadoEditado.getNome().toLowerCase().contains("editado"));
	}

}

package br.com.inmetrics.teste.pageobjects;

import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONObject;

import br.com.inmetrics.teste.entidade.Empregado;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EmpregadoControllerPO {

	private JSONObject postEmpregadoJson;
	private Response postEmpregadoResponse;
	private Response getEmpregadoCadastrado;
	private RequestSpecification request = RestAssured.given();
	private Integer empregadoId;
	private String baseUrl;

	public JSONObject getPostEmpregadoJson() {
		return postEmpregadoJson;
	}

	public void setPostEmpregadoJson(JSONObject postEmpregadoJson) {
		this.postEmpregadoJson = postEmpregadoJson;
	}

	public Response getPostEmpregadoResponse() {
		return postEmpregadoResponse;
	}

	public void setPostEmpregadoResponse(Response postEmpregadoResponse) {
		this.postEmpregadoResponse = postEmpregadoResponse;
	}

	public RequestSpecification getRequest() {
		return request;
	}

	public void setRequest(RequestSpecification request) {
		this.request = request;
	}

	public Integer getEmpregadoId() {
		return empregadoId;
	}

	public void setEmpregadoId(Integer empregadoId) {
		this.empregadoId = empregadoId;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public Response getGetEmpregadoCadastrado() {
		return getEmpregadoCadastrado;
	}

	public void setGetEmpregadoCadastrado(Response getEmpregadoCadastrado) {
		this.getEmpregadoCadastrado = getEmpregadoCadastrado;
	}


	public void criarEmpregado() {
		request.header("Content-Type", "application/json");
		request.body(postEmpregadoJson.toJSONString());
		postEmpregadoResponse = request.auth().basic("inmetrics", "automacao").when()
				.post(baseUrl + "/empregado/cadastrar");
		empregadoId = postEmpregadoResponse.jsonPath().getInt("empregadoId");
	}

	public Integer getEmpregadoCadastrado() {
		if (empregadoId != null) {
			return empregadoId;
		}
		postEmpregadoJson = montarJson("Teste Automatizado Romulo");
		criarEmpregado();
		return empregadoId;
	}

	public void consultaEmpregado(String path) {
		getEmpregadoCadastrado = request.auth().basic("inmetrics", "automacao").when()
				.get(baseUrl + path + getEmpregadoCadastrado());

	}

	public List<Empregado> consultaTodosEmpregados(String path) {
		Response getListaEmpregados = request.auth().basic("inmetrics", "automacao").when().get(baseUrl + path);
		return Arrays.asList(getListaEmpregados.getBody().as(Empregado[].class));
	}

	public Empregado editarEmpregado(String path) {	
		postEmpregadoJson= montarJson("Teste Editado");
		request.body(postEmpregadoJson.toJSONString());
		Response putEmpregado = request.auth().basic("inmetrics", "automacao").when().put(baseUrl + path + getEmpregadoId());		
		return putEmpregado.getBody().as(Empregado.class);
	}
	
	private JSONObject montarJson(String nome) {
		JSONObject json = new JSONObject();
		json.put("admissao", "21/08/2020");
		json.put("cargo", "Analista de Automação de Testes");
		json.put("comissao", "1.000,00");
		json.put("cpf", "251.952.180-56");
		json.put("departamentoId", "1");
		json.put("nome", nome);
		json.put("salario", "1.000,00");
		json.put("sexo", "m");
		json.put("tipoContratacao", "clt");
		return json;
	}

}

#language: pt
#Author: romulo.redg@gmail.com

@webservice
Funcionalidade: Empregado Controller
  Validar o funcionamento de api de controle de empregados
  
  Contexto:
  	Dado que a URL Base da api é "https://inm-api-test.herokuapp.com" 

  Cenário: Cadastrar Empregado
    Dado que eu crio um json para criar um empregado
    E preencho a admissao do empregado "21/08/2020"
    E preencho o cargo do empregado "Analista de Automação de Testes"
    E preencho a comissão do empregado "1.000,00"
    E preencho o cpf do empregado "251.952.180-56"
    E preencho o departamentoId do empregado "1"
    E preencho o nome do empregado "Teste Automatizado Romulo"
    E preencho o salario do empregado "1.000,00"
    E preencho o sexo do empregado "m"
    E preencho o tipoContratacao do empregado "clt"
    Quando executo a requisição do tipo post
    Então a resposta deve conter um Json com os dados do usuário criado
    E o codigo da resposta da api deve ser "201"
    
	
  Cenário: Listar Empregado Cadastrado
  	Dado que eu cadastrei um empregado
  	Quando executo a requisição do tipo get no path "/empregado/list/", junto ao id de um empregado
  	Então a resposta do servidor deve conter um Json com os dados do usuário pesquisado
	
	Cenário: Listar Todos os Usuários
		Quando executo a requisição do tipo get no path "/empregado/list_all"
		Então a resposta do servidor deve conter um Json com os dados de todos os usuários cadastrados
		
	
  Cenário: Alterar usuário
  	Dado que eu cadastrei um empregado
		Quando executo a requisição do tipo put no path "/empregado/alterar/", junto ao id de um empregado
		Então a resposta do servidor deve conter um Json com os dados do usuário editado
		
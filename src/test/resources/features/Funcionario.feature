#language: pt
#Author: romulo.redg@gmail.com

@funcional
Funcionalidade: Funcionário
  Como usuário, desejo cadastrar, editar, excluir e listar funcionários
  
  Contexto:
		Dado que acessei a url "http://www.inmrobo.tk/accounts/login/"
		E eu preencho o nome do usuário "Teste Automatizado"
    E eu preencho a senha "teste123"
    E clico no botão Entre
    Entao o sistema apresenta a listagem de funcionarios


  Cenário: Cadastrar Funcionário
  	Quando que eu clico no botão Novo Funcionário
  	Então o sistema apresenta a tela de cadastro de funcionário
  	Quando eu preencho o campo Nome com "Teste Automatizado"
  	E eu preencho o campo Cargo com "Analista de Automação de Testes"
  	E eu preencho o campo CPF com "121.459.830-74"
  	E eu preencho o campo Salário com "2000000" 
  	E eu seleciono o campo Sexo com "Masculino"
  	E eu marco o Tipo de Contratação "CLT"
  	E eu preencho o campo Admissão com "21082020"
  	E eu clico no botão Enviar
  	Entao o sistema apresenta a listagem de funcionários
  	E o sistema apresenta a mensagem de sucesso "SUCESSO! Usuário cadastrado com sucesso"
  	
  	
 	Cenário: Excluir Funcionário
 	 	Quando eu clico no botão Excluir Funcionário do primeiro funcionário da lista
 	 	Entao o sistema apresenta a mensagem de sucesso "SUCESSO! Funcionário removido com sucesso"
 	 	E o sistema remove o primeiro funcionário da lista de funcionários
 	 	
	Cenário: Editar Funcionário
		Quando eu clico no botão Editar Funcionário do primeiro funcionário da lista
 	 	Então o sistema apresenta a tela de cadastro de funcionário
  	Quando eu altero o nome do usuário para "Teste Automatizado Editado"
  	E eu clico no botão Enviar
  	Entao o sistema apresenta a listagem de funcionários
  	E o sistema apresenta a mensagem de sucesso "SUCESSO! Informações atualizadas com sucesso"
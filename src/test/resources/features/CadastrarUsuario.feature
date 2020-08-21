#language: pt
#Author: romulo.redg@gmail.com

@funcional
Funcionalidade: Cadastrar usuário
 	Quero cadastrar um usuário no sistema da inmetrics

  Cenario: Acessar o cadastro de usuário através do botao no navbar
    Dado que acessei a url "http://www.inmrobo.tk/accounts/login/"
    Quando eu clico no botao Cadastre-se no navbar
    Entao o sistema apresenta a página de cadastro do usuário
    
 	Cenario: Acessar o cadastro de usuário através do botao no container
    Dado que acessei a url "http://www.inmrobo.tk/accounts/login/"
    Quando eu clico no botao Cadastre-se no container
    Entao o sistema apresenta a página de cadastro do usuário

	Cenario: Cadastrar Usuário
		Dado que acessei a url "http://www.inmrobo.tk/accounts/login/"
    Quando eu clico no botao Cadastre-se no container
    Entao o sistema apresenta a página de cadastro do usuário
    Quando eu preencho o nome do usuário "Teste Automatizado"
		E eu preencho a senha "teste123"
		E eu preencho a confirmação da senha "teste123"
		E clico no botão cadastrar
		Entao o sistema apresenta a página de login
		E o sistema apresenta mensagem de sucessos
		
	Cenario: Usuário já cadastrado
		Dado que acessei a url "http://www.inmrobo.tk/accounts/login/"
    Quando eu clico no botao Cadastre-se no container
    Entao o sistema apresenta a página de cadastro do usuário
    Quando eu preencho o nome do usuário "Teste Automatizado"
		E eu preencho a senha "teste123"
		E eu preencho a confirmação da senha "teste123"
		E clico no botão cadastrar
		Entao o sistema apresenta a mensagem "Usuário já cadastrado"
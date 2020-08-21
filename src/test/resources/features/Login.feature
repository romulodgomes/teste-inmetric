#language: pt
#Author: romulo.redg@gmail.com

@funcional
Funcionalidade: Login
  Como usuário, desejo efetuar login no sistema

  Cenario: Efetuar Login
    Dado que acessei a url "http://www.inmrobo.tk/accounts/login/"
    Quando eu preencho o nome do usuário "Teste Automatizado"
    E eu preencho a senha "teste123"
    E clico no botão Entre
    Entao o sistema apresenta a listagem de funcionarios

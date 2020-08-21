# Teste Inmetrics

Esse projeto foi realizado como parte de um processo seletivo para a empresa Inmetrics. O desafio era automatizar um sistema WEB de controle de funcionários e uma API de controle em empregados. Além disso, também foi solicitado a criação de um job no Jenkins para execução dos testes automatizados. 

---
## Índice

- [Tecnologias utilizadas](#-tecnologias-utilizadas)
- [Executar o teste](#-executar-o-projeto)
- [Jenkins](#-jenkins)
---
## Tecnologias utilizadas
---
Para o desafio, foram ultilizadas as seguintes tecnologias:
- Selenium Java
- Cucumber (BDD)
- Jenkins (Integração continua)
---
Vale ressaltar também o uso de algumas blibliotécas Java utilizadas para facilitar o serviço:
- Webdrivermanager (para download e configuração do driver do selenium)
- Rest Assured (para efetur e validar a API RESP)
- Cucumber Reporting (para criação de dashboard de resultado de testes no Jenkins)
---
## Executar o teste

Para executar o projeto, via Maven, basta seguir no seu terminal predileto para o diretorio do projeto e executar o seguinte comando:
```bash
  $ mvn test
```

Caso deseje executar pela IDE de sua preferencia, executar o arquivo *RunCucumberTest.java* inicia todos os testes. 

---
## Relatórios de testes 
 
 Ao executar os testes, os relatórios HTML estão sendo gravados dentro do diretorio *target/cucumber-reports/html/*, e um relatório em formato JSON está sendo gravado no diretório target/cucumber-reports/json. Nesse report HTML, está registrada a execução dos casaos de testes, juntamente a evidêncais de sucesso/falha no testes executados. O arquivo JSON é gerado para que seja utilizado para gerar um report um pouco mais sofisticado, que será anexado a execução do job no Jenkis (ver na seção sobre o Jenkins).  
 
---
## Obsevaçoes sobre o resultado dos testes

Devido a natureza do desafio, considerei 3 erros encontrados no sistema:
 - Ao cadastrar um usuário, o sistema não apresentou mensagem de sucesso. Considerei um erro, pois ao cadastrar um funcionario, a mensagem foi apresentada. 
 - Ao cadastrar um Funcionario, o sistema apresentou a mensagem "SUCESSO! Usuário cadastrado com sucesso", porem, foi cadastrado um funcionario, não um usuário.
 - Na API, ao cadastrar um empregado, o código da resposta HTTP foi 202 (Accepted), porem, para criação de dados, o padrão é 201 (Created)
 
 Pode ser que alguns destes não sejam de fato erros, mas achei interessante que alguns testes falhassem para melhor ilustração dos relatórios gerados. 
 
 ## Jenkins
 
 Seguido com os requisitos do desafio, foi configurado um job na ferramenta Jenkins para executar os testes 2 vezes por dia de maneira automática, com um dashboard para onde é apresentado de maneira mais sofisticada o relatório de execução dos testes.
 
 <img src="jenkinsInmetrics.gif" alt="Gif mostrando como funciona o Job do Jenkins"/>
 
 Segue print das configurações do Jenkin e do job criado:
 
 <a href="EvidenciasJenkins.rar" download/> 
 
 ## Considerações Finais
 
 UFA! Deu trabalho! rsrs e valeu o trabalho. Com a algum tempo já não trabalhava com testes em interface, precisei de um tempo para recuperar a antiga prática, ainda mais no BDD, pois atualmente trabalho com algo proximo ao teste unitário. Foi um exercício interessante alongar os conhecimentos a algum tempo parado. 
 
 E o que falar desse Jenkins que mal conheço, mas já considero pakas?! Essa foi minha primeira experiencia configurando o Jenkins eu mesmo (nesse prazo curtinho), e ja consigo ver muitas possibilidades de uso!
 
 Em resumo, durante o desafio, fui me afiando e aprendendo. Espero conseguir mostrar meus conhecimentos para meus avaliadores. 
 
 Até mais!
 
 

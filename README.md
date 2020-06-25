# donusChallenge

Para realizar o teste utilizei o spring como framework, a decisão de escolha deste framework foi somente por conhecer melhor este do que outros.
Criei um controller para receber as chamadas separando dois endpoints:
movie/list , com metodo Get para listar os filmes já cadastrados.
movie/create , com metodo post para criação dos filmes.

Na chamada de listagem é necessário apenas passar o parâmetro para o tipo de busca:
nivel_censura (CENSURADO ou SEM_CENSURA) caso passe outro valor será retornado erro.

Na chamada de criação do filme é necessário passar um JSON :

{
	"nome": "Sexto-Sentido",
	"dataLancamento": "1989-10-30",
	"censura": "CENSURADO",
	"direcao": "NOME DIRETOR",
	"atores": [
	"NOME-ATOR-1",
   	"NOME-ATOR-2",
   	"NOME-ATOR-3"   
	]
}
Caso o seja enviado um filme com um nome que já esteja cadastrado ou com número de atores maior que 10 retornará erro!

A estrutura ficou organizada da Seguinte forma:
Config, onde realizei algumas configurações do projeto,
Controller, onde receberá as chamadas;
Services: onde criei uma classe para trabalhar a lógica dos dados.;
Entity: onde criei um (domain) para filmes(Movie) de acordo com as regras;
Repository: onde criei a um MovieRepository para ligar com o banco de dados;

Dentro da Service eu utilizei a classe ResponseStatusException para tratar os erros segundo as regras.

Utilizei neste projeto o banco de dados H2 por ser simples, porém caso necessário outro banco é de fácil alteração no arquivo application.properties.

Para realizar os testes utilizei as ferramentas JUnit e MockMVC para os testes no model Movie e nos testes dos endpoints da controller.

Também realizei a configuração do Swagger para documentação da API.
Então poderá utilizar o link http://localhost:8080/swagger-ui.html para acessar a documentção do projeto na opção filme-controller.

Deixei disponível os arquivos Dockerfile e docker-compose.yaml assim poderá executar o projeto com o comando docker-compose up no diretório do arquivo.

*Extra*

Realizei também a configuração de um ambiente ElasticBeanstalk na minha conta da AWS com o seguinte link:
http://donus-env.us-east-1.elasticbeanstalk.com/
Deixarei disponível até o fim do processo caso queriam utilizar está disponível 
Swagger:
http://donus-env.us-east-1.elasticbeanstalk.com/swagger-ui.html


Desde de já agradeço a oportunidade e mesmo que não seja selecionado para avançar gostaria de receber o feedback para eu melhorar no meu desenvolvimento!

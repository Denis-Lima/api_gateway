# api_gateway

# Projeto da matéria de Laboratório de Engenharia de Software
# Microserviço de gateway para os outros microserviços existentes e registrados no banco de dados
## Autor: Denis F. Lima.

### Tecnologias e ferramentas

Java - 8  
Servlets - 4.0.1  
Gradle - 7.1.1  
Apache TomCat - 9.0  
JPA com Hibernate - 5.5.5  
MariaDB - 2.7.3  


### Processo de build (Gradle 7):
1. Criar uma pasta vazia
2. Clonar o repositório com:  
```console
git clone https://github.com/Denis-Lima/api_gateway.git
```
3. Navegar para a pasta api_gateway
4. Executar o comando: 
```console
gradlew build
```
5. Ir na pasta build/libs

### Como rodar:  
1. Após o build, poderá rodar o serviço utilizando seu próprio tomcat, copiando o arquivo api_gateway-1.0.war dentro da pasta build/libs, para a pasta webapps do seu TomCat.  
2. Para rodar localmente, digite  
```console
gradlew appRun
```  

### Endpoints
Para este serviço, temos o endpoint mapeado em: `/gateway/<tipo_operacao>`, com o método POST  
onde o <tipo_operacao> é `elementar` ou `transcendental`, no qual terá como query params os mesmo de cada serviço correspondente (consultar o repositório [elementar](https://github.com/Denis-Lima/elementarServices) e/ou [transcendental](https://github.com/Denis-Lima/transcendentalServices))  
O gateway irá realizar sua request para o endpoint correto e retornará a resposta.

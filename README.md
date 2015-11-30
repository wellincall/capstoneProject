# Configurando Eclipse:
* Utilizar jdk/jre acima de 1.8. Caso contrario, Spark nao funciona. Isso acontece pelo fato de lambdas nao serem suportados em versoes abaixo de 1.8 no java.
# Configurando o banco de dados
* crie o banco de dados:
```
psql <nome do seu usuario>;
CREATE DATABASE capstoneProject;
\q;
```
* Abra o pgAdmin III;
* Conecte-se ao banco criado;
* Abra a aba de comandos SQL;
* Importe o arquivo createDB.sql;
* Execute os comandos presentes no arquivo;
* Pronto! Banco de dados criado com sucesso;

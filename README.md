# Introdução
Projeto proposto na disciplina Programação Orientada à Objetos do curso Ciência da Computação.

## Objetivo
O objetivo é produzir um programa Java sem interface gráfica com o usuário que permita operações elementares (CRUD) em banco de dados considerando-se a entidade especificada pelo diagrama de classes
UML constante no [Anexo I](https://github.com/T1T1R3/CRUD-Java/blob/main/Anexo1.png).

O projeto deverá ser composto por:
1. códigos-fontes de todas as classes requeridas;
2. script SQL para a geração da estrutura do banco de dados;
3. testes contemplando:
* inclusão dos objetos com os seguintes estados:

| Name | Email | Password | Last Access | Active |
| --- | --- | --- | --- | --- |
|Ana Zaira| a.zaira@mail.com| 123 |Ontem às 17:00| Sim|
|Beatriz Yana| b.yana@mail.com| 456| Hoje às 03:00 |Sim|
|Cecília Xerxes| c.xerxes@mail.com| 789| Anteontem às 12:00| Sim|
|Débora Wendel |debora.w@mail.com |147| Nunca acessou| Não|
|Eugênia Vale| e.vale@mail.com |258| Hoje às 06:00 |Sim|
|Fernanda Uchoa |f.vale@mail.com |369| Ontem às 23:59 |Não|

* atualização dos seguintes registros:

| Name | Email | Password | Last Access | Active |
| --- | --- | --- | --- | --- |
|Ana Zaira| a.zaira@mail.com| 123 |**Agora**| Sim|
|Beatriz Yana| b.yana@mail.com| 456| Hoje às 03:00 |Sim|
|Cecília Xerxes| c.xerxes@mail.com| 789| Anteontem às 12:00|**Não**|
|Débora Wendel |**d.wendel@mail.com** |**&Yh4$Wu9**| Nunca acessou| Não|
|Eugênia Vale| e.vale@mail.com |**asdfqwerty**|**Agora**|Sim|
|Fernanda Uchoa |f.vale@mail.com |369| Ontem às 23:59 |Não|

* impressão do 3° objeto recuperado do banco de dados;
* impressão de todos os objetos recuperados do banco de dados;
* impressão de todos os objetos com estado ativo no banco de dados;
* remoção do 4° objeto inserido no banco de dados.
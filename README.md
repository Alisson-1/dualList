# Projeto - Listas Duplamente Encadeadas na Linguagem Imperativa 2

## Universidade Federal de Pernambuco  
**Centro de Informática**  
**Disciplina:** IN1007 2025.1 - **Paradigmas de Linguagens de Programação**  

## Equipe
- **Alisson Gabriel Assunção de Oliveira** - [agao@cin.ufpe.br](mailto:agao@cin.ufpe.br)  
- **Emilly de Albuquerque Oliveira** - [eao3@cin.ufpe.br](mailto:eao3@cin.ufpe.br)  
- **Wanusa Araújo de Pontes** - [wap@cin.ufpe.br](mailto:wap@cin.ufpe.br)  

## Introdução
Este projeto tem como objetivo expandir a **Linguagem Imperativa 2** por meio da implementação da estrutura de dados **Lista Duplamente Encadeada** (Double Linked List). Essa estrutura é amplamente utilizada em linguagens de paradigma imperativo por permitir armazenamento dinâmico e navegação bidirecional entre elementos.

Listas duplamente encadeadas são compostas por nós que mantêm referências tanto para o elemento anterior quanto para o próximo, o que possibilita operações eficientes de inserção, remoção e atualização em qualquer posição da lista. Essa flexibilidade as torna uma escolha natural em contextos que demandam manipulação dinâmica de coleções.

Durante a análise da Linguagem Imperativa 2, observou-se que ainda não há suporte nativo a esse tipo de estrutura. Assim, este projeto busca integrar listas duplamente encadeadas à linguagem, respeitando seus princípios sintáticos e semânticos.

## Estrutura e Funcionamento

A estrutura proposta segue os princípios clássicos de listas duplamente encadeadas:

 - Cada nó contém um valor, uma referência para o nó anterior e outra para o nó seguinte.

 - O primeiro nó é denominado cabeça (head) e o último, cauda (tail).

Operações básicas incluem:

- Inserção de um novo nó em qualquer posição;

- Remoção de nós por valor;

- Atualização de valores existentes;

- Visualização da lista completa, permitindo iteração em ambas as direções.

## Objetivos
Ao final do projeto, espera-se que a Linguagem Imperativa 2 seja capaz de:

- Declarar e manipular listas duplamente encadeadas;

- Realizar operações dinâmicas de inserção, remoção e atualização;

- Navegar pela lista em ambas as direções;

- Manter a coerência da BNF e dos mecanismos de parsing da linguagem.

Este repositório contém os arquivos e implementações necessários para adicionar suporte completo à estrutura de listas duplamente encadeadas na Linguagem Imperativa 2.

---
Abaixo está a Backus-Naur Form (BNF) atualizada para a Linguagem Imperativa 2. As classes em negrito indicam as partes que foram adicionadas ou alteradas para suportar a programação reativa.

## BNF
[Programa](PLP/Imperativa2/src/li2/plp/imperative2/Programa.java) ::= [Comando](PLP/Imperativa2/src/li2/plp/imperative1/command/Comando.java )

Comando ::= [Atribuicao](PLP/Imperativa2/src/li2/plp/imperative1/command/Atribuicao.java)

&emsp; &emsp; &emsp; &emsp;  &ensp;| [ComandoDeclaracao](PLP/Imperativa2/src/li2/plp/imperative1/command/ComandoDeclaracao.java)

&emsp; &emsp; &emsp; &emsp;  &ensp;| [While](PLP/Imperativa2/src/li2/plp/imperative1/command/While.java)

&emsp; &emsp; &emsp; &emsp;  &ensp;| [IfThenElse](PLP/Imperativa2/src/li2/plp/imperative1/command/IfThenElse.java)

&emsp; &emsp; &emsp; &emsp;  &ensp;| [IO](PLP/Imperativa2/src/li2/plp/imperative1/command/IO.java)

&emsp; &emsp; &emsp; &emsp;  &ensp;| [SequenciaComando](PLP/Imperativa2/src/li2/plp/imperative1/command/SequenciaComando.java) Comando ";" Comando

&emsp; &emsp; &emsp; &emsp;  &ensp;| [Skip](PLP/Imperativa2/src/li2/plp/imperative1/command/Skip.java)

&emsp; &emsp; &emsp; &emsp;  &ensp;| [ChamadaProcedimento](PLP/Imperativa2/src/li2/plp/imperative2/command/ChamadaProcedimento.java)

&emsp; &emsp; &emsp; &emsp;  &ensp;| [OperacaoLista]

Skip ::= 

Atribuicao ::= [Id](PLP/Imperativa2/src/li2/plp/expressions2/expression/Id.java) ":=" [Expressao](PLP/Imperativa2/src/li2/plp/expressions2/expression/Expressao.java)

Expressao ::= [Valor](PLP/Imperativa2/src/li2/plp/expressions2/expression/Valor.java) | [ExpUnaria](PLP/Imperativa2/src/li2/plp/expressions2/expression/ExpUnaria.java) | [ExpBinaria](PLP/Imperativa2/src/li2/plp/expressions2/expression/ExpBinaria.java ) | Id

Valor ::= [ValorConcreto](PLP/Imperativa2/src/li2/plp/expressions2/expression/ValorConcreto.java)

ValorConcreto ::= [ValorInteiro](PLP/Imperativa2/src/li2/plp/expressions2/expression/ValorInteiro.java ) 
| [ValorBooleano](PLP/Imperativa2/src/li2/plp/expressions2/expression/ValorBooleano.java) 
| [ValorString](PLP/Imperativa2/src/li2/plp/expressions2/expression/ValorString.java)

ExpUnaria ::= [ExpMenos](PLP/Imperativa2/src/li2/plp/expressions2/expression/ExpMenos.java ) "-" Expressao | [ExpNot](PLP/Imperativa2/src/li2/plp/expressions2/expression/ExpNot.java ) "not" Expressao | [ExpLenght](PLP/Imperativa2/src/li2/plp/expressions2/expression/ExpLength.java) "lenght" Expressao

ExpBinaria ::=  [ExpSoma](PLP/Imperativa2/src/li2/plp/expressions2/expression/ExpSoma.java) Expressao "+" Expressao

&emsp; &emsp; &emsp; &emsp;  &ensp;| [ExpSub](PLP/Imperativa2/src/li2/plp/expressions2/expression/ExpSub.java) Expressao "-" Expressao

&emsp; &emsp; &emsp; &emsp;  &ensp;| [ExpAnd](PLP/Imperativa2/src/li2/plp/expressions2/expression/ExpAnd.java) Expressao "and" Expressao

&emsp; &emsp; &emsp; &emsp;  &ensp;| [ExpOr](PLP/Imperativa2/src/li2/plp/expressions2/expression/ExpOr.java) Expressao "or" Expressao

&emsp; &emsp; &emsp; &emsp;  &ensp;| [ExpEquals](PLP/Imperativa2/src/li2/plp/expressions2/expression/ExpEquals.java) Expressao "==" Expressao

&emsp; &emsp; &emsp; &emsp;  &ensp;| [ExpConcat](PLP/Imperativa2/src/li2/plp/expressions2/expression/ExpConcat.java) Expressao "++" Expressao

ComandoDeclaracao :: = "{" [Declaracao](PLP/Imperativa2/src/li2/plp/imperative1/declaration/Declaracao.java) ";" Comando "}"

Declaracao ::= [DeclaracaoVariavel](PLP/Imperativa2/src/li2/plp/imperative1/declaration/DeclaracaoVariavel.java)

&emsp; &emsp; &emsp; &emsp;  &ensp;| [DeclaracaoProcedimento](PLP/Imperativa2/src/li2/plp/imperative2/declaration/DeclaracaoProcedimento.java)

&emsp; &emsp; &emsp; &emsp;  &ensp;| [DeclaracaoComposta](PLP/Imperativa2/src/li2/plp/imperative1/declaration/DeclaracaoComposta.java)
&emsp; &emsp; &emsp; &emsp;  &ensp;|CriacaoLista

DeclaracaoVariavel ::= “var” Id “=” Expressao

DeclaracaoComposta ::= Declaracao “,” Declaracao

[DeclaracaoProcedimento](PLP/Imperativa2/src/li2/plp/imperative2/declaration/DeclaracaoProcedimento.java) ::= "proc" Id "(" [ ListaDeclaracaoParametro ] ")" "{" Comando "}"

ListaDeclaracaoParametro ::= [DeclaracaoParametro](PLP/Imperativa2/src/li2/plp/imperative2/declaration/DeclaracaoParametro.java) Tipo Id |\
 &emsp; &emsp; &emsp; &emsp;  &ensp;| [ListaDeclaracaoParametro](PLP/Imperativa2/src/li2/plp/imperative2/declaration/ListaDeclaracaoParametro.java) Tipo Id "," ListaDeclaracaoParametro

Tipo ::= “string” | “int” | “boolean” | TipoLista

TipoLista ::= "list" "<" Tipo ">"

While ::= “while” Expressao “do” Comando

IfThenElse ::= “if” Expressao “then” Comando “else” Comando

IO ::= [Write](PLP/Imperativa2/src/li2/plp/imperative1/command/Write.java) "write" "(" Expressao ")" | [Read](PLP/Imperativa2/src/li2/plp/imperative1/command/Read.java) "read" "(" Id ")"

ChamadaProcedimento ::= "call" Id "(" [[ ListaExpressao ]](PLP/Imperativa2/src/li2/plp/imperative2/command/ListaExpressao.java) ")" 

ListaExpressao ::= Expressao | Expressao, ListaExpressao

CriacaoLista ::= "dllist" "(" ")"

OperacaoLista ::= Id "." MetodoLista

MetodoLista ::= "add" "(" Expressao ")" 

 &emsp; &emsp; &emsp; &emsp;  &ensp;| "remove" "(" Expressao ")"

 &emsp; &emsp; &emsp; &emsp;  &ensp;| "update" "(" Expressao "," Expressao ")"
 
 &emsp; &emsp; &emsp; &emsp;  &ensp;| "show" "(" ")"


SequenciaComando ::= Comando ";" Comando


---
### Classes Auxiliares
[AmbienteExecucaoImperativa2](PLP/Imperativa2/src/li2/plp/imperative2/memory/AmbienteExecucaoImperativa2.java)  
[ContextoExecucaoImperativa2](PLP/Imperativa2/src/li2/plp/imperative2/memory/ContextoExecucaoImperativa2.java)  
[**DefReativo**](PLP/Imperativa2/src/li2/plp/imperative2/declaration/DefReativo.java)  
[**Publisher**](PLP/Imperativa2/src/li2/plp/imperative2/observer/Publisher.java)  
[**Subscriber**](PLP/Imperativa2/src/li2/plp/imperative2/observer/Subscriber.java)  
[**VariavelReativaPublisher**](PLP/Imperativa2/src/li2/plp/imperative2/observer/VariavelReativaPublisher.java)  
[**VariavelReativaJaDeclaradaException**](PLP/Imperativa2/src/li2/plp/imperative2/memory/VariavelReativaJaDeclaradaException.java)  
[**VariavelReativaNaoDeclaradaException**](PLP/Imperativa2/src/li2/plp/imperative2/memory/VariavelReativaNaoDeclaradaException.java)  
[**CicloDeDependenciaException**](PLP/Imperativa2/src/li2/plp/imperative2/memory/CicloDeDependenciaException.java)

---
### Parser
[Imperative2](PLP/Imperativa2/src/li2/plp/imperative2/parser/Imperative2.jj)

A gramática da Linguagem Imperativa 2 será estendida para reconhecer a declaração e manipulação de listas duplamente encadeadas, incluindo novas regras para criação, iteração e modificação de nós.

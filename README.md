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

## BNF

---
### Parser
[Imperative2](PLP/Imperativa2/src/li2/plp/imperative2/parser/Imperative2.jj)

A gramática da Linguagem Imperativa 2 será estendida para reconhecer a declaração e manipulação de listas duplamente encadeadas, incluindo novas regras para criação, iteração e modificação de nós.
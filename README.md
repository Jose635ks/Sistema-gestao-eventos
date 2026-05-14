# 🎉 Sistema de Gestão de Eventos

Sistema de gestão de clientes para eventos desenvolvido em Java, com funcionalidades de registo, cálculo de valores, pesquisa, ordenação e persistência de dados em ficheiros.

---

## 📋 Descrição

O programa permite gerir eventos (casamentos, festas, conferências, etc.) para uma empresa de organização de eventos. Para cada cliente/evento, o sistema calcula automaticamente o valor final com base em vários parâmetros como decoração, assessoria, número de funcionários, acréscimo por feriado e impostos.

---

## ⚙️ Funcionalidades

- 📂 **Leitura de dados** a partir de ficheiro de texto (`Dados.txt`)
- 📊 **Visualização** dos dados em formato de tabela
- 🔢 **Contagem e totalização** de eventos por tipo
- 💰 **Cálculo de valores** a pagar aos funcionários em feriados
- 💾 **Gravação e leitura** de ficheiro de objectos (serialização)
- 🔍 **Pesquisa** de eventos por número de telefone ou data
- 🔃 **Ordenação** de eventos por data (ordem crescente)
- ➕ **Inserção** de novos eventos manualmente
- 📝 **Registo** de novos eventos em ficheiro

---

## 🗂️ Estrutura do Projeto

```
src/
├── Executavel.java              # Ponto de entrada da aplicação
├── Menu.java                    # Interface principal (menu de opções)
├── Cliente.java                 # Classe modelo do cliente/evento
├── TodosCliente.java            # Gestão do array de clientes
├── Calculos.java                # Lógica de cálculos financeiros
├── Pesquisa.java                # Pesquisa por telefone e data
├── Ordenar.java                 # Ordenação de eventos por data
├── Validacao.java               # Validação de entradas do utilizador
├── Visualizacoes.java           # Apresentação de dados no ecrã
├── EscreverFicheiro.java        # Escrita em ficheiros de texto
├── FicheiroObjectos.java        # Serialização de objectos
└── EscreverNovoRegistroEvento.java  # Registo de novos eventos
```

---

## 🚀 Como Executar

### Pré-requisitos
- Java JDK 8 ou superior
- IDE recomendada: [IntelliJ IDEA](https://www.jetbrains.com/idea/)

### Passos

1. Clona o repositório:
   ```bash
   git clone https://github.com/teu-utilizador/gestao-clientes-eventos-java.git
   ```

2. Abre o projeto na tua IDE.

3. Certifica-te que o ficheiro `Dados.txt` está na raiz do projeto.

4. Executa a classe `Executavel.java`.

---

## 🖥️ Menu Principal

```
**** MENU ***
1.  Ler os dados do ficheiro e armazenar no array de objectos
2.  Visualizar os dados do array de objectos
3.  Ver a quantidade de eventos total e de cada tipo
4.  Ver o total de eventos no total e por cada tipo
5.  Escrever num ficheiro a quantidade e valor total a pagar aos funcionários no feriado
6.  Escrever os dados no ficheiro de objecto
7.  Ler os dados de um ficheiro de objecto
8.  Pesquisar eventos pelo telefone e data
9.  Ordenar os eventos de forma crescente da data do evento
10. Visualizar os dados dos programadores
11. Introdução de um novo evento
12. Visualizar os dados do novo evento
13. Sair do programa
```

---

## 🛠️ Tecnologias Utilizadas

- **Java** — Linguagem de programação principal
- **Serialização Java** — Persistência de objectos (`Ficheiro.dat`)
- **BufferedReader / FileWriter** — Leitura e escrita de ficheiros de texto
- **IntelliJ IDEA** — IDE de desenvolvimento

---

## 👨‍💻 Autores

Trabalho Prático 2 — Desenvolvido no âmbito da unidade curricular de programação.

# Lista de Tarefas

Projeto desenvolvido para praticar conceitos de Programação Orientada a Objetos em Java e marcar os primeiros repositórios no GitHub.

A ideia é evoluir o projeto para uso real no dia a dia, adicionando interface gráfica e banco de dados futuramente.

## Funcionalidades

- Adicionar tarefa com descrição e prazo limite
- Listar todas as tarefas cadastradas
- Concluir tarefa
- Remover tarefa
- Editar descrição e prazo de uma tarefa existente
- Persistência em arquivo — tarefas são salvas ao sair e carregadas ao abrir

## Tecnologias utilizadas

- Java
- `LocalDate` para manipulação de datas
- `ArrayList` para gerenciamento da coleção de tarefas
- `BufferedWriter` / `BufferedReader` para persistência em arquivo

## Como rodar

1. Clone o repositório
2. Compile os arquivos na pasta `src/`
3. Execute a classe `Main`

```bash
javac src/*.java
java -cp src Main
```

## Estrutura do projeto

```
src/
├── Main.java           # Ponto de entrada
├── App.java            # Interface de menu no terminal
├── ListadeTarefas.java # Gerenciamento da coleção de tarefas
└── Tarefa.java         # Modelo de uma tarefa
```

## Próximos passos

- [x] Persistência em arquivo
- [ ] Banco de dados
- [ ] Interface gráfica (front end)
- [ ] Suporte multiusuário

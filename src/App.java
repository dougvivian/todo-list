import java.util.Scanner;
import java.time.LocalDate;

public class App {
    ListadeTarefas lista;

    public App() {
        this.lista = new ListadeTarefas();
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 5) {
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Concluir Tarefa");
            System.out.println("4. Remover tarefa");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite a descrição da tarefa: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Digite a data limite (YYYY-MM-DD): ");
                    String dataLimiteStr = scanner.nextLine();
                    LocalDate dataLimite = LocalDate.parse(dataLimiteStr);
                    Tarefa novaTarefa = new Tarefa(descricao, dataLimite);
                    lista.adicionarTarefa(novaTarefa);
                    break;
                case 2:
                    lista.listarTarefas();
                    break;
                case 3:
                    System.out.print("Digite a descrição da tarefa a concluir: ");
                    String descricaoConcluir = scanner.nextLine();
                    for (Tarefa t : lista.getTarefas()) {
                        if (t.getDescricao().equalsIgnoreCase(descricaoConcluir)) {
                            lista.concluirTarefa(t);
                            System.out.println("Tarefa concluída!");
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("Digite a descrição da tarefa a remover: ");
                    String descricaoRemover = scanner.nextLine();
                    for (Tarefa t : lista.getTarefas()) {
                        if (t.getDescricao().equalsIgnoreCase(descricaoRemover)) {
                            lista.removerTarefa(t);
                            System.out.println("Tarefa removida!");
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close();

    }
}

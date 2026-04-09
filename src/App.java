import java.util.Scanner;
import java.time.LocalDate;
import java.io.IOException;

public class App {
    private ListadeTarefas lista;
    private Scanner scanner;

    public App() {
        this.lista = new ListadeTarefas();
        this.scanner = new Scanner(System.in);
        try { this.lista.carregarTarefas(); } catch (IOException e) { System.out.println("Erro ao carregar: " + e.getMessage()); }
    }

    public void iniciar() {
        int opcao = 0;

        while (opcao != 6) {
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Concluir Tarefa");
            System.out.println("4. Remover tarefa");
            System.out.println("5. Editar tarefa");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: adicionarTarefa(); break;
                case 2: listarTarefas(); break;
                case 3: concluirTarefa(); break;
                case 4: removerTarefa(); break;
                case 5: editarTarefa(); break;
                case 6:
                    try { lista.salvarTarefas(); } catch (Exception e) { System.out.println("Erro ao salvar: " + e.getMessage()); }
                    System.out.println("Saindo...");
                    break;
                default: System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }

    private void listarTarefas() {
        lista.listarTarefas();
    }

    private void adicionarTarefa() {
        System.out.print("Digite a descrição da tarefa: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite a data limite (YYYY-MM-DD): ");
        LocalDate dataLimite = LocalDate.parse(scanner.nextLine());
        lista.adicionarTarefa(new Tarefa(descricao, dataLimite));
    }

    private void concluirTarefa() {
        System.out.print("Digite a descrição da tarefa a concluir: ");
        String descricao = scanner.nextLine();
        for (Tarefa t : lista.getTarefas()) {
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                lista.concluirTarefa(t);
                System.out.println("Tarefa concluída!");
                break;
            }
        }
    }

    private void removerTarefa() {
        System.out.print("Digite a descrição da tarefa a remover: ");
        String descricao = scanner.nextLine();
        for (Tarefa t : lista.getTarefas()) {
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                lista.removerTarefa(t);
                System.out.println("Tarefa removida!");
                break;
            }
        }
    }

    private void editarTarefa() {
        System.out.print("Digite a descrição da tarefa a editar: ");
        String descricao = scanner.nextLine();
        for (Tarefa t : lista.getTarefas()) {
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                System.out.print("Nova descrição: ");
                String novaDescricao = scanner.nextLine();
                System.out.print("Nova data limite (YYYY-MM-DD): ");
                LocalDate novaDataLimite = LocalDate.parse(scanner.nextLine());
                lista.editarTarefa(t, novaDescricao, novaDataLimite);
                System.out.println("Tarefa editada!");
                break;
            }
        }
    }
}

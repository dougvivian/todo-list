import java.util.ArrayList;
import java.time.LocalDate;

public class ListadeTarefas {
    private ArrayList<Tarefa> tarefas;

    public ListadeTarefas(){
        this.tarefas = new ArrayList<>();
    }

    public void concluirTarefa(Tarefa tarefa){
        tarefa.concluir();
    }

    public void adicionarTarefa(Tarefa tarefa){
        tarefas.add(tarefa);
    }

    public void removerTarefa(Tarefa tarefa){
        tarefas.remove(tarefa);
    }

    public void listarTarefas(){
        for(Tarefa t : tarefas){
            System.out.println(t);
        }
    }

    public void editarTarefa(Tarefa tarefa, String novaDescricao, LocalDate novaDataLimite) {
        tarefa.setDescricao(novaDescricao);
        tarefa.setDataLimite(novaDataLimite);
    }

    public ArrayList<Tarefa> getTarefas() {
        return this.tarefas;
    }

}

import java.util.ArrayList;
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

    public ArrayList<Tarefa> getTarefas() {
        return this.tarefas;
    }

    public void setTarefas(ArrayList<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

}

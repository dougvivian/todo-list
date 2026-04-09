import java.util.ArrayList;
import java.time.LocalDate;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class ListadeTarefas {
    private ArrayList<Tarefa> tarefas;
    
    

    public void carregarTarefas() throws IOException {
        File arquivo = new File("tarefas.txt");
        if (!arquivo.exists()) return;

        BufferedReader reader = new BufferedReader(new FileReader(arquivo));
        String linha;
        while ((linha = reader.readLine()) != null) {
            String[] campos = linha.split(";");
            String descricao = campos[0];
            LocalDate dataLimite = LocalDate.parse(campos[1]);
            boolean concluida = Boolean.parseBoolean(campos[2]);
            Tarefa t = new Tarefa(descricao, dataLimite);
            if (concluida) t.concluir();
            tarefas.add(t);
        }
        reader.close();
    }

    public void salvarTarefas() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("tarefas.txt"));
        for (Tarefa t : tarefas) {
            writer.write(t.getDescricao() + ";" + t.getDataLimite() + ";" + t.isConcluida());
            writer.newLine();
        }
        writer.close();
    }


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

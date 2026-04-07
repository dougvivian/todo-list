import java.time.LocalDate;

public class Tarefa {
    private int id;
    private String descricao;
    private boolean concluida;
    private LocalDate dataCadastro;
    private LocalDate dataLimite;


    public Tarefa(String descricao, LocalDate dataLimite){
        this.descricao = descricao;
        this.concluida = false;
        this.dataCadastro = LocalDate.now();
        this.dataLimite = dataLimite;

    }
    
    public void concluir(){
        setConcluida(true);
    }

    @Override
    public String toString(){
        return  "Tarefa: " + descricao + "\n" +
                "Data Criação: " + dataCadastro + "\n" +  
                "Data Limite: " + dataLimite + "\n" +
                "Concluída?: " + concluida + "\n";
        

    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluida() {
        return this.concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public LocalDate getDataCadastro() {
        return this.dataCadastro;
    }

    public LocalDate getDataLimite() {
        return this.dataLimite;
    }

    public void setDataLimite(LocalDate dataLimite) {
        this.dataLimite = dataLimite;
    }

}
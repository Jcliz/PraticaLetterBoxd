import java.util.ArrayList;

public class Gravadora {
    private String nome;
    private ArrayList<Filme> filmes;

    public Gravadora(String nome) {
        this.nome = nome;
        this.filmes = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "--__--__--__--__--__--__--__--" + "\n" +
                "Nome: " + this.nome + "\n" +
                "Filmes: " + "\n" +
                this.filmes.toString() + "\n" +
                "\n";
    }

    public void addFilme (Filme filme) {
        filmes.add(filme);
    }

    public void removeFilme (Filme filme) {
        filmes.remove(filme);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

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
                "Filmes: " + this.filmes + "\n" +
                "--__--__--__--__--__--__--__--" + "\n";
    }

    public void addFilme (Filme filme) {
        filmes.add(filme);
    }

    public String getNome() {
        return nome;
    }
}

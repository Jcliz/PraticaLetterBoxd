import java.util.ArrayList;

public class Gravadora {
    private String nome;
    private ArrayList<Filme> filmes;

    public Gravadora(String nome) {
        this.nome = nome;
        this.filmes = new ArrayList<>();
    }

    public void addFilme (Filme filme) {
        filmes.add(filme);
    }

    public String getNome() {
        return nome;
    }
}

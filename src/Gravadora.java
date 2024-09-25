import java.util.ArrayList;

public class Gravadora {
    private String nome;
    private ArrayList<Filme> filmes;

    public Gravadora(String nome) {
        this.nome = nome;
    }

    public void addFilme (Filme filme) {
        filmes.add(filme);
    }
}

import java.util.ArrayList;

public class Gravadora {
    private String nome;
    private ArrayList<Filme> filmes;

    public Gravadora(String nome, Filme filme) {
        this.nome = nome;
        this.filmes.add(filme);
    }


}

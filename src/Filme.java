public class Filme {
    private String nome;
    private String duracao;
    private int nota;
    private String diretor;
    private Gravadora gravadora;
    private int classificacao;

    public Filme (String nome, String duracao, int nota, String diretor, Gravadora gravadora, int classificacao) {
        this.nome = nome;
        this.duracao = duracao;
        this.nota = nota;
        this.diretor = diretor;
        this.gravadora = gravadora;
        this.classificacao = classificacao;
    }
}

public class Filme {
    private String nome;
    private String duracao;
    private float nota;
    private String direcao;
    private Gravadora gravadora;
    private int classificacao;

    public Filme (String nome, String duracao, float nota, String direcao,
                  int classificacao, Gravadora gravadora) {
        this.nome = nome;
        this.duracao = duracao;
        this.nota = nota;
        this.direcao = direcao;
        this.gravadora = gravadora;
        this.classificacao = classificacao;
    }

    public Gravadora getGravadora() {
        return gravadora;
    }

    public String getNome() {
        return nome;
    }
}

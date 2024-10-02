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

    public Filme () {

    }

    @Override
    public String toString () {
        return  "-_-_-_-_-_-_-_-_-_-" + "\n" +
                "Nome: " + this.nome + "\n" +
                "Duração: " + this.duracao + "\n" +
                "Nota dos usuários: " + this.nota + "\n" +
                "Direção: " + this.direcao + "\n" +
                "Gravadora: " + this.gravadora.getNome() + "\n" +
                "Classificação indicativa: " + this.classificacao + "\n" +
                "-_-_-_-_-_-_-_-_-_-" + "\n";
    }

    public Gravadora getGravadora() {
        return gravadora;
    }

    public String getNome() {
        return nome;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public Filme instanciarFilme(String nome, String duracao, float nota, String direcao,
                                 int classificacao, Gravadora gravadora) {
        return new Filme(nome, duracao, nota, direcao, classificacao, gravadora);
    }

    public void setGravadora (Gravadora gravadora) {
        this.gravadora = gravadora;
    }
}

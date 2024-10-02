public class Acao extends Filme{
    private float notaEfeitos;

    public Acao (float notaEfeitos, String nome, String duracao, float nota, String direcao,
                 int classificacao, Gravadora gravadora){
        super(nome, duracao, nota, direcao, classificacao, gravadora);
        this.notaEfeitos = notaEfeitos;
    }

    public Acao (){
        super();
    }

    @Override
    public String toString () {
        return super.toString() + "\n" +
                "Nota dos efeitos especiais: " + this.notaEfeitos + "\n" +
                "-_-_-_-_-_-_-_-_-_-" + "\n";
    }

    public Filme instanciarFilme(String nome, String duracao, float nota, String direcao,
                                int classificacao, Gravadora gravadora) {
        return new Acao(0f, nome, duracao, nota, direcao, classificacao, gravadora);
    }

    public void setNotaEfeitos (float notaEfeitos) {
        this.notaEfeitos = notaEfeitos;
    }
}

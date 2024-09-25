public class Acao extends Filme{
    private float notaEfeitos;

    public Acao (float notaEfeitos, String nome, String duracao, int nota, String diretor,
                 Gravadora gravadora, int classificacao){
        super(nome, duracao, nota, diretor, classificacao, gravadora);
        this.notaEfeitos = notaEfeitos;
    }

    public void setNotaEfeitos (float notaEfeitos){
        this.notaEfeitos = notaEfeitos;
    }
}

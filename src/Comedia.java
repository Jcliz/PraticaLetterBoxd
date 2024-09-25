public class Comedia extends Filme{
    private float notaHumor;

    public Comedia (float notaHumor, String nome, String duracao, int nota, String diretor,
                    int classificacao, Gravadora gravadora){
        super(nome, duracao, nota, diretor, classificacao, gravadora);
        this.notaHumor = notaHumor;
    }

    public void setNotaHumor (float notaHumor) {
        this.notaHumor = notaHumor;
    }
}
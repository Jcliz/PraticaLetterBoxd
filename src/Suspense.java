public class Suspense extends Filme{
    private float notaTensao;

    public Suspense (float notaTensao, String nome, String duracao, float nota, String direcao,
                     int classificacao, Gravadora gravadora){
        super(nome, duracao, nota, direcao, classificacao, gravadora);
        this.notaTensao = notaTensao;
    }

    @Override
    public String toString () {
        return super.toString() + "\n" +
                "Nota da tensão: " + this.notaTensao + "\n" +
                "-_-_-_-_-_-_-_-_-_-" + "\n";
    }

    public void setNotaTensao(float notaTensao){
        this.notaTensao = notaTensao;
    }
}

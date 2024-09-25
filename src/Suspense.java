public class Suspense extends Filme{
    private float notaTensao;

    public Suspense (float notaTensao, String nome, String duracao, float nota, String direcao,
                     int classificacao, Gravadora gravadora){
        super(nome, duracao, nota, direcao, classificacao, gravadora);
        this.notaTensao = notaTensao;
    }

    public void setNotaTensao(float notaTensao){
        this.notaTensao = notaTensao;
    }
}

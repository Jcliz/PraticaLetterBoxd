public class Terror extends Filme{
    private float notaJumpscares;

    public Terror (float notaJumpscares, String nome, String duracao, float nota, String direcao,
                   int classificacao, Gravadora gravadora){
        super(nome, duracao, nota, direcao, classificacao, gravadora);
        this.notaJumpscares = notaJumpscares;
    }

    public void setNotaJumpscares (float notaJumpscares){
        this.notaJumpscares = notaJumpscares;
    }
}

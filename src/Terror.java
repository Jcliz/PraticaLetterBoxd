public class Terror extends Filme{
    private float notaJumpscares;

    public Terror (float notaJumpscares, String nome, String duracao, int nota, String diretor, Gravadora gravadora, int classificacao){
        super(nome, duracao, nota, diretor, classificacao, gravadora);
        this.notaJumpscares = notaJumpscares;
    }

    public void setNotaJumpscares (float notaJumpscares){
        this.notaJumpscares = notaJumpscares;
    }
}

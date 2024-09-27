public class Terror extends Filme{
    private float notaJumpscares;

    public Terror (float notaJumpscares, String nome, String duracao, float nota, String direcao,
                   int classificacao, Gravadora gravadora){
        super(nome, duracao, nota, direcao, classificacao, gravadora);
        this.notaJumpscares = notaJumpscares;
    }

    @Override
    public String toString () {
        return super.toString() + "\n" +
                "Nota da tensão: " + this.notaJumpscares + "\n" +
                "-_-_-_-_-_-_-_-_-_-" + "\n";
    }

    public void setNotaJumpscares (float notaJumpscares){
        this.notaJumpscares = notaJumpscares;
    }
}

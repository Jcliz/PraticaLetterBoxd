public class Terror extends Filme{
    private float notaJumpscares;

    public Terror (float notaJumpscares, String nome, String duracao, float nota, String direcao,
                   int classificacao, Gravadora gravadora){
        super(nome, duracao, nota, direcao, classificacao, gravadora);
        this.notaJumpscares = notaJumpscares;
    }

    public Terror (){
        super();
    }

    @Override
    public String toString () {
        return super.toString() + "\n" +
                "Nota dos jumpscares: " + this.notaJumpscares + "\n" +
                "-_-_-_-_-_-_-_-_-_-" + "\n";
    }

    public Filme instanciarFilme(String nome, String duracao, float nota, String direcao,
                                 int classificacao, Gravadora gravadora) {
        return new Terror(0f ,nome, duracao, nota, direcao, classificacao, gravadora);
    }

    public void setNotaJumpscares (float notaJumpscares) {
        this.notaJumpscares = notaJumpscares;
    }
}

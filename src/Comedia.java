public class Comedia extends Filme{
    private float notaHumor;

    public Comedia (float notaHumor, String nome, String duracao, float nota, String direcao,
                    int classificacao, Gravadora gravadora){
        super(nome, duracao, nota, direcao, classificacao, gravadora);
        this.notaHumor = notaHumor;
    }

    public Comedia (){
        super();
    }

    @Override
    public String toString () {
        return super.toString() + "\n" +
                "Nota do humor: " + this.notaHumor + "\n" +
                "-_-_-_-_-_-_-_-_-_-" + "\n";
    }

    public Filme instanciarFilme(String nome, String duracao, float nota, String direcao,
                                 int classificacao, Gravadora gravadora) {
        return new Comedia(0f, nome, duracao, nota, direcao, classificacao, gravadora);
    }

    public void setNotaHumor (float notaHumor) {
        this.notaHumor = notaHumor;
    }
}
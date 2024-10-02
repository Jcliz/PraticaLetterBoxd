public class Aventura extends Filme{
    private String tipoAventura;

    public Aventura (String tipoAventura, String nome, String duracao, float nota, String direcao,
                     int classificacao, Gravadora gravadora){
        super(nome, duracao, nota, direcao, classificacao, gravadora);
        this.tipoAventura = tipoAventura;
    }

    public Aventura (){
        super();
    }

    @Override
    public String toString () {
        return super.toString() + "\n" +
                "Tipo da aventura: " + this.tipoAventura + "\n" +
                "-_-_-_-_-_-_-_-_-_-" + "\n";
    }

    public Filme instanciarFilme(String nome, String duracao, float nota, String direcao,
                                 int classificacao, Gravadora gravadora) {
        return new Aventura("", nome, duracao, nota, direcao, classificacao, gravadora);
    }

    public void setTipoAventura (String tipo) {
        this.tipoAventura = tipo;
    }
}

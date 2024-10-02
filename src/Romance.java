public class Romance extends Filme{
    private String tipoRomance;

    public Romance (String tipoRomance, String nome, String duracao, float nota, String direcao,
                    int classificacao, Gravadora gravadora){
        super(nome, duracao, nota, direcao, classificacao, gravadora);
        this.tipoRomance = tipoRomance;
    }

    public Romance (){
        super();
    }

    @Override
    public String toString () {
        return super.toString() + "\n" +
                "Tipo do romance: " + this.tipoRomance + "\n" +
                "-_-_-_-_-_-_-_-_-_-" + "\n";
    }

    public Filme instanciarFilme(String nome, String duracao, float nota, String direcao,
                                 int classificacao, Gravadora gravadora) {
        return new Romance("", nome, duracao, nota, direcao, classificacao, gravadora);
    }

    public void setTipoRomance (String tipoRomance) {
        this.tipoRomance = tipoRomance;
    }

}

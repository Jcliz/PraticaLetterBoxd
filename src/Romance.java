public class Romance extends Filme{
    private String tipoRomance;

    public Romance (String tipoRomance, String nome, String duracao, float nota, String direcao,
                    int classificacao, Gravadora gravadora){
        super(nome, duracao, nota, direcao, classificacao, gravadora);
        this.tipoRomance = tipoRomance;
    }

    @Override
    public String toString () {
        return super.toString() + "\n" +
                "Nota da tensão: " + this.tipoRomance + "\n" +
                "-_-_-_-_-_-_-_-_-_-" + "\n";
    }
}

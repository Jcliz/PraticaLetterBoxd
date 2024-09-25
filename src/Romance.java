public class Romance extends Filme{
    private String tipoRomance;

    public Romance (String tipoRomance, String nome, String duracao, int nota, String diretor,
                    Gravadora gravadora, int classificacao){
        super(nome, duracao, nota, diretor, classificacao, gravadora);
        this.tipoRomance = tipoRomance;
    }
}

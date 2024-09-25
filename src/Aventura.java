public class Aventura extends Filme{
    private String tipoAventura;

    public Aventura (String tipoAventura, String nome, String duracao, int nota, String diretor,
                     Gravadora gravadora, int classificacao){
        super(nome, duracao, nota, diretor, classificacao, gravadora);
        this.tipoAventura = tipoAventura;
    }
}

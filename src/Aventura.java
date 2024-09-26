public class Aventura extends Filme{
    private String tipoAventura;

    public Aventura (String tipoAventura, String nome, String duracao, float nota, String direcao,
                     int classificacao, Gravadora gravadora){
        super(nome, duracao, nota, direcao, classificacao, gravadora);
        this.tipoAventura = tipoAventura;
    }
}

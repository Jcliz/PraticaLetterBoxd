public class Documentario extends Filme {
    private String conteudo;

    public Documentario (String conteudo, String nome, String duracao, int nota, String diretor, int classificacao,
                         Gravadora gravadora){
        super(nome, duracao, nota, diretor, classificacao, gravadora);
        this.conteudo = conteudo;
    }
}

public class Documentario extends Filme {
    private String conteudo;

    public Documentario (String conteudo, String nome, String duracao, float nota, String direcao,
                         int classificacao, Gravadora gravadora){
        super(nome, duracao, nota, direcao, classificacao, gravadora);
        this.conteudo = conteudo;
    }

    public Documentario (){
        super();
    }

    @Override
    public String toString () {
        return super.toString() + "\n" +
                "Conteúdo: " + this.conteudo + "\n" +
                "-_-_-_-_-_-_-_-_-_-" + "\n";
    }

    public Filme instanciarFilme(String tipo, String nome, String duracao, float nota, String direcao,
                                 int classificacao, Gravadora gravadora) {
        return new Documentario(tipo, nome, duracao, nota, direcao, classificacao, gravadora);
    }

    public void setConteudo (String conteudo) {
        this.conteudo = conteudo;
    }
}

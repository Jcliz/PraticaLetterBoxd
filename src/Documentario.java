import java.util.Scanner;

public class Documentario extends Filme {
    private String conteudo;

    public Documentario (String conteudo, String nome, String duracao, float nota, String direcao,
                         int classificacao, Gravadora gravadora){
        super(nome, duracao, nota, direcao, classificacao, gravadora);
        this.conteudo = conteudo;
    }

    @Override
    public String toString () {
        return super.toString() + "\n" +
                "Conteúdo: " + this.conteudo + "\n" +
                "-_-_-_-_-_-_-_-_-_-" + "\n";
    }

    public void setDiferencas (Scanner leitor) {
        System.out.println("Conteúdo presente no documentário");
        this.conteudo = leitor.nextLine();
    }
}

import java.util.Scanner;

public class Suspense extends Filme{
    private float notaTensao;

    public Suspense (float notaTensao, String nome, String duracao, float nota, String direcao,
                     int classificacao, Gravadora gravadora){
        super(nome, duracao, nota, direcao, classificacao, gravadora);
        this.notaTensao = notaTensao;
    }

    @Override
    public String toString () {
        return super.toString() + "\n" +
                "Nota da tensão: " + this.notaTensao + "\n" +
                "-_-_-_-_-_-_-_-_-_-" + "\n";
    }

    public void setDiferencas (Scanner leitor) {
        System.out.println("Nota dada pela mídia para a tensão: ");
        this.notaTensao = leitor.nextFloat();
    }
}

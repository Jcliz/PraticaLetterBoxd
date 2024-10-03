import java.util.Scanner;

public class Acao extends Filme{
    private float notaEfeitos;

    public Acao (float notaEfeitos, String nome, String duracao, float nota, String direcao,
                 int classificacao, Gravadora gravadora){
        super(nome, duracao, nota, direcao, classificacao, gravadora);
        this.notaEfeitos = notaEfeitos;
    }

    @Override
    public String toString () {
        return super.toString() + "\n" +
                "Nota dos efeitos especiais: " + this.notaEfeitos + "\n" +
                "-_-_-_-_-_-_-_-_-_-" + "\n";
    }

    public void setDiferencas (Scanner leitor) {
        System.out.println("Nota da mídia para efeitos especiais:");
        this.notaEfeitos = leitor.nextFloat();
    }
}

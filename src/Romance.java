import java.util.Scanner;

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
                "Tipo do romance: " + this.tipoRomance + "\n" +
                "-_-_-_-_-_-_-_-_-_-" + "\n";
    }

    public void setDiferencas (Scanner leitor) {
        System.out.println("Tipo do romance: ");
        this.tipoRomance = leitor.nextLine();
    }
}

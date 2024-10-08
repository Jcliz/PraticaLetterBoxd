import java.util.Scanner;

public class Aventura extends Filme{
    private String tipoAventura;

    public Aventura (String tipoAventura, String nome, String duracao, float nota, String direcao,
                     int classificacao, Gravadora gravadora){
        super(nome, duracao, nota, direcao, classificacao, gravadora);
        this.tipoAventura = tipoAventura;
    }

    @Override
    public String toString () {
        return super.toString() + "\n" +
                "Tipo da aventura: " + this.tipoAventura + "\n" +
                "-_-_-_-_-_-_-_-_-_-" + "\n";
    }

    public void setDiferencas (Scanner leitor) {
        System.out.println("Indique o tipo da aventura: ");
        this.tipoAventura = Utils.capitalize(leitor.nextLine());
    }
}

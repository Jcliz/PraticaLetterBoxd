import java.util.ArrayList;
import java.util.Scanner;

public class Colaborador {
    public void criarFilme (Scanner leitor, Filme filme) {
        filme.setDiferencas(leitor);
    }

    public void removerFilmes(ArrayList<Filme> listaFilmes, String nome){
        Filme filme = Utils.buscarFilme(nome, listaFilmes);
        listaFilmes.remove(filme);
        if (filme == null) {
            System.out.println("Filme inexistente!" + "\n");

        } else {
            System.out.println(filme.getNome() + " foi removido dos filmes!" + "\n");
        }
    }

    public void adicionarGravadoras(Scanner leitor, ArrayList<Filme> listaFilmes, Gravadora novaGravadora) {
        boolean addFilmes = true;
        while(addFilmes) {
            System.out.println("""
             [1] - Adicionar um filme à gravadora
             
             [0] - Voltar""");

            switch (leitor.nextInt()) {
                case 1:
                    System.out.println("Indique o filme:");
                    leitor.nextLine();
                    String filme = Utils.capitalize(leitor.nextLine());

                    for (Filme f : listaFilmes) {
                        if (f.getNome().equals(filme)) {
                            System.out.println(f.getNome() + " Adicionado à gravadora!" + "\n");
                            f.setGravadora(novaGravadora);
                            novaGravadora.addFilme(f);
                        }
                    }

                case 0:
                    addFilmes = false;
                    System.out.println("Voltando para as configurações de colaborador..." + "\n");
                    break;
            }
        }
    }

    public void removerGravadoras(ArrayList<Gravadora> listaGravadoras, String nome, ArrayList<Filme> listaFilmes) {
        Gravadora g = Utils.buscarGravadora(nome, listaGravadoras);
        if (g == null) {
            System.out.println("Gravadora inexistente!" + "\n");

        } else {
            System.out.println(g.getNome() + " foi removido das gravadoras!" + "\n");
            for (Filme f : listaFilmes) {
                if (f.getGravadora() == g) {
                    f.setGravadora(new Gravadora("Sem gravadora cadastrada..."));
                    g.removeFilme(f);
                }
            }
            listaGravadoras.remove(g);
        }
    }
}

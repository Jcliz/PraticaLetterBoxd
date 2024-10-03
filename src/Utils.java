import java.util.ArrayList;
import java.util.Scanner;

public class Utils {

    public static Usuario cadastrarUsuario (Scanner leitor) {
        System.out.println("E-mail: ");
        String email = leitor.nextLine();

        System.out.println("Username: ");
        String user = leitor.nextLine();

        System.out.println("Senha: ");
        String senha = leitor.nextLine();

        System.out.println("Idade: ");
        int idade = leitor.nextInt();

        System.out.println("Localização (opicional): ");
        leitor.nextLine();
        String localizacao = leitor.nextLine();

        System.out.println("Bio (opicional): ");
        String bio = leitor.nextLine();

        return new Usuario(email, user, senha, idade, localizacao, bio);
    }

    public static void trocaCadastro (Scanner leitor, Usuario u) {
        boolean trocaDados = true;
        while (trocaDados) {
            System.out.println("""
                    Selecione o dado que deseja alterar:
                    
                    [1] - E-mail
                    [2] - Username
                    [3] - Senha
                    [4] - Idade
                    [5] - Localizacao
                    [6] - Bio
                    
                    [0] - Voltar
                    """);

            switch (leitor.nextInt()) {
                case 1:
                    System.out.println("Novo e-mail:");
                    leitor.nextLine();
                    String novoEmail = leitor.nextLine();

                    u.setEmail(novoEmail);
                    System.out.println("""
                        Novo dado cadastrado com sucesso!
                        """);
                    break;

                case 2:
                    System.out.println("Novo user:");
                    leitor.nextLine();
                    String novoUser = leitor.nextLine();

                    u.setUser(novoUser);
                    System.out.println("""
                        Novo dado cadastrado com sucesso!
                        """);
                    break;

                case 3:
                    System.out.println("Nova senha:");
                    leitor.nextLine();
                    String novaSenha = leitor.nextLine();

                    if (novaSenha.equals(u.getSenha())) {
                        System.out.println("Senha idêntica à anterior cadastrada!" + "\n");
                        break;
                    }

                    System.out.println("Confirme a nova senha:");
                    String confirmSenha = leitor.nextLine();

                    if (!confirmSenha.equals(novaSenha)) {
                        System.out.println("Senha não é igual!" + "\n");
                        break;
                    }

                    System.out.println("Nova senha cadastrada com sucesso!" + "\n");
                    u.setSenha(confirmSenha);
                    break;

                case 4:
                    System.out.println("Nova idade:");
                    int novaIdade = leitor.nextInt();

                    u.setIdade(novaIdade);
                    System.out.println("""
                        Novo dado cadastrado com sucesso!
                        """);
                    break;

                case 5:
                    System.out.println("Nova localização:");
                    leitor.nextLine();
                    String novaLocali = leitor.nextLine();

                    u.setLocalizacao(novaLocali);
                    System.out.println("""
                        Novo dado cadastrado com sucesso!
                        """);
                    break;

                case 6:
                    System.out.println("Nova bio:");
                    leitor.nextLine();
                    String novaBio = leitor.nextLine();

                    u.setBio(novaBio);
                    System.out.println("""
                        Novo dado cadastrado com sucesso!
                        """);
                    break;

                case 0:
                    trocaDados = false;
                    System.out.println();
                    break;

                default:
                    System.out.println("""
                        Opção inválida!
                        """);
                    break;
            }
        }
    }

    public static String capitalize(String nome) {
        if (nome == null || nome.isEmpty()) {
            return nome;
        }

        String[] palavras = nome.split(" ");
        StringBuilder strBuilder = new StringBuilder();

        for (String palavra : palavras) {
            if (!palavra.isEmpty()) {
                strBuilder.append(palavra.substring(0, 1).toUpperCase())
                        .append(palavra.substring(1).toLowerCase());
            }
            strBuilder.append(" ");
        }

        return strBuilder.toString().trim();
    }

    public static void addValoresListas (String nomeFilme, ArrayList<Filme> filmes, Usuario u, String opcao) {
        Filme filme = Utils.buscarFilme(nomeFilme, filmes);

        if (filme == null) {
            System.out.println("Filme inexistente!" + "\n");

        } else if (opcao.equals("Assistidos")) {
            if (u.pegarListaAssistidos().contains(filme)) {
                System.out.println(filme.getNome() + " já foi selecionado!" + "\n");

            } else {
                u.addAssistidos(filme);
                System.out.println(filme.getNome() + " adicionado à lista de assistidos com sucesso!" + "\n");
            }
        } else if (opcao.equals("Favoritos")){
            if (u.pegarListaFavoritos().contains(filme)) {
                System.out.println(filme.getNome() + " já foi favoritado!" + "\n");

            } else {
                u.addFavoritos(filme);
                System.out.println(filme.getNome() + " favoritado com sucesso!" + "\n");
            }
        }
    }

    public static void avaliarFilmes (String filmeNome, ArrayList<Filme> listaFilmes, Scanner leitor, Usuario u) {
        Filme filme = Utils.buscarFilme(filmeNome, listaFilmes);

        if (filme == null) {
            System.out.println("Filme inexistente!" + "\n");
        } else {
            System.out.println("-_-_- Avaliar " + filme.getNome() + " -_-_-");

            System.out.println("Nota (0 a 10):");
            float notaAva = leitor.nextFloat();
            filme.setNota(notaAva);

            System.out.println("Descrição (opcional):" + "\n");
            leitor.nextLine();
            String descricao = leitor.nextLine();

            System.out.println("Avaliação cadastrada com sucesso!" + "\n");
            u.addAvaliacoes(descricao, filme.getNome(), notaAva);
        }
    }

    public static void adicionarFilmes(Filme filme, ArrayList<Filme> filmes){
        if (filmes.contains(filme)) {
            System.out.println(filme.getNome() + " já foi adicionado.");
        } else {
            filmes.add(filme);
            System.out.println(filme.getNome() + " adicionado com sucesso!");
        }
    }

    public static void adicionarGravadoras(Scanner leitor, ArrayList<Filme> listaFilmes, Gravadora novaGravadora) {
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

    public static void removerFilmes(ArrayList<Filme> listaFilmes, String nome){
        Filme filme = Utils.buscarFilme(nome, listaFilmes);
        listaFilmes.remove(filme);
        if (filme == null) {
            System.out.println("Filme inexistente!" + "\n");

        } else {
            System.out.println(filme.getNome() + " foi removido dos filmes!" + "\n");
        }
    }

    public static void removerGravadoras(ArrayList<Gravadora> listaGravadoras, String nome) {
        Gravadora g = Utils.buscarGravadora(nome, listaGravadoras);
        listaGravadoras.remove(g);
        if (g == null) {
            System.out.println("Filme inexistente!" + "\n");

        } else {
            System.out.println(g.getNome() + " foi removido das gravadoras!" + "\n");
        }
    }

    public static Filme buscarFilme(String nomeFilme, ArrayList<Filme> filmes) {
        for (Filme f : filmes) {
            if (f.getNome().equals(Utils.capitalize(nomeFilme))) {
                return f;
            }
        }
        return null;
    }

    public static Gravadora buscarGravadora(String nomeGravadora, ArrayList<Gravadora> gravadoras) {
        for (Gravadora g : gravadoras) {
            if (g.getNome().equals(Utils.capitalize(nomeGravadora))) {
                return g;
            }
        }
        return null;
    }
}
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {
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

    public static String addValoresListas (String nomeFilme, Filme[] filmes, Usuario u, String opcao) {
        boolean vazio = true;

        for (Filme filme : filmes) {
            if (filme.getNome().equals(Utils.capitalize(nomeFilme))) {
                if (opcao.equals("Assistidos")) {
                    if (u.pegarListaAssistidos().contains(filme)) {
                        vazio = false;
                        return "JaSelecionado";

                    } else {
                        u.addAssistidos(filme);
                        vazio = false;
                        return "Adicionado";
                    }
                } else if (opcao.equals("Favoritos")){
                    if (u.pegarListaFavoritos().contains(filme)) {
                        vazio = false;
                        return "JaSelecionado";

                    } else {
                        u.addFavoritos(filme);
                        vazio = false;
                        return "Adicionado";
                    }
                }
            }
        }
        if (vazio) {
            System.out.println("""
                                 Filme inexistente.
                                 """);
        }
        return "-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-";
    }
}
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
                        System.out.println("Senha idêntica à anterior cadastrada!");
                        break;
                    }

                    System.out.println("Confirme a nova senha:");
                    String confirmSenha = leitor.nextLine();

                    if (!confirmSenha.equals(novaSenha)) {
                        System.out.println("Senha não é igual!");
                        break;
                    }

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
}

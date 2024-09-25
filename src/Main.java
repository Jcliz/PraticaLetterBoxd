import java.util.Scanner;

public class Main {
    //SENHA DE COLABORADOR = 1234
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        //CRIAÇÃO DOS FILMES
        Filme joker = new Suspense(0f, "Joker", "2 horas e 2 minutos", 0f,
                                    "Todd Phillips", 18, new Gravadora("Universal"));

        Filme seila = new Documentario()
                
        System.out.println("""
                                 -_-_-_-_- Letterboxd -_-_-_-_-
                            
                            Aqui a sua opinião importa! Seja bem-vindo(a).
                            """);
        System.out.println("Agora, vamos fazer o seu cadastro." + "\n");

        System.out.println("E-mail: ");
        String email = leitor.nextLine();
        System.out.println("Username: ");
        String username = leitor.nextLine();
        System.out.println("Senha: ");
        String senha = leitor.nextLine();
        System.out.println("Idade: ");
        int idade = leitor.nextInt();
        System.out.println("Localização (opicional): ");
        leitor.nextLine();
        String localizacao = leitor.nextLine();
        System.out.println("Bio (opicional): ");
        String bio = leitor.nextLine();

        Usuario u = new Usuario(email, username, senha, idade, localizacao, bio);

        boolean acessoLogin = true;

        while (acessoLogin) {
            System.out.println("""
                                [1] - Login
                                [2] - Login de colaboradores
                                
                                [0] - Sair
                                """ );

            switch (leitor.nextInt()) {
                case 1:
                    System.out.println("""
                            --- Login ---
                            
                            E-mail ou username:
                            """);
                    leitor.nextLine();
                    String emailOuUser = leitor.nextLine();
                    System.out.println("Senha: ");
                    String senhaLogin = leitor.nextLine();

                    if (!emailOuUser.equals(email) && !emailOuUser.equals(username)) {
                        System.out.println("""
                                E-mail ou user não encontrados.
                                """);
                    } else if (!senhaLogin.equals(senha)) {
                        System.out.println("""
                                Senha incorreta.
                                """);
                        break;
                    } else {
                        System.out.println("\n" + "Seja bem-vindo(a), " + u.getUser() + "!" + "\n");
                        acessoLogin = false;

                        boolean menuUsuario = true;
                        while (menuUsuario) {
                            System.out.println("""
                                                [1] - Alterar dados cadastrais
                                                [2] - Adicionar um filme à lista de assistidos
                                                [3] - Favoritar um filme
                                                [4] - avaliar um filme
                                                [5] - Detalhar um filme
                                                
                                                [0] - Sair
                                                """);

                            switch (leitor.nextInt()) {
                                case 1:
                                    System.out.println("""
                                                -=-=-=-=- Trocar dados cadastrais -=-=-=-=-
                                                
                                                Dados atuais:
                                                """);
                                    System.out.println(u);

                                    Utils.trocaCadastro(leitor, u);

                                    System.out.println("Dados atualizados:" + "\n");
                                    System.out.println(u);
                                    break;

                                case 2:


                                case 0:
                                    System.out.println("Sentiremos a sua falta. :(");
                                    menuUsuario = false;
                                    System.exit(0);
                                    break;

                                default:
                                    System.out.println("Opção inválida!" + "\n");
                            }
                        }
                    }
                    break;

                case 2:
                    System.out.println("""
                            --- Login de colaborador ---
                            
                            código de colaborador:
                            """);
                    int cod = leitor.nextInt();

                    if (cod == 1234) {
                        System.out.println("Seja bem-vindo(a)!");
                        acessoLogin = false;
                    } else {
                        System.out.println("Código incorreto." + "\n");
                    }
                    break;

                case 0:
                    System.out.println("\n" + "Sentiremos a sua falta. :(");
                    acessoLogin = false;
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
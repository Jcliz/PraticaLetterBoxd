import java.util.Scanner;

public class Main {
    //SENHA DE COLABORADOR = 1234
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
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
                        System.out.println("E-mail ou user não encontrados." + "\n");
                    } else if (!senhaLogin.equals(senha)) {
                        System.out.println("Senha incorreta." + "\n");
                    } else {
                        System.out.println("Seja bem-vindo(a)!");
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
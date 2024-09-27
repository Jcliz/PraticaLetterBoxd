import java.util.Scanner;

public class Main {
    //SENHA DE COLABORADOR = 1234
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        //CRIAÇÃO DAS GRAVADORAS
        Gravadora[] gravadoras = new Gravadora[] {
                new Gravadora("Warner Bros"),
                new Gravadora("Netflix"),
                new Gravadora("A24")
        };

        //CRIAÇÃO DOS FILMES
        Filme[] filmes = new Filme[] {
                new Suspense(0f, "Joker", "2 horas e 2 minutos", 0f,
                        "Todd Phillips", 18, gravadoras[0]),
                new Documentario("Documentário sobre o rapper Travis Scott",
                        "Look Mom I Can Fly", "1 hora e 24 minutos", 0f,
                        "White Trash Tyler", 18, gravadoras[1]),
                new Acao(0f, "Matrix", "2 horas e 16 minutos", 0f,
                        "Lana Wachowski e Lilly Wachowski", 16, gravadoras[0]),
                new Aventura("Vida de skatistas", "Mid 90", "1 hora e 25 minutos",
                        0f, "Jonah Hill", 18, gravadoras[2]),
                new Comedia(0f, "Lady Bird", "1 hora e 34 minutos",
                        0f, "Greta Gerwig", 16, gravadoras[2]),
                new Romance("Amor entre diferentes classes", "Diário de Uma Paixão",
                        "2 horas e 3 minutos", 0f, "Nick Cassavetes", 16, gravadoras[0]),
                new Terror(0f, "A bruxa", "1 hora e 40 minutos",
                        0f, "Robert Eggers", 18, gravadoras[1])
        };

        for (Filme f : filmes) {
            f.getGravadora().addFilme(f);
        }

        System.out.println("""
                                 -_-_-_-_- Letterboxd -_-_-_-_-
                            
                            Aqui a sua opinião importa! Seja bem-vindo(a).
                            """);
        System.out.println("Agora, vamos fazer o seu cadastro." + "\n");

        System.out.println("E-mail: ");
        String email = leitor.nextLine();

        System.out.println("Username: ");
        String user = leitor.nextLine();
        String username = Utils.capitalize(user);

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
                            
                            E-mail ou username:""");
                    leitor.nextLine();
                    String emailOuUser = leitor.nextLine();
                    System.out.println("Senha: ");
                    String senhaLogin = leitor.nextLine();

                    if (!emailOuUser.equals(email) && !emailOuUser.equals(user)) {
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
                                                [3] - Listar filmes assistidos
                                                [4] - Favoritar um filme
                                                [5] - Listar filmes favoritos
                                                [6] - avaliar um filme
                                                [7] - Listar avaliações
                                                [8] - Detalhar um filme
                                                [9] - Listar gravadoras
                                                
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
                                    System.out.println("\n" + "Qual filme você deseja adicionar?:");

                                    leitor.nextLine();
                                    String nomeFilme = leitor.nextLine();
                                    System.out.println();

                                    boolean vazio = true;

                                    for (Filme filme : filmes) {
                                        if (filme.getNome().equals(Utils.capitalize(nomeFilme))) {
                                            if (u.pegarListaAssistidos().contains(filme)) {
                                                System.out.println(filme.getNome() + " Já foi selecionado!" + "\n");
                                                vazio = false;
                                            } else {
                                                u.addAssistidos(filme);
                                                vazio = false;
                                                System.out.println(filme.getNome() + " adicionado à lista com sucesso!" + "\n");
                                            }
                                            break;
                                        }
                                    }
                                    if (vazio) {
                                        System.out.println("""
                                                    Filme inexistente.
                                                    """);
                                    }
                                    break;

                                case 3:
                                    System.out.println("Filmes assistidos: ");
                                    u.getAssistidos();
                                    break;

                                case 0:
                                    menuUsuario = false;
                                    System.out.println("Sentiremos a sua falta. :(");
                                    System.exit(0);
                                    break;

                                default:
                                    System.out.println("Opção inválida!" + "\n");
                                    break;
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

                    if (cod != 1234) {
                        System.out.println("Código incorreto." + "\n");

                    } else {
                        acessoLogin = false;
                        System.out.println("Seja bem-vindo(a)!");

                        boolean acessoColab = true;
                        while (acessoColab) {

                        }

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
import java.util.ArrayList;
import java.util.Arrays;
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

        ArrayList<Gravadora> listaGravadoras = new ArrayList<>(Arrays.asList(gravadoras));

        //CRIAÇÃO DOS FILMES
        Filme[] filmes = new Filme[] {
                new Suspense(8.5f, "Joker", "2 horas e 2 minutos", 0f,
                        "Todd Phillips", 18, gravadoras[0]),
                new Documentario("Documentário sobre o rapper Travis Scott",
                        "Look Mom I Can Fly", "1 hora e 24 minutos", 0f,
                        "White Trash Tyler", 18, gravadoras[1]),
                new Acao(9f, "Matrix", "2 horas e 16 minutos", 0f,
                        "Lana Wachowski e Lilly Wachowski", 16, gravadoras[0]),
                new Aventura("Vida de skatistas", "Mid 90", "1 hora e 25 minutos",
                        0f, "Jonah Hill", 18, gravadoras[2]),
                new Comedia(6.3f, "Lady Bird", "1 hora e 34 minutos",
                        0f, "Greta Gerwig", 16, gravadoras[2]),
                new Romance("Amor entre diferentes classes", "Diário de Uma Paixão",
                        "2 horas e 3 minutos", 0f, "Nick Cassavetes", 16, gravadoras[0]),
                new Terror(4.7f, "A bruxa", "1 hora e 40 minutos",
                        0f, "Robert Eggers", 18, gravadoras[1])
        };

        ArrayList<Filme> listaFilmes = new ArrayList<>(Arrays.asList(filmes));

        for (Filme f : listaFilmes) {
            f.getGravadora().addFilme(f);
        }

        System.out.println("""
                                 -_-_-_-_- Letterboxd -_-_-_-_-
                            
                            Aqui a sua opinião importa! Seja bem-vindo(a).
                            """);
        System.out.println("Agora, vamos fazer o seu cadastro." + "\n");

        Usuario u = Utils.cadastrarUsuario(leitor);

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

                    if (!emailOuUser.equals(u.getEmail()) && !emailOuUser.equals(u.getUser())) {
                        System.out.println("""
                                E-mail ou user não encontrados.
                                """);
                    } else if (!senhaLogin.equals(u.getSenha())) {
                        System.out.println("""
                                Senha incorreta.
                                """);
                        break;
                    } else {
                        u.setUser(Utils.capitalize(u.getUser()));
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
                                                
                                                [0] - Voltar
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
                                    System.out.println("""
                                            ===---=== Adicionar um filme à lista de assistidos ===---===
                                            Indique o filme:""");

                                    leitor.nextLine();
                                    String nomeFilme = Utils.capitalize(leitor.nextLine());
                                    System.out.println();
                                    Utils.addValoresListas(nomeFilme, listaFilmes, u, "Assistidos");
                                    System.out.println("===---===---===---===---===---===---===---===---===---===---===" + "\n");
                                    break;

                                case 3:
                                    System.out.println("Filmes assistidos: ");
                                    u.getAssistidos();
                                    break;

                                case 4:
                                    System.out.println("""
                                            ===---===---=== Favoritar um filme ===---===--===
                                            Indique o filme:""");

                                    leitor.nextLine();
                                    String nomeFilmeFav = Utils.capitalize(leitor.nextLine());
                                    System.out.println();
                                    Utils.addValoresListas(nomeFilmeFav, listaFilmes, u, "Favoritos");
                                    System.out.println("===---===---===---===---===---===---===---===---===" + "\n");
                                    break;

                                case 5:
                                    System.out.println("Filmes favoritos: ");
                                    u.getFavoritos();
                                    break;

                                case 6:
                                    System.out.println("""
                                            --__--__--__-- Avaliações --__--__--__--
                                            Qual filme você deseja avaliar?:""");

                                    leitor.nextLine();
                                    String filmeAva = Utils.capitalize(leitor.nextLine());

                                    Utils.avaliarFilmes(filmeAva, listaFilmes, leitor, u);
                                    break;

                                case 7:
                                    System.out.println("Avaliações:");
                                    System.out.println(u.getAvaliados());
                                    System.out.println();
                                    break;

                                case 8:
                                    System.out.println("Filme para detalhar: ");
                                    leitor.nextLine();
                                    String nome = leitor.nextLine();

                                    Filme f = Utils.buscarFilme(nome, listaFilmes);
                                    if (f == null) {
                                        System.out.println("Filme inexistente!");
                                        break;
                                    } else {
                                        System.out.println(f);
                                    }
                                    break;

                                case 9:
                                    leitor.nextLine();
                                    System.out.println("Indique a gravadora: ");
                                    String nomeGravadora = Utils.capitalize(leitor.nextLine());

                                    Gravadora g = Utils.buscarGravadora(nomeGravadora, listaGravadoras);
                                    if (g == null) {
                                        System.out.println("Gravadora inexistente!");
                                        break;
                                    } else {
                                        System.out.println(g);
                                    }
                                    break;

                                case 0:
                                    menuUsuario = false;
                                    System.out.println("Voltando para o login!" + "\n");
                                    acessoLogin = true;
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
                        System.out.println("Seja bem-vindo(a)!" + "\n");
                        Colaborador colab = new Colaborador();

                        boolean acessoColab = true;
                        while (acessoColab) {
                            System.out.println("""
                                    ---___---___---___--- OPÇÕES DE COLABORADOR ---___---___---___---
                                    
                                    Selecione uma opção:
                                    [1] - Adicionar um filme
                                    [2] - Remover um filme
                                    [3] - Adicionar uma gravadora
                                    [4] - Remover uma gravadora
                                    
                                    [0] - Voltar
                                    """);

                            switch (leitor.nextInt()) {
                                case 1:
                                    System.out.println("""
                                            -_-_-_-_-_- Adicionar um filme -_-_-_-_-_-
                                            Nome:""");
                                    leitor.nextLine();
                                    String nome = Utils.capitalize(leitor.nextLine());

                                    System.out.println("Duração:");
                                    String duracao = leitor.nextLine();

                                    System.out.println("Direção:");
                                    String direcao = leitor.nextLine();

                                    System.out.println("Classificação Indicativa:");
                                    int classificacao = leitor.nextInt();

                                    System.out.println("""
                                                       
                                                       Selecione o gênero do filme:
                                                       [1] - Ação
                                                       [2] - Aventura
                                                       [3] - Comédia
                                                       [4] - Documentário
                                                       [5] - Romance
                                                       [6] - Suspense
                                                       [7] - Terror
                                                       """);
                                    Filme novoFilme;

                                    switch (leitor.nextInt()) {
                                        case 1:
                                            System.out.println("Nota da mídia para os efeitos especiais:");
                                            float notaEfeitos = leitor.nextFloat();
                                            novoFilme = new Acao();

                                            Filme resultAcao = colab.criarFilme(novoFilme, nome, duracao, direcao, classificacao);
                                            ((Acao) resultAcao).setNotaEfeitos(notaEfeitos);
                                            listaFilmes.add(resultAcao);

                                            System.out.println("Novo filme de ação criado!" + "\n");
                                            break;

                                        case 2:
                                            System.out.println("Tipo de aventura:");
                                            String tipoAventura = leitor.nextLine();
                                            novoFilme = new Aventura();

                                            Filme resultAventura = colab.criarFilme(novoFilme, nome, duracao, direcao, classificacao);
                                            ((Aventura) resultAventura).setTipoAventura(tipoAventura);
                                            listaFilmes.add(resultAventura);

                                            listaFilmes.add(resultAventura);

                                            System.out.println("Novo filme de aventura criado!" + "\n");
                                            break;

                                        case 3:
                                            System.out.println("Nota da mídia para o humor presente no filme:");
                                            float notaHumor = leitor.nextFloat();
                                            novoFilme = new Comedia();

                                            Filme resultComedia = colab.criarFilme(novoFilme, nome, duracao, direcao, classificacao);
                                            ((Comedia) resultComedia).setNotaHumor(notaHumor);
                                            listaFilmes.add(resultComedia);

                                            System.out.println("Novo filme de comédia criado!" + "\n");
                                            break;

                                        case 4:
                                            System.out.println("Tipo do documentário:");
                                            leitor.nextLine();
                                            String tipoDoc = leitor.nextLine();
                                            novoFilme = new Documentario();

                                            Filme resultDoc = colab.criarFilme(novoFilme, nome, duracao, direcao, classificacao);
                                            ((Documentario) resultDoc).setConteudo(tipoDoc);
                                            listaFilmes.add(resultDoc);

                                            System.out.println("Novo documentário criado!" + "\n");
                                            break;

                                        case 5:
                                            System.out.println("Tipo do romance:");
                                            String tipoRom = leitor.nextLine();
                                            novoFilme = new Romance();

                                            Filme resultRomance = colab.criarFilme(novoFilme, nome, duracao, direcao, classificacao);
                                            ((Romance) resultRomance).setTipoRomance(tipoRom);
                                            listaFilmes.add(resultRomance);

                                            System.out.println("Novo filme de romance criado!" + "\n");
                                            break;

                                        case 6:
                                            System.out.println("Nota da mídia para a tensão no filme:");
                                            leitor.nextLine();
                                            float notaSusp = leitor.nextFloat();
                                            novoFilme = new Suspense();

                                            Filme resultSus = colab.criarFilme(novoFilme, nome, duracao, direcao, classificacao);
                                            ((Suspense) resultSus).setNotaTensao(notaSusp);
                                            listaFilmes.add(resultSus);

                                            System.out.println("Novo filme de suspense criado!" + "\n");
                                            break;

                                        case 7:
                                            System.out.println("Nota da mídia para os jumpscares presentes no filme:");
                                            float notaJump = leitor.nextFloat();
                                            novoFilme = new Terror();

                                            Filme resultTerror = colab.criarFilme(novoFilme, nome, duracao, direcao, classificacao);
                                            ((Terror) resultTerror).setNotaJumpscares(notaJump);
                                            listaFilmes.add(resultTerror);

                                            System.out.println("Novo filme de terror criado!" + "\n");
                                            break;

                                        default:
                                            System.out.println("Opção inválida!");
                                            break;
                                    }
                                    break;

                                case 2:
                                    System.out.println("""
                                            -__--__-__--__- Remover um filme -__--__-__--__-
                                            Indique o filme:
                                            """);
                                    leitor.nextLine();
                                    String nomeRemov = Utils.capitalize(leitor.nextLine());
                                    Utils.removerFilmes(listaFilmes, nomeRemov);
                                    break;

                                case 3:
                                    System.out.println("""
                                            -__--__-__--__- Adicionar uma gravadora -__--__-__--__-
                                            Indique o nome:
                                            """);
                                    leitor.nextLine();
                                    String nomeGrav = Utils.capitalize(leitor.nextLine());
                                    Gravadora novaGravadora = new Gravadora(nomeGrav);
                                    listaGravadoras.add(novaGravadora);   SET DIFERENCAS METODO ABSTRATO

                                    Utils.adicionarGravadoras(leitor, listaFilmes, novaGravadora);
                                    break;

                                case 4:
                                    System.out.println("""
                                            -__--__-__--__- Remover uma gravadora -__--__-__--__-
                                            Indique a gravadora:
                                            """);
                                    leitor.nextLine();
                                    String buscaGravadora = Utils.capitalize(leitor.nextLine());
                                    Utils.removerGravadoras(listaGravadoras, buscaGravadora);
                                    break;

                                case 0:
                                    acessoColab = false;
                                    System.out.println("Voltando para o login!" + "\n");
                                    acessoLogin = true;
                                    break;


                                default:
                                    System.out.println("Opção inválida!" + "\n");
                            }
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
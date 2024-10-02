public class Colaborador {

    public Filme criarFilme (Filme f, String nome, String duracao, String direcao, int classificacao) {
        return f.instanciarFilme(nome, duracao, 0f,  direcao, classificacao, new Gravadora(""));
    }
}

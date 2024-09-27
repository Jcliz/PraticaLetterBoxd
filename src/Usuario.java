import java.util.ArrayList;

public class Usuario {
    private String email;
    private String username;
    private String senha;
    private int idade;
    private String localizacao;
    private String bio;
    private ArrayList<Filme> assistidos = new ArrayList<>();
    private ArrayList<Filme> favoritos = new ArrayList<>();

    public Usuario (String email, String username, String senha, int idade, String localizacao, String bio) {
        this.email = email;
        this.username = username;
        this.senha = senha;
        this.idade = idade;
        this.localizacao = localizacao;
        this.bio = bio;
    }

    public void setLocalizacao (String localizacao) {
        this.localizacao = localizacao;
    }

    public void setBio (String bio) {
        this.bio = bio;
    }

    @Override
    public String toString () {
        return  "-_-_-_-_-_-_-_-_-_-" + "\n" +
                "E-mail: " + this.email + "\n" +
                "Username: " + this.username + "\n" +
                "Senha: " + this.senha + "\n" +
                "Idade: " + this.idade + "\n" +
                "Localização: " + this.localizacao + "\n" +
                "Bio: " + this.bio + "\n" +
                "-_-_-_-_-_-_-_-_-_-" + "\n";
    }

    public String getUser() {
        return username;
    }

    public String getSenha() {
        return senha;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public void setUser(String username) {
        this.username = username;
    }

    public void setSenha (String senha) {
        this.senha = senha;
    }

    public void setIdade (int idade) {
        this.idade = idade;
    }

    public void addAssistidos (Filme f) {
        assistidos.add(f);
    }

    public void addFavoritos (Filme f) {
        favoritos.add(f);
    }

    public void getAssistidos() {
        for (Filme filme : assistidos) {
            System.out.println(filme);
        }
    }

    public void getFavoritos() {
        for (Filme filme : favoritos) {
            System.out.println(filme);
        }
    }

    public ArrayList<Filme> pegarListaAssistidos () {
        return assistidos;
    }

    public ArrayList <Filme> pegarListaFavoritos () {
        return favoritos;
    }
}

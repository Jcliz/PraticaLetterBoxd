public class Usuario {
    private String email;
    private String username;
    private String senha;
    private int idade;
    private String localizacao;
    private String bio;

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
}


package classes;

public class Usuario {
    private String nomeCompleto;
    private String email;
    private String senha;
    private String nomeUsuario;

    
    public Usuario(){
    
}
    
    public Usuario(String nomeCompleto, String email, String senha, String nomeUsuario) {
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.senha = senha;
        this.nomeUsuario = nomeUsuario;
    }

    public boolean validarEmail() {
        // Verifica se o e-mail possui um formato válido
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(regex);
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
}

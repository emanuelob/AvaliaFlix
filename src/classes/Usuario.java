
package classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nomeCompleto;
    private String email;
    private String senha;
    private String nomeUsuario;
    
    public Usuario(){}
  
    public Usuario(String nomeCompleto, String email, String senha, String nomeUsuario) {
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.senha = senha;
        this.nomeUsuario = nomeUsuario;
    }
    
    public void adicionarUsuario() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/arquivosTXT/usuarios.txt", true))) {
        String linha = nomeCompleto + ";" + email + ";" + senha + ";" + nomeUsuario;
        writer.write(linha);
        writer.newLine();
    } catch (IOException e) {
        System.out.println("Erro ao escrever no arquivo de usuário: " + e.getMessage());
    }
    }
    
        public boolean realizarLogin(String usuario, String senha) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/arquivosTXT/usuarios.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dadosUsuario = linha.split(";");
                if (dadosUsuario[3].equals(usuario)) {
                    String usuarioArquivo = dadosUsuario[3];
                    String senhaArquivo = dadosUsuario[2];
                    
                    if (usuarioArquivo.equals(usuario) && senhaArquivo.equals(senha)) {
                        return true; // Login válido
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de usuários: " + e.getMessage());
        }
        return false; // Login inválido
    }

    public boolean validarEmail(String email) {
        // Verifica se o e-mail possui um formato válido
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(regex);
    }
    
    public void editarUsuario(String user, String novoNomeCompleto, String novoEmail, String novaSenha, String novoNomeUsuario) {
        List<String> usuarios = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/arquivosTXT/usuarios.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dadosUsuario = linha.split(";");
                if (dadosUsuario[3].equals(user)) {
                    dadosUsuario[0] = novoNomeCompleto;
                    dadosUsuario[1] = novoEmail;
                    dadosUsuario[2] = novaSenha;
                    dadosUsuario[3] = novoNomeUsuario;
                    
                    linha = String.join(";", dadosUsuario); 
                }
                usuarios.add(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de usuários: " + e.getMessage());
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/arquivosTXT/usuarios.txt"))) {
            for (String usuario : usuarios) {
                writer.write(usuario);
                writer.newLine();
            }} catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo de filmes: " + e.getMessage());
            } 
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

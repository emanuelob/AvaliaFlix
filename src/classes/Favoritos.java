
package classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*Dan, essa foi um sugestão de implementação dada pelo ChatGPT
Não conferi se está funcionado, mas decidir colocar aqui pq já tinha dado um contexto ao chat.
Sinta-se livre para implementar da forma que quiser. 

Uma descrição da classe:

Nessa versão da classe "Favoritos", foram adicionados dois métodos: carregarFavoritosFilmes() e carregarFavoritosSeries(). 
Esses métodos realizam a leitura dos arquivos "filmes.txt" e "series.txt", respectivamente, para carregar os favoritos previamente cadastrados.

Os arquivos são lidos linha por linha, e os dados de cada mídia são extraídos e utilizados para criar objetos do tipo "Filme" ou "Serie". 
Se a mídia for marcada como favorita, ela é adicionada à lista de favoritos.

Você pode chamar esses métodos no início do programa, antes de utilizar a classe "Favoritos", 
para carregar os favoritos armazenados nos arquivos de filmes e séries.
*/

public class Favoritos {
    private List<Midia> favoritos;

    public Favoritos() {
        favoritos = new ArrayList<>();
    }

    public void adicionarFavorito(Midia midia) {
        favoritos.add(midia);
    }

    public void removerFavorito(Midia midia) {
        favoritos.remove(midia);
    }

    public void listarFavoritos() {
        if (favoritos.isEmpty()) {
            System.out.println("Nenhum favorito encontrado.");
            return;
        }

        System.out.println("Favoritos:");
        for (Midia midia : favoritos) {
            System.out.println(midia.getNomeMidia());
        }
    }

    public void carregarFavoritosFilmes() {
        try (BufferedReader br = new BufferedReader(new FileReader("filmes.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                String nomeMidia = dados[0];
                String genero = dados[1];
                String dataAssistiu = dados[2];
                boolean ehFavorito = Boolean.parseBoolean(dados[3]);
                String comentario = dados[4];
                double nota = Double.parseDouble(dados[5]);
                int duracao = Integer.parseInt(dados[6]);

                Filme filme = new Filme(duracao, nomeMidia, genero, dataAssistiu, comentario, nota, ehFavorito);
                if (ehFavorito) {
                    favoritos.add(filme);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar os favoritos de filmes: " + e.getMessage());
        }
    }

    public void carregarFavoritosSeries() {
        try (BufferedReader br = new BufferedReader(new FileReader("series.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                String nomeMidia = dados[0];
                String genero = dados[1];
                String dataAssistiu = dados[2];
                boolean ehFavorito = Boolean.parseBoolean(dados[3]);
                String comentario = dados[4];
                double nota = Double.parseDouble(dados[5]);
                int temporada = Integer.parseInt(dados[6]);
                int episodio = Integer.parseInt(dados[7]);

                Serie serie = new Serie(temporada, episodio, nomeMidia, genero, dataAssistiu, comentario, nota, ehFavorito);
                if (ehFavorito) {
                    favoritos.add(serie);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar os favoritos de séries: " + e.getMessage());
        }
    }
}

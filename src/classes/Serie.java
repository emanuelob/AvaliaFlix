
package classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Serie extends Midia{
    private int temporada;
    private int episodio;
    
    public Serie() {}
     
    public Serie(String nomeMidia, String genero, String dataAssistiu, boolean ehFavorito, String comentario, double nota, int temporada, int episodio) {
        super(nomeMidia, genero, dataAssistiu, ehFavorito);
        this.temporada = temporada;
        this.episodio = episodio;
        super.adicionarComentario(comentario);
        super.adicionarNota(nota);
        }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public int getEpisodio() {
        return episodio;
    }

    public void setEpisodio(int episodio) {
        this.episodio = episodio;
    }   

    @Override
    public void adicionarMidia() {
        /*Cada linha do arquivo de texto representa uma série
        e contém os dados separados por um caractere específico, 
        como ponto e vírgula (;)*/
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/arquivosTXT/series.txt", true))) {
            String linha = this.nomeMidia + ";" + this.genero + ";" + this.dataAssistiu + ";" + this.ehFavorito + ";" + this.comentario + ";" + this.nota + ";" + this.temporada + ";" + this.episodio;
            writer.write(linha);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo de séries: " + e.getMessage());
        }
    }

    @Override
    public void buscarMidia(String nomeBusca) {
        /*O método lê o arquivo de texto correspondente "series.txt" e percorre cada linha do arquivo. 
        Para cada linha, ele divide os dados separados pelo caractere ponto e vírgula (;) e 
        verifica se o nome da mídia é igual ao nome de busca desejado (considerando case insensitive).

        Se a série for encontrada, por enquanto, será apresentado os dados da série. 
        Se a série não for encontrada após percorrer todas as linhas do arquivo, uma mensagem informando isso será exibida.*/    
            try (BufferedReader reader = new BufferedReader(new FileReader("src/arquivosTXT/series.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                String nomeMidia = dados[0];
                if (nomeMidia.equalsIgnoreCase(nomeBusca)) {
                    // Mídia encontrada, faça o que for necessário
                    System.out.println("Série encontrada: " + linha);
                    return; // Termina a busca após encontrar a primeira ocorrência
                }
            }
            // Caso a mídia não seja encontrada
            System.out.println("Série não encontrada.");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de séries: " + e.getMessage());
        }
    }

    @Override
    public void editarMidia(String nomeBusca, String novoNome, String novoGenero, String novaDataAssistiu,
                                   boolean novoEhFavorito, String novoComentario, double novaNota, int novaDuracao,  int novaTemporada, int novoEpisodio) {
        /*O método lê o arquivo de texto, encontra a série desejada pelo nome, 
        realiza a edição dos atributos na linha correspondente e armazena todas as linhas (séries) em uma lista temporária. 
        Após a edição, o método reescreve todas as linhas no arquivo de texto, substituindo o conteúdo anterior.*/
        
    // Lista para armazenar os filmes temporariamente
        List<String> filmes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/arquivosTXT/series.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                String nomeMidia = dados[0];
                if (nomeMidia.equalsIgnoreCase(nomeBusca)) {
                    // Realizar a edição dos atributos
                    dados[0] = novoNome;
                    dados[1] = novoGenero;
                    dados[2] = novaDataAssistiu;
                    dados[3] = String.valueOf(novoEhFavorito);
                    dados[4] = novoComentario;
                    dados[5] = String.valueOf(novaNota);
                    dados[6] = String.valueOf(novaTemporada); 
                    dados[7] = String.valueOf(novoEpisodio);  

                    linha = String.join(";", dados); // Recriar a linha com os dados editados
                }
                filmes.add(linha); // Adicionar a linha à lista de filmes
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de séries: " + e.getMessage());
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/arquivosTXT/series.txt"))) {
            for (String filme : filmes) {
                writer.write(filme);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo de séries: " + e.getMessage());
        }    
    }
}

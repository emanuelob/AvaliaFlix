
package classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Filme extends Midia{
    private int duracao;
    
    public Filme() {}
    
    public Filme(String nomeMidia, String genero) {
        //Construtor para atender a classe QueroAssistir
        super(nomeMidia, genero);
    }

    public Filme(String nomeMidia, String genero, String dataAssistiu, boolean ehFavorito, String comentario, double nota, int duracao) {
        super(nomeMidia, genero, dataAssistiu, ehFavorito);
        this.duracao = duracao;
        super.adicionarComentario(comentario);
        super.adicionarNota(nota);
    }

    public String duracaoDoFilme(){ /*Transformando a duração em minutos para o formato HH:MM.*/
        int duracaoMinutos = this.getDuracao();
        int horas = duracaoMinutos / 60; // Divide a duração em minutos por 60 para obter as horas
        int minutos = duracaoMinutos % 60; // O resto da divisão por 60 são os minutos restantes
        return horas + " horas e " + minutos + " minutos.";
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    @Override
    public void adicionarMidia() {
        /*Cada linha do arquivo de texto representa um filme
        e contém os dados separados por um caractere específico, 
        como ponto e vírgula (;)*/
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/arquivosTXT/filmes.txt", true))) {
            String linha = this.nomeMidia + ";" + this.genero + ";" + this.dataAssistiu + ";" + this.ehFavorito + ";" + this.comentario + ";" + this.nota + ";" + this.duracao;
            writer.write(linha);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo de filmes: " + e.getMessage());
        }
    }

    @Override
    public void buscarMidia(String nomeBusca) {
        /*O método lê o arquivo de texto correspondente "filmes.txt" e percorre cada linha do arquivo. 
        Para cada linha, ele divide os dados separados pelo caractere ponto e vírgula (;) e 
        verifica se o nome da mídia é igual ao nome de busca desejado (considerando case insensitive).

        Se o filme for encontrado, por enquanto, será apresentado os dados do filme. 
        Se o filme não for encontrado após percorrer todas as linhas do arquivo, uma mensagem informando isso será exibida.*/
        try (BufferedReader reader = new BufferedReader(new FileReader("src/arquivosTXT/filmes.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                String nomeMidia = dados[0];
                if (nomeMidia.equalsIgnoreCase(nomeBusca)) {
                    //Mídia encontrada
                    System.out.println("Filme encontrado: " + linha);
                    return; // Termina a busca após encontrar a primeira ocorrência
                }
            }
            // Caso a mídia não seja encontrada
            System.out.println("Filme não encontrado.");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de filmes: " + e.getMessage());
        }
    }

    @Override
    public void editarMidia(String nomeBusca, String novoNome, String novoGenero, String novaDataAssistiu,
            boolean novoEhFavorito, String novoComentario, double novaNota, int novaDuracao,  int novaTemporada, int novoEpisodio) {
        /*O método lê o arquivo de texto, encontra o filme desejado pelo nome, 
        realiza a edição dos atributos na linha correspondente e armazena todas as linhas (filmes) em uma lista temporária. 
        Após a edição, o método reescreve todas as linhas no arquivo de texto, substituindo o conteúdo anterior.*/

        // Lista para armazenar os filmes temporariamente
        List<String> filmes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/arquivosTXT/filmes.txt"))) {
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
                    dados[6] = String.valueOf(novaDuracao);

                    linha = String.join(";", dados); // Recriar a linha com os dados editados
                }
                filmes.add(linha); // Adicionar a linha à lista de filmes
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de filmes: " + e.getMessage());
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/arquivosTXT/filmes.txt"))) {
            for (String filme : filmes) {
                writer.write(filme);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo de filmes: " + e.getMessage());
        }    
    }
    
    @Override
    public String toTexto() {
        /*Tem a funcionalidade de retornar uma representação em texto dos atributos da mídia separados por um caractere delimitador.
        Retorna uma string concatenada no seguinte formato: "Filme;Nome do Filme;Gênero do Filme"
        Essa String representa os atributos da mídia de uma forma estruturada, 
        permitindo que eles possam ser facilmente recuperados e interpretados posteriormente.*/
        return "Filme;" + nomeMidia + ";" + genero;
    }
}


package classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Estatisticas {

    //Implementação inicial da classe Estatistica:
    
    /*Nesse trecho, declaramos a classe Estatistica com os atributos arquivoFilmes e arquivoSeries para armazenar os nomes dos arquivos de texto correspondentes aos filmes e séries. 
    O construtor é responsável por receber esses nomes de arquivos.

    O método gerarEstatisticas() é responsável por chamar os métodos auxiliares para contar o total de filmes, 
    o total de séries e o total de mídias, e imprimir essas informações na saída.*/
    
    
    public Estatisticas() {
    }

    
    
    
    
    public void gerarEstatisticas() {
        try {
            int totalFilmes = contarFilmes();
            int totalSeries = contarSeries();
            int totalMidias = totalFilmes + totalSeries;

            System.out.println("Estatísticas Gerais:");
            System.out.println("Total de Filmes: " + totalFilmes);
            System.out.println("Total de Séries: " + totalSeries);
            System.out.println("Total de Mídias: " + totalMidias);
        } catch (IOException e) {
            System.out.println("Erro ao ler os arquivos.");
            e.printStackTrace();
        }
    }

    /*Esse método utiliza um objeto BufferedReader para ler o arquivo de filmes linha por linha. 
    A cada linha lida, incrementamos o contador totalFilmes. Após percorrer todo o arquivo, 
    fechamos o leitor e retornamos o total de filmes encontrados.*/
    private int contarFilmes() throws IOException {
        int totalFilmes = 0;
        BufferedReader reader = new BufferedReader(new FileReader("src/arquivosTXT/filmes.txt"));
        while (reader.readLine() != null) {
            totalFilmes++;
        }
        reader.close();
        return totalFilmes;
    }
    
    /*Esse método é semelhante ao método contarFilmes(), mas lê o arquivo de séries em vez do arquivo de filmes. 
    Também utiliza um contador para contar o número de linhas e retorna o total de séries encontradas.*/
    private int contarSeries() throws IOException {
    int totalSeries = 0;
    BufferedReader reader = new BufferedReader(new FileReader("src/arquivosTXT/series.txt"));
    while (reader.readLine() != null) {
        totalSeries++;
    }
    reader.close();
    return totalSeries;
    }
    
    /*Nesse código, criamos o método calcularPorcentagemGeneros(), 
    responsável por chamar os métodos auxiliares para calcular a porcentagem de gêneros mais assistidos em filmes, séries e de forma geral.

    Os métodos calcularPorcentagemGenerosFilmes(), calcularPorcentagemGenerosSeries() e calcularPorcentagemGenerosGeral() 
    são responsáveis por ler os arquivos de filmes e séries, contar a quantidade de cada gênero e calcular a porcentagem em relação ao total de filmes, séries ou mídias. 
    Os resultados são exibidos na saída.*/
    
    
    
public void calcularPorcentagemGeralGeneros() {
    Map<String, Integer> generosContagemFilme = new HashMap<>();
    Map<String, Integer> generosContagemSerie = new HashMap<>();
    Map<String, Integer> generosContagemGeral = new HashMap<>();
    int totalFilmes = 0;
    int totalSeries = 0;

    try (BufferedReader filmesBr = new BufferedReader(new FileReader("src/arquivosTXT/filmes.txt"));
         BufferedReader seriesBr = new BufferedReader(new FileReader("src/arquivosTXT/series.txt"))) {

        // Calcular a porcentagem dos gêneros para os filmes
        String linhaFilmes;
        while ((linhaFilmes = filmesBr.readLine()) != null) {
            String[] dadosFilme = linhaFilmes.split(";");
            if (dadosFilme.length >= 2) {
                String genero = dadosFilme[1];
                generosContagemFilme.put(genero, generosContagemFilme.getOrDefault(genero, 0) + 1);
                generosContagemGeral.put(genero, generosContagemGeral.getOrDefault(genero, 0) + 1);
                totalFilmes++;
            }
        }
        System.out.println("Porcentagem dos gêneros dos filmes assistidos:");
        for (Map.Entry<String, Integer> entry : generosContagemFilme.entrySet()) {
            String genero = entry.getKey();
            int contagem = entry.getValue();
            double porcentagem = (contagem * 100.0) / totalFilmes;
            System.out.printf("%s: %.2f%%%n", genero, porcentagem);
        }

        // Calcular a porcentagem dos gêneros para as séries
        String linhaSeries;
        while ((linhaSeries = seriesBr.readLine()) != null) {
            String[] dadosSerie = linhaSeries.split(";");
            if (dadosSerie.length >= 2) {
                String genero = dadosSerie[1];
                generosContagemSerie.put(genero, generosContagemSerie.getOrDefault(genero, 0) + 1);
                generosContagemGeral.put(genero, generosContagemGeral.getOrDefault(genero, 0) + 1);
                totalSeries++;
            }
        }
        System.out.println("Porcentagem dos gêneros das séries assistidos:");
        for (Map.Entry<String, Integer> entry : generosContagemSerie.entrySet()) {
            String genero = entry.getKey();
            int contagem = entry.getValue();
            double porcentagem = (contagem * 100.0) / totalSeries;
            System.out.printf("%s: %.2f%%%n", genero, porcentagem);
        }
        
        
    } catch (IOException e) {
        e.printStackTrace();
    }

    // Calcular a porcentagem dos gêneros de um modo geral
    System.out.println("Porcentagem geral dos gêneros assistidos:");
    for (Map.Entry<String, Integer> entry : generosContagemGeral.entrySet()) {
        String genero = entry.getKey();
        int contagem = entry.getValue();
        int total = totalFilmes + totalSeries;
        double porcentagem = (contagem * 100.0) / total;
        System.out.printf("%s: %.2f%%%n", genero, porcentagem);
    }
}


    
    /*Nesse código, criamos o método calcularClassificacoesPorNota(), 
    responsável por chamar os métodos auxiliares para calcular a quantidade de mídias classificadas com cada nota de 1 a 5 em filmes, séries e de forma geral.

    Os métodos calcularClassificacoesPorNotaFilmes(), calcularClassificacoesPorNotaSeries() e calcularClassificacoesPorNotaGeral() 
    são responsáveis por ler os arquivos de filmes e séries, contar a quantidade de mídias em cada classificação de nota e exibir os resultados na saída.
    */
    
    public void calcularClassificacoesPorNota() {
    try {
        int totalFilmes = contarFilmes();
        int totalSeries = contarSeries();
        int totalMidias = totalFilmes + totalSeries;

        System.out.println("Estatísticas por Classificação:");
        calcularClassificacoesPorNotaFilmes(totalFilmes);
        calcularClassificacoesPorNotaSeries(totalSeries);
        calcularClassificacoesPorNotaGeral(totalMidias);
    } catch (IOException e) {
        System.out.println("Erro ao ler os arquivos.");
        e.printStackTrace();
        }
    }

    private void calcularClassificacoesPorNotaFilmes(int totalFilmes) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/arquivosTXT/filmes.txt"));
        int[] classificacoesContagem = new int[6]; // Assumindo que as notas variam de 1 a 5

        String linha;
        while ((linha = reader.readLine()) != null) {
            String[] dados = linha.split(";");
            if (dados.length >= 6) {
                double nota = Double.parseDouble(dados[5]);
                int indexClassificacao = (int) nota;
                classificacoesContagem[indexClassificacao]++;
            }
        }
        reader.close();

        System.out.println("Estatísticas dos Filmes:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Classificação " + i + ": " + classificacoesContagem[i] + " filmes");
        }
    }

    private void calcularClassificacoesPorNotaSeries(int totalSeries) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/arquivosTXT/series.txt"));
        int[] classificacoesContagem = new int[6]; // Assumindo que as notas variam de 1 a 5

        String linha;
        while ((linha = reader.readLine()) != null) {
            String[] dados = linha.split(";");
            if (dados.length >= 6) {
                double nota = Double.parseDouble(dados[5]);
                int indexClassificacao = (int) nota;
                classificacoesContagem[indexClassificacao]++;
            }
        }
        reader.close();

        System.out.println("Estatísticas das Séries:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Classificação " + i + ": " + classificacoesContagem[i] + " séries");
        }
    }

    private void calcularClassificacoesPorNotaGeral(int totalMidias) throws IOException {
        BufferedReader readerFilmes = new BufferedReader(new FileReader("src/arquivosTXT/filmes.txt"));
        BufferedReader readerSeries = new BufferedReader(new FileReader("src/arquivosTXT/series.txt"));
        int[] classificacoesContagem = new int[6]; // Assumindo que as notas variam de 1 a 5

        String linha;
        while ((linha = readerFilmes.readLine()) != null) {
            String[] dados = linha.split(";");
            if (dados.length >= 6) {
                double nota = Double.parseDouble(dados[5]);
                int indexClassificacao = (int) nota;
                classificacoesContagem[indexClassificacao]++;
            }
        }
        readerFilmes.close();

        while ((linha = readerSeries.readLine()) != null) {
            String[] dados = linha.split(";");
            if (dados.length >= 6) {
                double nota = Double.parseDouble(dados[5]);
                int indexClassificacao = (int) nota;
                classificacoesContagem[indexClassificacao]++;
            }
        }
        readerSeries.close();

        System.out.println("Estatísticas Gerais:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Classificação " + i + ": " + classificacoesContagem[i] + " mídias");
        }
    }
    
    /*Nesse código, criamos o método calcularTempoTotal(), responsável por chamar os métodos auxiliares para calcular o tempo total gasto em filmes, séries e de forma geral.

    Os métodos calcularTempoFilmes(), calcularTempoSeries() e calcularTempoGeral() são responsáveis por ler os arquivos de filmes e séries,
    somar a duração de cada mídia e exibir o tempo total na saída, convertido em horas e minutos.*/
    
    public void calcularTempoTotal() {
    try {
        int totalFilmes = contarFilmes();
        int totalSeries = contarSeries();
        int totalMidias = totalFilmes + totalSeries;

        System.out.println("Estatísticas de Tempo:");
        calcularTempoFilmes(totalFilmes);
        calcularTempoSeries(totalSeries);
        calcularTempoGeral(totalMidias);
    } catch (IOException e) {
        System.out.println("Erro ao ler os arquivos.");
        e.printStackTrace();
    }
}

    private void calcularTempoFilmes(int totalFilmes) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/arquivosTXT/filmes.txt"));
        int totalMinutos = 0;

        String linha;
        while ((linha = reader.readLine()) != null) {
            String[] dados = linha.split(";");
            if (dados.length >= 7) {
                int duracao = Integer.parseInt(dados[6]);
                totalMinutos += duracao;
            }
        }
        reader.close();

        int horas = totalMinutos / 60;
        int minutos = totalMinutos % 60;

        System.out.println("Estatísticas dos Filmes:");
        System.out.println("Tempo Total: " + horas + " horas e " + minutos + " minutos");
    }

    private void calcularTempoSeries(int totalSeries) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/arquivosTXT/series.txt"));
        int totalMinutos = 0;

        String linha;
        while ((linha = reader.readLine()) != null) {
            String[] dados = linha.split(";");
            if (dados.length >= 8) {
                int duracao = Integer.parseInt(dados[7]);
                totalMinutos += duracao;
            }
        }
        reader.close();

        int horas = totalMinutos / 60;
        int minutos = totalMinutos % 60;

        System.out.println("Estatísticas das Séries:");
        System.out.println("Tempo Total: " + horas + " horas e " + minutos + " minutos");
    }

    private void calcularTempoGeral(int totalMidias) throws IOException {
        BufferedReader readerFilmes = new BufferedReader(new FileReader("src/arquivosTXT/filmes.txt"));
        BufferedReader readerSeries = new BufferedReader(new FileReader("src/arquivosTXT/series.txt"));
        int totalMinutos = 0;

        String linha;
        while ((linha = readerFilmes.readLine()) != null) {
            String[] dados = linha.split(";");
            if (dados.length >= 7) {
                int duracao = Integer.parseInt(dados[6]);
                totalMinutos += duracao;
            }
        }
        readerFilmes.close();

        while ((linha = readerSeries.readLine()) != null) {
            String[] dados = linha.split(";");
            if (dados.length >= 8) {
                int duracao = Integer.parseInt(dados[7]);
                totalMinutos += duracao;
            }
        }
        readerSeries.close();

        int horas = totalMinutos / 60;
        int minutos = totalMinutos % 60;

        System.out.println("Estatísticas Gerais:");
        System.out.println("Tempo Total: " + horas + " horas e " + minutos + " minutos");
    }
    
   
}

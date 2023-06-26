
package classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Estatisticas {

    //Implementação inicial da classe Estatistica:
    
    /*Nesse trecho, declaramos a classe Estatistica com os atributos arquivoFilmes e arquivoSeries para armazenar os nomes dos arquivos de texto correspondentes aos filmes e séries. 
    O construtor é responsável por receber esses nomes de arquivos.

    O método gerarEstatisticas() é responsável por chamar os métodos auxiliares para contar o total de filmes, 
    o total de séries e o total de mídias, e imprimir essas informações na saída.*/
    
    private String arquivoFilmes;
    private String arquivoSeries;

    public Estatisticas(String arquivoFilmes, String arquivoSeries) {
        this.arquivoFilmes = arquivoFilmes;
        this.arquivoSeries = arquivoSeries;
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
        BufferedReader reader = new BufferedReader(new FileReader(arquivoFilmes));
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
    BufferedReader reader = new BufferedReader(new FileReader(arquivoSeries));
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
    
    public void calcularPorcentagemGeneros() {
    try {
        int totalFilmes = contarFilmes();
        int totalSeries = contarSeries();
        int totalMidias = totalFilmes + totalSeries;

        System.out.println("Estatísticas por Gênero:");
        calcularPorcentagemGenerosFilmes(totalFilmes);
        calcularPorcentagemGenerosSeries(totalSeries);
        calcularPorcentagemGenerosGeral(totalMidias);
    } catch (IOException e) {
        System.out.println("Erro ao ler os arquivos.");
        e.printStackTrace();
    }
}

    private void calcularPorcentagemGenerosFilmes(int totalFilmes) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(arquivoFilmes));
        int[] generosContagem = new int[7]; // Os 7 gêneros que definimos na interface gráfica
        int totalGeneros = 0;

        String linha;
        while ((linha = reader.readLine()) != null) {
            String[] dados = linha.split(";");
            if (dados.length >= 2) {
                String genero = dados[1];
                int indexGenero = Integer.parseInt(genero);
                generosContagem[indexGenero]++;
                totalGeneros++;
            }
        }
        reader.close();

        System.out.println("Estatísticas dos Filmes:");
        for (int i = 0; i < generosContagem.length; i++) {
            double porcentagem = (double) generosContagem[i] / totalFilmes * 100;
            System.out.println("Gênero " + i + ": " + porcentagem + "%");
        }
    }

    private void calcularPorcentagemGenerosSeries(int totalSeries) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(arquivoSeries));
        int[] generosContagem = new int[10]; // Assumindo que existem até 10 gêneros diferentes
        int totalGeneros = 0;

        String linha;
        while ((linha = reader.readLine()) != null) {
            String[] dados = linha.split(";");
            if (dados.length >= 2) {
                String genero = dados[1];
                int indexGenero = Integer.parseInt(genero);
                generosContagem[indexGenero]++;
                totalGeneros++;
            }
        }
        reader.close();

        System.out.println("Estatísticas das Séries:");
        for (int i = 0; i < generosContagem.length; i++) {
            double porcentagem = (double) generosContagem[i] / totalSeries * 100;
            System.out.println("Gênero " + i + ": " + porcentagem + "%");
        }
    }

    private void calcularPorcentagemGenerosGeral(int totalMidias) throws IOException {
        BufferedReader readerFilmes = new BufferedReader(new FileReader(arquivoFilmes));
        BufferedReader readerSeries = new BufferedReader(new FileReader(arquivoSeries));
        int[] generosContagem = new int[10]; // Assumindo que existem até 10 gêneros diferentes
        int totalGeneros = 0;

        String linha;
        while ((linha = readerFilmes.readLine()) != null) {
            String[] dados = linha.split(";");
            if (dados.length >= 2) {
                String genero = dados[1];
                int indexGenero = Integer.parseInt(genero);
                generosContagem[indexGenero]++;
                totalGeneros++;
            }
        }
        readerFilmes.close();

        while ((linha = readerSeries.readLine()) != null) {
            String[] dados = linha.split(";");
            if (dados.length >= 2) {
                String genero = dados[1];
                int indexGenero = Integer.parseInt(genero);
                generosContagem[indexGenero]++;
                totalGeneros++;
            }
        }
        readerSeries.close();

        System.out.println("Estatísticas Gerais:");
        for (int i = 0; i < generosContagem.length; i++) {
            double porcentagem = (double) generosContagem[i] / totalMidias * 100;
            System.out.println("Gênero " + i + ": " + porcentagem + "%");
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
        BufferedReader reader = new BufferedReader(new FileReader(arquivoFilmes));
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
        BufferedReader reader = new BufferedReader(new FileReader(arquivoSeries));
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
        BufferedReader readerFilmes = new BufferedReader(new FileReader(arquivoFilmes));
        BufferedReader readerSeries = new BufferedReader(new FileReader(arquivoSeries));
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
        BufferedReader reader = new BufferedReader(new FileReader(arquivoFilmes));
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
        BufferedReader reader = new BufferedReader(new FileReader(arquivoSeries));
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
        BufferedReader readerFilmes = new BufferedReader(new FileReader(arquivoFilmes));
        BufferedReader readerSeries = new BufferedReader(new FileReader(arquivoSeries));
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
    
    /*
    Na implementação anterior, abordamos algumas estatísticas com base nos requisitos mencionados. No entanto, é possível adicionar mais estatísticas conforme necessário. Aqui estão algumas sugestões adicionais:

    Média das notas: Você pode adicionar um método para calcular a média das notas atribuídas às mídias cadastradas, tanto para filmes quanto para séries, bem como uma média geral. Isso fornecerá uma medida de avaliação média das mídias assistidas pelo usuário.

    Média de duração:Da mesma forma, você pode adicionar um método para calcular a média da duração das mídias cadastradas, separadamente para filmes e séries, e uma média geral. Isso dará uma ideia da duração média das mídias assistidas pelo usuário.

    Porcentagem de mídias favoritas: Você pode calcular a porcentagem de mídias favoritas em relação ao total de mídias assistidas. Isso mostrará a proporção de mídias favoritas em relação ao total.

    Mídia mais assistida: Você pode determinar qual mídia foi assistida com mais frequência, seja filme ou série. Isso pode ser útil para identificar as preferências do usuário em relação a um tipo de mídia específico.
Essas são apenas algumas sugestões adicionais. Você pode personalizar a classe Estatística e adicionar as estatísticas que são relevantes para o seu sistema ou os requisitos do seu projeto específico.
    */
}

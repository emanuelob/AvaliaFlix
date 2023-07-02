
package classes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*Dan, essa foi um sugestão de implementação dada pelo ChatGPT
Não conferi se está funcionado, mas decidir colocar aqui pq já tinha dado um contexto ao chat.
Sinta-se livre para implementar da forma que quiser. 

Nessa implementação, a classe "QueroAssistir" possui uma lista chamada midiasQueroAssistir para armazenar todas as mídias cadastradas pelo usuário. 
O arquivo de texto "QueroAssistir.txt" é utilizado para persistir essas informações.

O método cadastrarMidia() permite ao usuário cadastrar uma mídia informando o nome, gênero e tipo de mídia (Filme ou Série). 
Com base no tipo de mídia fornecido, é criada uma instância da subclasse correspondente (Filme ou Serie), e essa mídia é adicionada na lista midiasQueroAssistir. 
Além disso, o método chama o método salvarNoArquivo() para salvar os dados da mídia no arquivo.

Os métodos mostrarFilmesQueroAssistir() e mostrarSeriesQueroAssistir() exibem na tela apenas os filmes e séries presentes na lista midiasQueroAssistir, respectivamente. Eles verificam o tipo de mídia utilizando o operador instanceof para garantir que apenas as mídias do tipo correspondente sejam exibidas.

O método salvarNoArquivo() é responsável por adicionar uma nova linha no arquivo "QueroAssistir.txt" com os dados da mídia, separados por ponto-e-vírgula (;).

O método carregarDoArquivo() é responsável por ler as informações do arquivo "QueroAssistir.txt" e criar as instâncias das mídias correspondentes. 
Ele utiliza o método criarMidiaAPartirDaLinha() para criar as instâncias de mídia a partir de cada linha lida do arquivo.

Dessa forma, ao criar uma instância da classe "QueroAssistir" e chamar o método carregarDoArquivo(), 
as mídias previamente cadastradas serão carregadas para a lista midiasQueroAssistir a partir do arquivo "QueroAssistir.txt".
*/

public class QueroAssistir {
    private List<Midia> midiasQueroAssistir;
    //private static final String NOME_ARQUIVO = "QueroAssistir.txt";

    public QueroAssistir() {
        midiasQueroAssistir = new ArrayList<>();
    }

    public void cadastrarMidia(String nomeMidia, String genero, String tipoMidia) {
        Midia midia;
        if (tipoMidia.equalsIgnoreCase("Filme")) {
            midia = new Filme(nomeMidia, genero);
        } else if (tipoMidia.equalsIgnoreCase("Serie")) {
            midia = new Serie(nomeMidia, genero);
        } else {
            System.out.println("Tipo de mídia inválido.");
            return;
        }

        midiasQueroAssistir.add(midia);
        System.out.println("Mídia cadastrada com sucesso!");
        salvarNoArquivo(midia);
    }

    public void mostrarFilmesQueroAssistir() {
        if (midiasQueroAssistir.isEmpty()) {
            System.out.println("Nenhum filme cadastrado para assistir.");
            return;
        }

        System.out.println("Filmes que deseja assistir:");

        for (Midia midia : midiasQueroAssistir) {
            if (midia instanceof Filme) {
                Filme filme = (Filme) midia;
                System.out.println("Nome: " + filme.getNomeMidia());
                System.out.println("Gênero: " + filme.getGenero());
                System.out.println("-------------------------");
            }
        }
    }

    public void mostrarSeriesQueroAssistir() {
        if (midiasQueroAssistir.isEmpty()) {
            System.out.println("Nenhuma série cadastrada para assistir.");
            return;
        }

        System.out.println("Séries que deseja assistir:");

        for (Midia midia : midiasQueroAssistir) {
            if (midia instanceof Serie) {
                Serie serie = (Serie) midia;
                System.out.println("Nome: " + serie.getNomeMidia());
                System.out.println("Gênero: " + serie.getGenero());
                System.out.println("-------------------------");
            }
        }
    }

    private void salvarNoArquivo(Midia midia) {
        try (FileWriter fw = new FileWriter("src/arquivosTXT/QueroAssistir.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {
            pw.println(midia.toTexto());
        } catch (IOException e) {
            System.out.println("Erro ao salvar no arquivo.");
        }
    }

    public void carregarDoArquivo() {
        try (FileReader fr = new FileReader("src/arquivosTXT/QueroAssistir.txt");
             BufferedReader br = new BufferedReader(fr)) {
            String linha;
            while ((linha = br.readLine()) != null) {
                Midia midia = criarMidiaAPartirDaLinha(linha);
                if (midia != null) {
                    midiasQueroAssistir.add(midia);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar o arquivo.");
        }
    }

    private Midia criarMidiaAPartirDaLinha(String linha) {
        String[] atributos = linha.split(";");
        if (atributos.length >= 3) {
            String tipoMidia = atributos[0];
            String nomeMidia = atributos[1];
            String genero = atributos[2];

            if (tipoMidia.equalsIgnoreCase("Filme")) {
                return new Filme(nomeMidia, genero);
            } else if (tipoMidia.equalsIgnoreCase("Serie")) {
                return new Serie(nomeMidia, genero);
            }
        }
        return null;
    }
}



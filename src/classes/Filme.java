
package classes;

public class Filme extends Midia{
    private int duracao;

    public Filme(int duracao, String nomeMidia, String genero, String dataAssistiu, String comentario, double nota, boolean ehFavorito) {
        super(nomeMidia, genero, dataAssistiu, ehFavorito);
        this.duracao = duracao;
        super.adicionarComentario(comentario);
        super.adicionarNota(nota);
    }

    public String duracaoDoFilme(int duracao){
        int duracaoMinutos = this.getDuracao();
        int horas = duracaoMinutos / 60; // Divide a duração em minutos por 60 para obter as horas
        int minutos = duracaoMinutos % 60; // O resto da divisão por 60 são os minutos restantes
        return horas + " horas e " + minutos + " minutos.";
    }
    
    public void AdicionarFilme() { //para adicionar filme na estrutura de dados.
        String duracaoDoFilme = this.duracaoDoFilme(this.duracao);
        //dadosFilme = [super.nomeMidia, super.genero, super.dataAssistiu, super.ehFavorito, super.comentario, super.nota, this.duracao, duracaoDoFilme]; 
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    @Override
    public void buscaMidia() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editarMidia() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

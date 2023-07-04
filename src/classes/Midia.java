
package classes;

public abstract class Midia {
    protected String nomeMidia;
    protected String genero;
    protected String dataAssistiu;
    protected boolean ehFavorito;
    protected String comentario;
    protected double nota;
    
    public Midia () {}
    
    public Midia(String nomeMidia, String genero) {
        //Construtor para atender a classe QueroAssistir
        this.nomeMidia = nomeMidia;
        this.genero = genero;        
    }
    
    public Midia(String nomeMidia, String genero, String dataAssistiu, boolean ehFavorito) {
        this.nomeMidia = nomeMidia;
        this.genero = genero;
        this.dataAssistiu = dataAssistiu;
        this.ehFavorito = ehFavorito;
    }
    
    public void adicionarComentario(String comentario) {
        this.comentario = comentario;
    }
    
    public void adicionarNota(double nota) {
        this.nota = nota;
    }
    
    public abstract void adicionarMidia(); 
    /*Método abstrato a ser implementado nas subclasses Filme e Série, 
    cuja finalidade é armazenar os dados permanentemente em um arquivo txt.*/

    public abstract void buscarMidia(String nomeBusca); 
    /*Método abstrato a ser implementado nas subclasses Filme e Série, 
    cuja finalidade é pesquisar mídia armazenada.*/
    
    public abstract void editarMidia(String nomeBusca, String novoNome, String novoGenero, String novaDataAssistiu,
                                   boolean novoEhFavorito, String novoComentario, double novaNota, int novaDuracao, int novaTemporada, int novoEpisodio); 
    /*Método abstrato a ser implementado nas subclasses Filme e Série, 
    cuja finalidade é alterar informações de uma mídia armazenada.*/
    
    public String getNomeMidia() {
        return nomeMidia;
    }

    public void setNomeMidia(String nomeMidia) {
        this.nomeMidia = nomeMidia;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDataAssistiu() {
        return dataAssistiu;
    }

    public void setDataAssistiu(String dataAssistiu) {
        this.dataAssistiu = dataAssistiu;
    }

    public boolean isEhFavorito() {
        return ehFavorito;
    }

    public void setEhFavorito(boolean ehFavorito) {
        this.ehFavorito = ehFavorito;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}

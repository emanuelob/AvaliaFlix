
package classes;

public class Serie extends Midia{
    private int temporada;
    private int episodio;

    public Serie(int temporada, int episodio, String nomeMidia, String genero, String dataAssistiu, String comentario, double nota, boolean ehFavorito) {
        super(nomeMidia, genero, dataAssistiu, ehFavorito);
        this.temporada = temporada;
        this.episodio = episodio;
        }

    @Override
    public void buscaMidia() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editarMidia() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
}

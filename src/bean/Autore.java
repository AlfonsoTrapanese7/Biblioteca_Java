package bean;
import java.util.Date;

public class Autore {
    private int idAutore;
    private String nome;
    private String cognome;
    private String paeseNascita;
    private Date dataNascita;
    private Date annoDecesso; // può essere null

    // Costruttore vuoto
    public Autore() {
    }

    // Getters e Setters
    public int getIdAutore() {
        return idAutore;
    }

    public void setIdAutore(int idAutore) {
        this.idAutore = idAutore;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getPaeseNascita() {
        return paeseNascita;
    }

    public void setPaeseNascita(String paeseNascita) {
        this.paeseNascita = paeseNascita;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    public Date getAnnoDecesso() {
        return annoDecesso;
    }

    public void setAnnoDecesso(Date annoDecesso) {
        this.annoDecesso = annoDecesso;
    }

    @Override
    public String toString() {
        return "Autore [idAutore=" + idAutore + ", nome=" + nome + ", cognome=" + cognome + ", paeseNascita="
                + paeseNascita + ", dataNascita=" + dataNascita + ", annoDecesso=" + annoDecesso + "]";
    }
    
}

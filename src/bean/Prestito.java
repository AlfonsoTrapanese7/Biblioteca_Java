package bean;

import java.sql.Date;


public class Prestito {
    private int idPrestito;   
    private int fkIdLibro;
    private Date dataPrestito;
    private Date dataRestituzione;
    private String stato; 
    private double penale;
    private int estensione;
    private String note;

    public Prestito() {
    }


    public Prestito(int idPrestito, int fkIdLibro, Date dataPrestito, Date dataRestituzione, String stato, double penale, int estenzione, String note) {
        this.idPrestito = idPrestito;
        this.fkIdLibro = fkIdLibro;
        this.dataPrestito = dataPrestito;
        this.dataRestituzione = dataRestituzione;
        this.stato = stato;
        this.penale = penale;
        this.estensione = estenzione;
        this.note = note;
    }
    
    public int getIdPrestito() {
        return this.idPrestito;
    }

    public void setIdPrestito(int id_prestito) {
        this.idPrestito = id_prestito;
    }

    public int getFkIdLibro() {
        return this.fkIdLibro;
    }

    public void setFkIdLibro(int fkIdLibro) {
        this.fkIdLibro = fkIdLibro;
    }

    public Date getDataPrestito() {
        return this.dataPrestito;
    }

    public void setDataPrestito(Date dataPrestito) {
        this.dataPrestito = dataPrestito;
    }

    public Date getDataRestituzione() {
        return this.dataRestituzione;
    }

    public void setDataRestituzione(Date dataRestituzione) {
        this.dataRestituzione = dataRestituzione;
    }

    public String getStato() {
        return this.stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public double getPenale() {
        return this.penale;
    }

    public void setPenale(double penale) {
        this.penale = penale;
    }

    public int getEstensione() {
        return this.estensione;
    }

    public void setEstensione(int estenzione) {
        this.estensione = estenzione;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    @Override
    public String toString() {
        return "{" +
            " id_prestito='" + getIdPrestito() + "'" +
            ", fkIdLibro='" + getFkIdLibro() + "'" +
            ", dataPrestito='" + getDataPrestito() + "'" +
            ", dataRestituzione='" + getDataRestituzione() + "'" +
            ", stato='" + getStato() + "'" +
            ", penale='" + getPenale() + "'" +
            ", estenzione='" + getEstensione() + "'" +
            ", note='" + getNote() + "'" +
            "}";
    }
    
}

    
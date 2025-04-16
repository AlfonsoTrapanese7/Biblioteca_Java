

import java.time.LocalDate;

public class Prestito {
    private int id_prestito;   
    private int fkIdLibro;
    private LocalDate dataPrestito;
    private LocalDate dataRestituzione;
    private String stato; 
    private double penale;
    private int estenzione;
    private String note;

    public Prestito() {
    }


    public Prestito(int id_prestito, int fkIdLibro, LocalDate dataPrestito, LocalDate dataRestituzione, String stato, double penale, int estenzione, String note) {
        this.id_prestito = id_prestito;
        this.fkIdLibro = fkIdLibro;
        this.dataPrestito = dataPrestito;
        this.dataRestituzione = dataRestituzione;
        this.stato = stato;
        this.penale = penale;
        this.estenzione = estenzione;
        this.note = note;
    }
    
    public int getId_prestito() {
        return this.id_prestito;
    }

    public void setId_prestito(int id_prestito) {
        this.id_prestito = id_prestito;
    }

    public int getFkIdLibro() {
        return this.fkIdLibro;
    }

    public void setFkIdLibro(int fkIdLibro) {
        this.fkIdLibro = fkIdLibro;
    }

    public LocalDate getDataPrestito() {
        return this.dataPrestito;
    }

    public void setDataPrestito(LocalDate dataPrestito) {
        this.dataPrestito = dataPrestito;
    }

    public LocalDate getDataRestituzione() {
        return this.dataRestituzione;
    }

    public void setDataRestituzione(LocalDate dataRestituzione) {
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

    public int getEstenzione() {
        return this.estenzione;
    }

    public void setEstenzione(int estenzione) {
        this.estenzione = estenzione;
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
            " id_prestito='" + getId_prestito() + "'" +
            ", fkIdLibro='" + getFkIdLibro() + "'" +
            ", dataPrestito='" + getDataPrestito() + "'" +
            ", dataRestituzione='" + getDataRestituzione() + "'" +
            ", stato='" + getStato() + "'" +
            ", penale='" + getPenale() + "'" +
            ", estenzione='" + getEstenzione() + "'" +
            ", note='" + getNote() + "'" +
            "}";
    }
    
}

    
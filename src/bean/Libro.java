package bean;

import java.util.Date;

public class Libro {
    private int idLibro;
    private String titolo;
    private int fkIdAutore;
    private int fkIdGenere;
    private Date annoUscita;
    private char isbn;
    private String casaEditrice;
    private double costoLibro;
    private int numeroPagine;

    public Libro() {}

    public Libro(int idLibro, String titolo, int fkIdAutore, int fkIdGenere, Date annoUscita, char isbn, String casaEditrice, double costoLibro, int numeroPagine) {
        this.idLibro = idLibro;
        this.titolo = titolo;
        this.fkIdAutore = fkIdAutore;
        this.fkIdGenere = fkIdGenere;
        this.annoUscita = annoUscita;
        this.isbn = isbn;
        this.casaEditrice = casaEditrice;
        this.costoLibro = costoLibro;
        this.numeroPagine = numeroPagine;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getFkIdAutore() {
        return fkIdAutore;
    }

    public void setFkIdAutore(int fkIdAutore) {
        this.fkIdAutore = fkIdAutore;
    }

    public int getFkIdGenere() {
        return fkIdGenere;
    }

    public void setFkIdGenere(int fkIdGenere) {
        this.fkIdGenere = fkIdGenere;
    }

    public Date getAnnoUscita() {
        return annoUscita;
    }

    public void setAnnoUscita(Date annoUscita) {
        this.annoUscita = annoUscita;
    }

    public char getIsbn() {
        return isbn;
    }

    public void setIsbn(char isbn) {
        this.isbn = isbn;
    }

    public String getCasaEditrice() {
        return casaEditrice;
    }

    public void setCasaEditrice(String casaEditrice) {
        this.casaEditrice = casaEditrice;
    }

    public double getCostoLibro() {
        return costoLibro;
    }

    public void setCostoLibro(double costoLibro) {
        this.costoLibro = costoLibro;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "Id Libro =" + idLibro +
                ", Titolo ='" + titolo + '\'' +
                ", Fk_Id_Autore ='" + fkIdAutore + '\'' +
                ", Fk_Id_Genere ='" + fkIdGenere + '\'' +
                ", Anno_Uscita ='" + annoUscita + '\'' +
                ", Isbn =" + isbn +
                ", Casa_Editrice ='" + casaEditrice + '\'' +
                ", Costo_Libro ='" + costoLibro + '\'' +
                ", Numero_Pagine ='" + numeroPagine + '\'' +
                '}';
    }
}

package bean;

public class Genere {
    private int idGenere;
    private String nome;
    private String sottogenere;
    private double dewey;

    // Costruttore vuoto
    public Genere() {
    }

    // Getters e Setters
    public int getIdGenere() {
        return idGenere;
    }

    public void setIdGenere(int idGenere) {
        this.idGenere = idGenere;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSottogenere() {
        return sottogenere;
    }

    public void setSottogenere(String sottogenere) {
        this.sottogenere = sottogenere;
    }

    public double getDewey() {
        return dewey;
    }

    public void setDewey(double dewey) {
        this.dewey = dewey;
    }


} 


public class Buch {
    private String titel;
    private String autor;
    private double preis;
    private final int ID;

    public Buch(String titel, String autor, double preis, int ID) {
        this.titel = titel;
        this.autor = autor;
        this.preis = preis;
        this.ID = ID;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public int getID() {
        return ID;
    }
}

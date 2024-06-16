package paint_project.SpringApplication;

public class Adres {
    private int id_adresu;
    private String kraj;
    private String miasto;
    private String ulica;
    private String numer_budynku;
    private String numer_lokalu;
    private String kod_pocztowy;

    public Adres(int id_adresu, String kraj, String miasto, String ulica, String numer_budynku, String numer_lokalu, String kod_pocztowy) {
        this.id_adresu = id_adresu;
        this.kraj = kraj;
        this.miasto = miasto;
        this.ulica = ulica;
        this.numer_budynku = numer_budynku;
        this.numer_lokalu = numer_lokalu;
        this.kod_pocztowy = kod_pocztowy;
    }

    public Adres(){}

    public int getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(int id_adresu) {
        this.id_adresu = id_adresu;
    }

    public String getKraj() {
        return kraj;
    }

    public void setKraj(String kraj) {
        this.kraj = kraj;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNumer_budynku() {
        return numer_budynku;
    }

    public void setNumer_budynku(String numer_budynku) {
        this.numer_budynku = numer_budynku;
    }

    public String getNumer_lokalu() {
        return numer_lokalu;
    }

    public void setNumer_lokalu(String numer_lokalu) {
        this.numer_lokalu = numer_lokalu;
    }

    public String getKod_pocztowy() {
        return kod_pocztowy;
    }

    public void setKod_pocztowy(String kod_pocztowy) {
        this.kod_pocztowy = kod_pocztowy;
    }

    @Override
    public String toString() {
        return "Adres{" +
                "id=" + id_adresu +
                ", country='" + kraj + '\'' +
                ", miasto='" + miasto + '\'' +
                ", street='" + ulica + '\'' +
                ", streetNumber='" + numer_budynku + '\'' +
                ", apartmentNumber='" + numer_lokalu + '\'' +
                ", postalCode='" + kod_pocztowy + '\'' +
                '}';
    }
}

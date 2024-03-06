package bdbt_bada_project.SpringApplication;

import java.sql.Date;

public class Zwierze {
    private int id_zwierzecia;
    private String gatunek;
    private String imie;
    private String typ_wody;
    private Date data_urodzenia;
    private int id_zbiornika;
    private int id_oceanarium;

    public Zwierze(int id_zwierzecia, String gatunek, String imie, String typ_wody, Date data_urodzenia, int id_zbiornika, int id_oceanarium) {
        this.id_zwierzecia = id_zwierzecia;
        this.gatunek = gatunek;
        this.imie = imie;
        this.typ_wody = typ_wody;
        this.data_urodzenia = data_urodzenia;
        this.id_zbiornika = id_zbiornika;
        this.id_oceanarium = id_oceanarium;
    }

    public Zwierze(){}

    public int getId_zwierzecia() {
        return id_zwierzecia;
    }

    public void setId_zwierzecia(int id_zwierzecia) {
        this.id_zwierzecia = id_zwierzecia;
    }

    public String getGatunek() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getTyp_wody() {
        return typ_wody;
    }

    public void setTyp_wody(String typ_wody) {
        this.typ_wody = typ_wody;
    }

    public Date getData_urodzenia() {
        return data_urodzenia;
    }

    public void setData_urodzenia(Date data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }

    public int getId_zbiornika() {
        return id_zbiornika;
    }

    public void setId_zbiornika(int id_zbiornika) {
        this.id_zbiornika = id_zbiornika;
    }

    public int getId_oceanarium() {
        return id_oceanarium;
    }

    public void setId_oceanarium(int id_oceanarium) {
        this.id_oceanarium = id_oceanarium;
    }

    @Override
    public String toString() {
        return "Zwierze{" +
                "id_zwierzecia=" + id_zwierzecia +
                ", gatunek='" + gatunek + '\'' +
                ", imie='" + imie + '\'' +
                ", typ_wody='" + typ_wody + '\'' +
                ", data_urodzenia=" + data_urodzenia +
                ", id_zbiornika=" + id_zbiornika +
                ", id_oceanarium=" + id_oceanarium +
                '}';
    }
}

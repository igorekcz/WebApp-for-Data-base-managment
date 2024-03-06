package bdbt_bada_project.SpringApplication;

public class Zbiornik {
    private int id_zbiornika;
    private String nazwa;
    private float pojemnosc;
    private int id_oceanarium;
    private int id_pracownika;

    public Zbiornik(){}
    public Zbiornik(int id_zbiornika, String nazwa, float pojemnosc, int id_oceanarium, int id_pracownika) {
        this.id_zbiornika = id_zbiornika;
        this.nazwa = nazwa;
        this.pojemnosc = pojemnosc;
        this.id_oceanarium = id_oceanarium;
        this.id_pracownika = id_pracownika;
    }

    public int getId_zbiornika() {
        return id_zbiornika;
    }

    public void setId_zbiornika(int id_zbiornika) {
        this.id_zbiornika = id_zbiornika;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public float getPojemnosc() {
        return pojemnosc;
    }

    public void setPojemnosc(float pojemnosc) {
        this.pojemnosc = pojemnosc;
    }

    public int getId_oceanarium() {
        return id_oceanarium;
    }

    public void setId_oceanarium(int id_oceanarium) {
        this.id_oceanarium = id_oceanarium;
    }

    public int getId_pracownika() {
        return id_pracownika;
    }

    public void setId_pracownika(int id_pracownika) {
        this.id_pracownika = id_pracownika;
    }
    @Override
    public String toString() {
        return "Zbiornik{" +
                "id_zbiornika=" + id_zbiornika +
                ", nazwa='" + nazwa + '\'' +
                ", pojemnosc=" + pojemnosc +
                ", id_oceanarium=" + id_oceanarium +
                ", id_pracownika=" + id_pracownika +
                '}';
    }
}

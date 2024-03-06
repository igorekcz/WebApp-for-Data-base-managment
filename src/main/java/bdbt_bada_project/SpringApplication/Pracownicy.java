package bdbt_bada_project.SpringApplication;
import java.sql.Date;

public class Pracownicy {
    private int id_pracownika;
    private String imie;
    private String drugie_imie;
    private String nazwisko;
    private Date data_urodzenia;
    private String pesel;
    private String plec;
    private String adres_email;
    private String stanowisko;
    private Date data_zatrudnienia;
    private int nr_konta;
    private int numer_telefonu;
    private int id_oceanarium;
    private String id_sklepu;
    private int id_adresu;

    public Pracownicy(){

    }
    public Pracownicy(int id_pracownika, String imie, String drugie_imie, String nazwisko, Date data_urodzenia, String pesel, String plec, String adres_email, String stanowisko, Date data_zatrudnienia, int nr_konta, int numer_telefonu, int id_oceanarium, String id_sklepu, int id_adresu) {
        super();
        this.id_pracownika = id_pracownika;
        this.imie = imie;
        this.drugie_imie = drugie_imie;
        this.nazwisko = nazwisko;
        this.data_urodzenia = data_urodzenia;
        this.pesel = pesel;
        this.plec = plec;
        this.adres_email = adres_email;
        this.stanowisko = stanowisko;
        this.data_zatrudnienia = data_zatrudnienia;
        this.nr_konta = nr_konta;
        this.numer_telefonu = numer_telefonu;
        this.id_oceanarium = id_oceanarium;
        this.id_sklepu = id_sklepu;
        this.id_adresu = id_adresu;
    }



    public int getId_pracownika() {
        return id_pracownika;
    }

    public void setId_pracownika(int id_pracownika) {
        this.id_pracownika = id_pracownika;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getDrugie_imie() {
        return drugie_imie;
    }

    public void setDrugie_imie(String drugie_imie) {
        this.drugie_imie = drugie_imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Date getData_urodzenia() {
        return data_urodzenia;
    }

    public void setData_urodzenia(Date data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String getAdres_email() {
        return adres_email;
    }

    public void setAdres_email(String adres_email) {
        this.adres_email = adres_email;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public Date getData_zatrudnienia() {
        return data_zatrudnienia;
    }

    public void setData_zatrudnienia(Date data_zatrudnienia) {
        this.data_zatrudnienia = data_zatrudnienia;
    }

    public int getNr_konta() {
        return nr_konta;
    }

    public void setNr_konta(int nr_konta) {
        this.nr_konta = nr_konta;
    }

    public int getNumer_telefonu() {
        return numer_telefonu;
    }

    public void setNumer_telefonu(int numer_telefonu) {
        this.numer_telefonu = numer_telefonu;
    }

    public int getId_oceanarium() {
        return id_oceanarium;
    }

    public void setId_oceanarium(int id_oceanarium) {
        this.id_oceanarium = id_oceanarium;
    }

    public String getId_sklepu() {
        return id_sklepu;
    }

    public void setId_sklepu(String id_sklepu) {
        this.id_sklepu = id_sklepu;
    }

    public int getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(int id_adresu) {
        this.id_adresu = id_adresu;
    }
    @Override
    public String toString() {
        return "Pracownicy{" +
                "id_pracownika=" + id_pracownika +
                ", imie='" + imie + '\'' +
                ", drugie_imie='" + drugie_imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", data_urodzenia=" + data_urodzenia +
                ", pesel=" + pesel +
                ", plec='" + plec + '\'' +
                ", adres_email='" + adres_email + '\'' +
                ", stanowisko='" + stanowisko + '\'' +
                ", data_zatrudnienia=" + data_zatrudnienia +
                ", nr_konta=" + nr_konta +
                ", numer_telefonu=" + numer_telefonu +
                ", id_oceanarium=" + id_oceanarium +
                ", id_sklepu=" + id_sklepu +
                ", id_adresu=" + id_adresu +
                '}';
    }
}

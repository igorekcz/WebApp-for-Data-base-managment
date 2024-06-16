package paint_project.SpringApplication;

import java.sql.Date;

public class Wynagrodzenie {
    private int id_wynagrodzenia;
    private Date data_zakwitowania;
    private int pensja_podstawowa;
    private int premia;
    private int id_pracownika;

    public Wynagrodzenie(int id_wynagrodzenia, Date data_zakwitowania, int pensja_podstawowa, int premia, int id_pracownika) {
        this.id_wynagrodzenia = id_wynagrodzenia;
        this.data_zakwitowania = data_zakwitowania;
        this.pensja_podstawowa = pensja_podstawowa;
        this.premia = premia;
        this.id_pracownika = id_pracownika;
    }

    public Wynagrodzenie(){}

    public int getId_wynagrodzenia() {
        return id_wynagrodzenia;
    }

    public void setId_wynagrodzenia(int id_wynagrodzenia) {
        this.id_wynagrodzenia = id_wynagrodzenia;
    }

    public Date getData_zakwitowania() {
        return data_zakwitowania;
    }

    public void setData_zakwitowania(Date data_zakwitowania) {
        this.data_zakwitowania = data_zakwitowania;
    }

    public int getPensja_podstawowa() {
        return pensja_podstawowa;
    }

    public void setPensja_podstawowa(int pensja_podstawowa) {
        this.pensja_podstawowa = pensja_podstawowa;
    }

    public int getPremia() {
        return premia;
    }

    public void setPremia(int premia) {
        this.premia = premia;
    }

    public int getId_pracownika() {
        return id_pracownika;
    }

    public void setId_pracownika(int id_pracownika) {
        this.id_pracownika = id_pracownika;
    }

    @Override
    public String toString() {
        return "Wynagrodzenie{" +
                "id_wynagrodzenia=" + id_wynagrodzenia +
                ", data_zakwitowania=" + data_zakwitowania +
                ", pensja_podstawowa=" + pensja_podstawowa +
                ", premia=" + premia +
                ", id_pracownika=" + id_pracownika +
                '}';
    }
}

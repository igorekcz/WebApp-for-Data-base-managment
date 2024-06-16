package paint_project.SpringApplication;

import java.sql.Date;

public class Bilety {
    private int id_biletu;
    private String czy_kupiony_online;
    private Date data_waznosci;
    private Date data_skasowania;
    private int cena;
    private int id_odwiedzajacego;
    private int id_uzytkownika;

    public Bilety(){

    }
    public Bilety(int id_biletu, String czy_kupiony_online, Date data_waznosci, Date data_skasowania, int cena, int id_odwiedzajacego, int id_uzytkownika) {
        this.id_biletu = id_biletu;
        this.czy_kupiony_online = czy_kupiony_online;
        this.data_waznosci = data_waznosci;
        this.data_skasowania = data_skasowania;
        this.cena = cena;
        this.id_odwiedzajacego = id_odwiedzajacego;
        this.id_uzytkownika = id_uzytkownika;
    }

    public int getId_biletu() {
        return id_biletu;
    }

    public void setId_biletu(int id_biletu) {
        this.id_biletu = id_biletu;
    }

    public String getCzy_kupiony_online() {
        return czy_kupiony_online;
    }

    public void setCzy_kupiony_online(String czy_kupiony_online) {
        this.czy_kupiony_online = czy_kupiony_online;
    }

    public Date getData_waznosci() {
        return data_waznosci;
    }

    public void setData_waznosci(Date data_waznosci) {
        this.data_waznosci = data_waznosci;
    }

    public Date getData_skasowania() {
        return data_skasowania;
    }

    public void setData_skasowania(Date data_skasowania) {
        this.data_skasowania = data_skasowania;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public int getId_odwiedzajacego() {
        return id_odwiedzajacego;
    }

    public void setId_odwiedzajacego(int id_odwiedzajacego) {
        this.id_odwiedzajacego = id_odwiedzajacego;
    }
    public int getId_uzytkownika() {
        return id_uzytkownika;
    }

    public void setId_uzytkownika(int id_uzytkownika) {
        this.id_uzytkownika = id_uzytkownika;
    }

    @Override
    public String toString() {
        return "Bilety{" +
                "id_biletu=" + id_biletu +
                ", czy_kupiony_online='" + czy_kupiony_online + '\'' +
                ", data_waznosci=" + data_waznosci +
                ", data_skasowania=" + data_skasowania +
                ", cena=" + cena +
                ", id_odwiedzajecgo=" + id_odwiedzajacego +
                '}';
    }
}

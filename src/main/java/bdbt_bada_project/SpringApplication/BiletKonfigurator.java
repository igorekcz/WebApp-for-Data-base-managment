package bdbt_bada_project.SpringApplication;

import java.sql.Date;

public class BiletKonfigurator {
    private Date data_wejscia;
    private int ilosc_normal;
    private int ilosc_ulg;

    public BiletKonfigurator(Date data_wejscia, int ilosc_normal, int ilosc_ulg){
        this.data_wejscia = data_wejscia;
        this.ilosc_normal = ilosc_normal;
        this.ilosc_ulg = ilosc_ulg;
    }
    public BiletKonfigurator(){};

    public Date getData_wejscia() {
        return data_wejscia;
    }

    public void setData_wejscia(Date data_wejscia) {
        this.data_wejscia = data_wejscia;
    }

    public int getIlosc_normal() {
        return ilosc_normal;
    }

    public void setIlosc_normal(int ilosc_normal) {
        this.ilosc_normal = ilosc_normal;
    }

    public int getIlosc_ulg() {
        return ilosc_ulg;
    }

    public void setIlosc_ulg(int ilosc_ulg) {
        this.ilosc_ulg = ilosc_ulg;
    }
}

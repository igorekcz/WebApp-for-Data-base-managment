package paint_project.SpringApplication;

public class Uzytkownik {
    private int id_uzytkownika;
    private String username;
    private String password;
    private String rola;

    public Uzytkownik() {
    }

    public Uzytkownik(int id_uzytkownika, String username, String password, String rola) {
        this.id_uzytkownika = id_uzytkownika;
        this.username = username;
        this.password = password;
        this.rola = rola;
    }

    public int getId_uzytkownika() {
        return id_uzytkownika;
    }

    public void setId_uzytkownika(int id_uzytkownika) {
        this.id_uzytkownika = id_uzytkownika;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRola() {
        return rola;
    }

    public void setRola(String rola) {
        this.rola = rola;
    }
    @Override
    public String toString() {
        return "Uzytkownik{" +
                "id_uzytkownika=" + id_uzytkownika +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", rola='" + rola + '\'' +
                '}';
    }
}

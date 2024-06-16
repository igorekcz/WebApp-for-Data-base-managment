package paint_project.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UzytkownikDAOTest extends Object {

    private UzytkownikDAO dao;
    @BeforeEach
    void setUp() throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        dataSource.setUsername("MANAGEROCEANARIUM");
        dataSource.setPassword("MANAGEROCEANARIUM");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new UzytkownikDAO(new JdbcTemplate(dataSource));
    }
    @Test
    void list() {
        List<Uzytkownik> listUzytkownik = dao.list();
        System.out.print(listUzytkownik);
        assertFalse(listUzytkownik.isEmpty());
    }
    @Test
    void save() {
        Uzytkownik uzytkownik = new Uzytkownik(1, "igorekcz", "123456", "ADMIN");
        dao.save(uzytkownik);
    }

    @Test
    void get() {
        int id = 1;
        Uzytkownik uzytkownik = dao.get(id);
        System.out.print(uzytkownik);
        assertNotNull(uzytkownik);
    }

    @Test
    void update() {
        Uzytkownik uzytkownik = dao.get(1);
        uzytkownik.setUsername("igorekcz2");
        dao.update(uzytkownik);
    }

    @Test
    void delete() {
        int id = 1;
        dao.delete(id);
    }
}
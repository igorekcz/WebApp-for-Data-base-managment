package paint_project.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PracownicyDAOTest extends Object {

    private PracownicyDAO dao;
    @BeforeEach
    void setUp() throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        dataSource.setUsername("MANAGEROCEANARIUM");
        dataSource.setPassword("MANAGEROCEANARIUM");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new PracownicyDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void list() {
        List<Pracownicy> listPracownicy = dao.list();
        System.out.print(listPracownicy);
        assertFalse(listPracownicy.isEmpty());
    }

    @Test
    void save() {
        Pracownicy pracownik = new Pracownicy(0, "Igor", null, "Czunikin", new Date(1705436025805L), "12312312311", "M", "igor@gmail.com", "Opiekun", new Date(1705436025805L), 123123123, 797797797, 1, null, 1, 0);
        dao.save(pracownik);
    }

    @Test
    void get() {fail("Not yet implemented");}

    @Test
    void update() {fail("Not yet implemented");}

    @Test
    void delete() {fail("Not yet implemented");}
}
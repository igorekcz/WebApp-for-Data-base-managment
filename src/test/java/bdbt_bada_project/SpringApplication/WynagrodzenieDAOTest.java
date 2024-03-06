package bdbt_bada_project.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;
import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class WynagrodzenieDAOTest extends Object {

    private WynagrodzenieDAO dao;
    @BeforeEach
    void setUp() throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        dataSource.setUsername("MANAGEROCEANARIUM");
        dataSource.setPassword("MANAGEROCEANARIUM");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new WynagrodzenieDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void list() {
        List<Wynagrodzenie> listWynagrodzenie = dao.list();
        System.out.print(listWynagrodzenie);
        assertFalse(listWynagrodzenie.isEmpty());
    }
    @Test
    void listForEmployee() {
        List<Wynagrodzenie> listWynagrodzenie = dao.listForEmployee(1);
        System.out.print(listWynagrodzenie);
        assertFalse(listWynagrodzenie.isEmpty());
    }

    @Test
    void save() {
        Wynagrodzenie wynagrodzenie = new Wynagrodzenie(0, new Date(2020, 10, 15), 200, 500, 1);
        dao.save(wynagrodzenie);
    }

    @Test
    void get() {
        int id = 1;
        Wynagrodzenie wynagrodzenie = dao.get(id);
        System.out.print(wynagrodzenie);
        assertNotNull(wynagrodzenie);
    }

    @Test
    void update() {
        Wynagrodzenie wynagrodzenie = new Wynagrodzenie();
        wynagrodzenie.setId_wynagrodzenia(1);
        wynagrodzenie.setData_zakwitowania(new Date(1705436025805L));
        wynagrodzenie.setPremia(999);
        wynagrodzenie.setPensja_podstawowa(999);
        wynagrodzenie.setId_pracownika(1);
        dao.update(wynagrodzenie);
    }

    @Test
    void delete() {
        int id = 8;
        dao.delete(id);
    }
}
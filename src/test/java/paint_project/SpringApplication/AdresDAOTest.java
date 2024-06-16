package paint_project.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdresDAOTest extends Object {

    private AdresDAO dao;

    @BeforeEach
    void setUp() throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        dataSource.setUsername("MANAGEROCEANARIUM");
        dataSource.setPassword("MANAGEROCEANARIUM");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new AdresDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void list() {
        List<Adres> listAdres = dao.list();
        System.out.print(listAdres);
        assertFalse(listAdres.isEmpty());
    }

    @Test
    void save() {
        fail("Not yet implemented");
    }

    @Test
    void get() {
        fail("Not yet implemented");
    }

    @Test
    void update() {
        fail("Not yet implemented");
    }

    @Test
    void delete() {
        fail("Not yet implemented");
    }
}
package bdbt_bada_project.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Date;
import java.util.List;
import java.sql.Driver;

import static org.junit.jupiter.api.Assertions.*;

class BiletyDAOTest extends Object {
    private BiletyDAO dao;
    @BeforeEach
    void setUp() throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        dataSource.setUsername("MANAGEROCEANARIUM");
        dataSource.setPassword("MANAGEROCEANARIUM");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new BiletyDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void list() {
        List<Bilety> listBilety = dao.list();
        System.out.print(listBilety);
        assertFalse(listBilety.isEmpty());
    }

    @Test
    void save() {
        Bilety bilety = new Bilety(0, "Y", new Date(1705436025805L), new Date(1755436025805L), 200, 2);
        dao.save(bilety);
    }

    @Test
    void get() {fail("Not yet implemented");
    }

    @Test
    void update() {fail("Not yet implemented");
    }

    @Test
    void delete() {fail("Not yet implemented");
    }
}
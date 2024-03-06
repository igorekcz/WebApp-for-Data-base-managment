package bdbt_bada_project.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ZbiornikDAOTest extends Object {

    private ZbiornikDAO dao;
    @BeforeEach
    void setUp() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        dataSource.setUsername("MANAGEROCEANARIUM");
        dataSource.setPassword("MANAGEROCEANARIUM");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new ZbiornikDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void list() {{
        List<Zbiornik> listZbiornik = dao.list();
        System.out.print(listZbiornik);
        assertFalse(listZbiornik.isEmpty());
    }
    }

    @Test
    void save() {fail("Not yet implemented");
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
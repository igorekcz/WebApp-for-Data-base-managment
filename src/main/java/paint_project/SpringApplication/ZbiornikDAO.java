package paint_project.SpringApplication;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ZbiornikDAO {
    /* Import org.springframework.jd....Template */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ZbiornikDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List */
    public List<Zbiornik> list(){
        String sql = "SELECT * FROM ZBIORNIKI";
        List<Zbiornik> listZbiornik = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Zbiornik.class));
        return listZbiornik;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Zbiornik zbiornik) {
    }
    /* Read – odczytywanie danych z bazy */
    public Zbiornik get(int id) {
        return null;
    }
    /* Update – aktualizacja danych */
    public void update(Zbiornik zbiornik) {
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }

}

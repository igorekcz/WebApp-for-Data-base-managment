package bdbt_bada_project.SpringApplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AdresDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AdresDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Adres> list(){
        String sql = "SELECT * FROM ADRESY";

        List<Adres> listAdress = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adres.class));

        return listAdress;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Adres adress) {
    }
    /* Read – odczytywanie danych z bazy */
    public Adres get(int id) {
        return null;
    }
    /* Update – aktualizacja danych */
    public void update(Adres adress) {
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }
}

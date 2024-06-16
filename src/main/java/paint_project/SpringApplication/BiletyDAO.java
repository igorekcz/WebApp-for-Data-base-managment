package paint_project.SpringApplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class BiletyDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public BiletyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Bilety> list(){
        String sql = "SELECT * FROM BILETY WHERE ID_ODWIEDZAJACEGO = 1";
        List<Bilety> ListBilety= jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Bilety.class));
        return ListBilety;
    }
    public List<Bilety> listForUser(int id){
        String sql = "SELECT * FROM BILETY WHERE ID_UZYTKOWNIKA = "+id;
        List<Bilety> ListBilety= jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Bilety.class));
        return ListBilety;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Bilety bilety) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        insert.withTableName("bilety").usingColumns("czy_kupiony_online", "data_waznosci",
                "data_skasowania", "cena", "id_odwiedzajacego", "id_uzytkownika");
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(bilety);
        insert.execute(parameterSource);
    }
    /* Read – odczytywanie danych z bazy */
    public Bilety get(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM BILETY WHERE id_biletu = " + args[0];
        Bilety bilety = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Bilety.class));
        return bilety;
    }
    /* Update – aktualizacja danych */
    public void update(Bilety bilety) {
        String sql = "UPDATE BILETY SET czy_kupiony_online=:czy_kupiony_online," +
                "data_waznosci=:data_waznosci, data_skasowania=:data_skasowania,"+
                "cena=:cena, id_odwiedzajacego=:id_odwiedzajacego, id_uzytkownika=:id_uzytkownika"+
                " WHERE id_biletu=:id_biletu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(bilety);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
        String sql = "DELETE FROM BILETY WHERE id_biletu=?";
        jdbcTemplate.update(sql,id);
    }

}

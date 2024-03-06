package bdbt_bada_project.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ZwierzeDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ZwierzeDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Zwierze> list(){
        String sql = "SELECT * FROM ZWIERZETA";

        List<Zwierze> listZwierze = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Zwierze.class));

        return listZwierze;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Zwierze zwierze) {
        SimpleJdbcInsert insert= new SimpleJdbcInsert(jdbcTemplate);
        insert.withTableName("zwierzeta").usingColumns("gatunek","imie","typ_wody","data_urodzenia","id_zbiornika","id_oceanarium");
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(zwierze);
        insert.execute(parameterSource);
    }
    /* Read – odczytywanie danych z bazy */
    public Zwierze get(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM ZWIERZETA WHERE id_zwierzecia = "+ args[0];
        Zwierze zwierze = jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper.newInstance(Zwierze.class));
        return zwierze;
    }
    /* Update – aktualizacja danych */
    public void update(Zwierze zwierze) {
        String sql = "UPDATE ZWIERZETA SET gatunek=:gatunek, imie=:imie, typ_wody=:typ_wody,data_urodzenia=:data_urodzenia," +
                "id_zbiornika=:id_zbiornika, id_oceanarium=:id_oceanarium WHERE id_zwierzecia=:id_zwierzecia";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(zwierze);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql,param);


    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
        String sql = "DELETE FROM ZWIERZETA WHERE id_zwierzecia = ?";
        jdbcTemplate.update(sql,id);
    }
}
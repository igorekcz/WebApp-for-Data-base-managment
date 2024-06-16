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
public class WynagrodzenieDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public WynagrodzenieDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Wynagrodzenie> list(){
        String sql = "SELECT * FROM WYNAGRODZENIA";

        List<Wynagrodzenie> listWynagrodzenie = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Wynagrodzenie.class));

        return listWynagrodzenie;
    }
    public List<Wynagrodzenie> listForEmployee(int id){
        String sql = "SELECT * FROM WYNAGRODZENIA WHERE ID_PRACOWNIKA = (SELECT ID_PRACOWNIKA FROM PRACOWNICY WHERE ID_UZYTKOWNIKA = "+ id +")";

        List<Wynagrodzenie> listWynagrodzenie = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Wynagrodzenie.class));

        return listWynagrodzenie;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Wynagrodzenie wynagrodzenie) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        insert.withTableName("wynagrodzenia").usingColumns("data_zakwitowania", "pensja_podstawowa",
                "premia", "id_pracownika");
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(wynagrodzenie);
        insert.execute(parameterSource);
    }
    /* Read – odczytywanie danych z bazy */
    public Wynagrodzenie get(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM WYNAGRODZENIA WHERE id_wynagrodzenia = " + args[0];
        Wynagrodzenie wynagrodzenie = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Wynagrodzenie.class));
        return wynagrodzenie;
    }
    /* Update – aktualizacja danych */
    public void update(Wynagrodzenie wynagrodzenie) {
        String sql = "UPDATE WYNAGRODZENIA SET data_zakwitowania=:data_zakwitowania," +
                " pensja_podstawowa=:pensja_podstawowa, premia=:premia, id_pracownika=:id_pracownika" +
                " WHERE id_wynagrodzenia=:id_wynagrodzenia";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(wynagrodzenie);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
        String sql = "DELETE FROM WYNAGRODZENIA WHERE id_wynagrodzenia = ?";
        jdbcTemplate.update(sql, id);
    }
}

package paint_project.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UzytkownikDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UzytkownikDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Uzytkownik> list(){
        String sql = "SELECT * FROM UZYTKOWNICY";

        List<Uzytkownik> listUzytkownik = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Uzytkownik.class));

        return listUzytkownik;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Uzytkownik uzytkownik) {
        SimpleJdbcInsert insert= new SimpleJdbcInsert(jdbcTemplate);
        insert.withTableName("uzytkownicy").usingColumns("username","password","rola");
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(uzytkownik);
        insert.execute(parameterSource);
    }
    /* Read – odczytywanie danych z bazy */
    public Uzytkownik get(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM UZYTKOWNICY WHERE id_uzytkownika = "+ args[0];
        Uzytkownik uzytkownik = jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper.newInstance(Uzytkownik.class));
        return uzytkownik;
    }
    public Uzytkownik get(String username) {
        Object[] args = {username};
        String sql = "SELECT * FROM UZYTKOWNICY WHERE username = '"+ args[0] + "'";
        Uzytkownik uzytkownik = jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper.newInstance(Uzytkownik.class));
        return uzytkownik;
    }
    /* Update – aktualizacja danych */
    public void update(Uzytkownik uzytkownik) {
        String sql = "UPDATE UZYTKOWNICY SET username=:username, rola=:rola WHERE id_uzytkownika=:id_uzytkownika";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(uzytkownik);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql,param);


    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
        String sql = "DELETE FROM UZYTKOWNICY WHERE id_uzytkownika = ?";
        jdbcTemplate.update(sql,id);
    }
}
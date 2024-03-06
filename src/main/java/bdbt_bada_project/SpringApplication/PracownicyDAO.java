package bdbt_bada_project.SpringApplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class PracownicyDAO {
    /* Import org.springframework.jd....Template */

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PracownicyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List */
    public List<Pracownicy> list(){
        String sql = "SELECT * FROM PRACOWNICY";

        List<Pracownicy> listPracownicy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pracownicy.class));
        return listPracownicy;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Pracownicy pracownicy) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        insert.withTableName("pracownicy").usingColumns("imie","drugie_imie","nazwisko","data_urodzenia","pesel",
                "plec","adres_email","stanowisko","data_zatrudnienia","nr_konta","numer_telefonu","id_oceanarium","id_sklepu","id_adresu");
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(pracownicy);
        insert.execute(parameterSource);
    }
    /* Read – odczytywanie danych z bazy */
    public Pracownicy get(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM PRACOWNICY WHERE id_pracownika = " + args[0];
        Pracownicy pracownicy = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Pracownicy.class));
        return pracownicy;
    }
    /* Update – aktualizacja danych */
    public void update(Pracownicy pracownicy) {
        String sql = "UPDATE PRACOWNICY SET imie=:imie, drugie_imie=:drugie_imie, nazwisko=:nazwisko, data_urodzenia=:data_urodzenia,"+
                "pesel=:pesel,plec=:plec,adres_email=:adres_email, stanowisko=:stanowisko,data_zatrudnienia=:data_zatrudnienia,"+
                "nr_konta=:nr_konta, numer_telefonu=:numer_telefonu,id_oceanarium=:id_oceanarium,id_sklepu=:id_sklepu,id_adresu=:id_adresu"+
                " WHERE id_pracownika=:id_pracownika";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownicy);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
        String sql = "DELETE FROM PRACOWNICY WHERE id_pracownika = ? ";
        jdbcTemplate.update(sql,id);
    }

}

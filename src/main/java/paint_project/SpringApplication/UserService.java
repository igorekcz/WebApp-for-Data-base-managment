package paint_project.SpringApplication;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UzytkownikDAO dao;
    private final PasswordEncoder passwordEncoder;

    public UserService(UzytkownikDAO dao, PasswordEncoder passwordEncoder) {
        this.dao = dao;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(String username, String rawPassword) {
        String encodedPassword = passwordEncoder.encode(rawPassword);
        Uzytkownik user = new Uzytkownik();
        user.setUsername(username);
        user.setPassword(encodedPassword);
        user.setRola("USER");
        try{
            dao.get(username);
        }catch (EmptyResultDataAccessException e)
        {
            dao.save(user);
            return;
        }
        throw new UsernameAlreadyExistsException("Username " + username + " already exists.");
    }
}

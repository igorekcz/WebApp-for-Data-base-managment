package paint_project.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;


@Configuration
public class AppController implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");

        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
        registry.addViewController("/main_accountant").setViewName("accountant/main_accountant");
    }
    @Controller
    public class DashboardController {
        @Autowired
        private UserService userService;
        @Autowired
        private UzytkownikDAO uzytkownikDAO;
        @Autowired
        private BiletyDAO biletyDAO;
        @Autowired
        private WynagrodzenieDAO wynagrodzenieDAO;
        @Autowired
        private ZwierzeDAO zwierzeDAO;
        @Autowired
        private PracownicyDAO pracownikDAO;
        @RequestMapping("/register")
        public String showRegistrationForm(Model model) {
            Uzytkownik uzytkownik = new Uzytkownik();
            model.addAttribute("uzytkownik", uzytkownik);
            return "register";
        }
        @RequestMapping(value = "/register/save", method = RequestMethod.POST)
        public String registerUser(@ModelAttribute("uzytkownik") Uzytkownik uzytkownik, Model model) {
            try {
                userService.registerUser(uzytkownik.getUsername(), uzytkownik.getPassword());
            } catch (UsernameAlreadyExistsException e){
                model.addAttribute("error", e.getMessage());
                return "register";
            }
            return "redirect:/login";
        }
        @RequestMapping({"/", "/index"})
        public String viewHomePage(Model model){
            List<Zwierze> zwierzeList = zwierzeDAO.list();
            model.addAttribute("zwierzeList", zwierzeList);
            return "index";
        }
        @RequestMapping("/main")
        public String defaultAfterLogin(HttpServletRequest request) {
            if
            (request.isUserInRole
                    ("ADMIN")) {
                return "redirect:/main_admin";
            }
            else if
            (request.isUserInRole
                            ("USER")) {
                return "redirect:/main_user";
            }
            else if
            (request.isUserInRole
                            ("ACCOUNTANT")) {
                return "redirect:/main_accountant";
            }
            else if
            (request.isUserInRole
                            ("EMPLOYEE")) {
                return "redirect:/main_employee";
            }
            else
            {
                return "redirect:/index";
            }
        }
        @RequestMapping("/main_accountant")
        public String showAccountantPage(Model model){
            List<Wynagrodzenie> wynagrodzenieList = wynagrodzenieDAO.list();
            model.addAttribute("wynagrodzenieList", wynagrodzenieList);
            return "accountant/main_accountant";
        }
        @RequestMapping("/main_accountant/new_payslip")
        public String showPayslipForm(Model model){
            Wynagrodzenie wynagrodzenie = new Wynagrodzenie();
            model.addAttribute("wynagrodzenie", wynagrodzenie);
            return "accountant/new_payslip";
        }
        @RequestMapping(value = "/main_accountant/save", method = RequestMethod.POST)
        public String savePayslip(@ModelAttribute("wynagrodzenie") Wynagrodzenie wynagrodzenie){
            wynagrodzenieDAO.save(wynagrodzenie);
            return "redirect:/main_accountant";
        }
        @RequestMapping("/main_accountant/edit/{id}")
        public ModelAndView showEditPayslipForm(@PathVariable(name = "id") int id){
            ModelAndView mav = new ModelAndView("accountant/edit_payslip");
            Wynagrodzenie wynagrodzenie = wynagrodzenieDAO.get(id);
            mav.addObject("wynagrodzenie", wynagrodzenie);
            return mav;
        }
        @RequestMapping("/main_accountant/update")
        public String updatePayslip(@ModelAttribute("wynagrodzenie") Wynagrodzenie wynagrodzenie){
            wynagrodzenieDAO.update(wynagrodzenie);
            return "redirect:/main_accountant";
        }
        @RequestMapping("/main_accountant/delete/{id}")
        public String deletePayslip(@PathVariable(name = "id") int id){
            wynagrodzenieDAO.delete(id);
            return "redirect:/main_accountant";
        }
        @RequestMapping(value={"/main_user"})
        public String showUserPage(Model model) {
            List<Bilety> biletyList = biletyDAO.listForUser(getCurrentUser());
            model.addAttribute("biletyList", biletyList);
            return "user/main_user";
        }
        @RequestMapping("/main_user/new_ticket")
        public String showTicketForm(Model model){
            BiletKonfigurator konfigurator = new BiletKonfigurator();
            model.addAttribute("konfigurator", konfigurator);
            return "user/new_ticket";
        }
        @RequestMapping(value = "/main_user/save", method = RequestMethod.POST)
        public String saveTicket(@ModelAttribute("konfigurator") BiletKonfigurator konfigurator){
            Date data_kupna = new Date(konfigurator.getData_wejscia().getTime() + 2629800000L);
            int ilNorm = konfigurator.getIlosc_normal();
            int ilUlg = konfigurator.getIlosc_ulg();
            for(int i = 0; i < ilNorm; i++){
                biletyDAO.save(new Bilety(0, "Y", data_kupna, null, 100, 1, getCurrentUser()));
            }
            for(int i = 0; i < ilUlg; i++){
                biletyDAO.save(new Bilety(0, "Y", data_kupna, null, 50, 1, getCurrentUser()));
            }
            return "redirect:/main_user";
        }
        @RequestMapping("/main_employee")
        public String showEmployeePage(Model model){
            List<Wynagrodzenie> employeeWynagrodzenieList = wynagrodzenieDAO.listForEmployee(getCurrentUser());
            model.addAttribute("wynagrodzeniaList", employeeWynagrodzenieList);
            return "employee/main_employee";
        }
        @RequestMapping("/main_employee/data_on_record")
        public String showEmployeeData(Model model){
            Pracownicy pracownik = pracownikDAO.getByUserId(getCurrentUser());
            model.addAttribute("pracownik", pracownik);
            return "employee/data_on_record";
        }
        @RequestMapping(value={"/main_admin"})
        public String showAdminPage() {
            return "admin/main_admin";
        }
        @RequestMapping("/main_admin/employees")
        public String showEmployeeTable(Model model){
            List<Pracownicy> pracownicy = pracownikDAO.list();
            model.addAttribute("pracownicyList", pracownicy);
            return "admin/employees";
        }
        @RequestMapping("/main_admin/new_employee")
        public String newEmployeeForm(Model model){
            Pracownicy pracownik = new Pracownicy();
            model.addAttribute("pracownik", pracownik);
            return "admin/new_employee";
        }
        @RequestMapping(value = "/main_admin/save_employee", method = RequestMethod.POST)
        public String saveEmployee(@ModelAttribute Pracownicy pracownik){
            pracownik.setId_oceanarium(1);
            pracownikDAO.save(pracownik);
            return "redirect:/main_admin/employees";
        }
        @RequestMapping("/main_admin/edit_employee/{id}")
        public ModelAndView editEmployee(@PathVariable(name = "id") int id){
            ModelAndView mav = new ModelAndView("admin/edit_employee");
            Pracownicy pracownik = pracownikDAO.get(id);
            mav.addObject("pracownik", pracownik);
            return mav;
        }
        @RequestMapping("/main_admin/update_employee")
        public String updateEmployee(@ModelAttribute("pracownik") Pracownicy pracownik){
            pracownik.setId_oceanarium(1);
            pracownikDAO.update(pracownik);
            return "redirect:/main_admin/employees";
        }
        @RequestMapping("/main_admin/delete_employee/{id}")
        public String deleteEmployee(@PathVariable(name = "id") int id){
            pracownikDAO.delete(id);
            return "redirect:/main_admin/employees";
        }
        @RequestMapping("/main_admin/animals")
        public String showAnimalsTable(Model model){
            List<Zwierze> zwierzeList = zwierzeDAO.list();
            model.addAttribute("zwierzeList", zwierzeList);
            return "admin/animals";
        }
        @RequestMapping("/main_admin/new_animal")
        public String newAnimalForm(Model model){
            Zwierze zwierze = new Zwierze();
            model.addAttribute("zwierze", zwierze);
            return "admin/new_animal";
        }
        @RequestMapping(value = "/main_admin/save_animal", method = RequestMethod.POST)
        public String saveAnimal(@ModelAttribute Zwierze zwierze){
            zwierze.setId_oceanarium(1);
            zwierze.setId_zbiornika(1);
            zwierzeDAO.save(zwierze);
            return "redirect:/main_admin/animals";
        }
        @RequestMapping("/main_admin/edit_animal/{id}")
        public ModelAndView editAnimal(@PathVariable(name = "id") int id){
            ModelAndView mav = new ModelAndView("admin/edit_animal");
            Zwierze zwierze = zwierzeDAO.get(id);
            mav.addObject("zwierze", zwierze);
            return mav;
        }
        @RequestMapping("/main_admin/update_animal")
        public String updateAnimal(@ModelAttribute("zwierze") Zwierze zwierze){
            zwierze.setId_oceanarium(1);
            zwierze.setId_zbiornika(1);
            zwierzeDAO.update(zwierze);
            return "redirect:/main_admin/animals";
        }
        @RequestMapping("/main_admin/delete_animal/{id}")
        public String deleteAnimal(@PathVariable(name = "id") int id){
            zwierzeDAO.delete(id);
            return "redirect:/main_admin/animals";
        }
        @RequestMapping("/main_admin/tickets")
        public String showTicketsTable(Model model){
            List<Bilety> biletyList = biletyDAO.list();
            model.addAttribute(biletyList);
            return "admin/tickets";
        }
        @RequestMapping("/main_admin/new_ticket")
        public String newTicketForm(Model model){
            Bilety bilet = new Bilety();
            model.addAttribute("bilet", bilet);
            return "admin/new_ticket";
        }
        @RequestMapping(value = "/main_admin/save_ticket", method = RequestMethod.POST)
        public String saveAnimal(@ModelAttribute Bilety bilet){
            bilet.setId_odwiedzajacego(1);
            biletyDAO.save(bilet);
            return "redirect:/main_admin/tickets";
        }
        @RequestMapping("/main_admin/edit_ticket/{id}")
        public ModelAndView editTicket(@PathVariable(name = "id") int id){
            ModelAndView mav = new ModelAndView("admin/edit_ticket");
            Bilety bilet = biletyDAO.get(id);
            mav.addObject("bilet", bilet);
            return mav;
        }
        @RequestMapping("/main_admin/update_ticket")
        public String updateTicket(@ModelAttribute("bilet") Bilety bilet){
            bilet.setId_odwiedzajacego(1);
            biletyDAO.update(bilet);
            return "redirect:/main_admin/tickets";
        }
        @RequestMapping("/main_admin/delete_ticket/{id}")
        public String deleteTicket(@PathVariable(name = "id") int id){
            biletyDAO.delete(id);
            return "redirect:/main_admin/tickets";
        }
        @RequestMapping("/main_admin/users")
        public String showUsersTable(Model model){
            List<Uzytkownik> uzytkownicy = uzytkownikDAO.list();
            model.addAttribute("uzytkownicyList", uzytkownicy);
            return "admin/users";
        }
        @RequestMapping("/main_admin/editUserRole/{id}")
        public ModelAndView editUser(@PathVariable(name = "id") int id){
            ModelAndView mav = new ModelAndView("admin/edit_user");
            Uzytkownik user = uzytkownikDAO.get(id);
            mav.addObject("user", user);
            return mav;
        }
        @RequestMapping("/main_admin/update_user")
        public String updateUser(@ModelAttribute("user") Uzytkownik user){
            uzytkownikDAO.update(user);
            return "redirect:/main_admin/users";
        }
        @RequestMapping("/main_admin/deleteUser/{id}")
        public String deleteUser(@PathVariable(name = "id") int id){
            uzytkownikDAO.delete(id);
            return "redirect:/main_admin/users";
        }
        public int getCurrentUser() {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName(); // get the username
            Uzytkownik user = uzytkownikDAO.get(username);
            return user.getId_uzytkownika();
        }
    }


}
package ma.berexia;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ma.berexia.entities.Role;
import ma.berexia.entities.User;
import ma.berexia.services.RoleService;
import ma.berexia.services.UserService;
import ma.berexia.services.UsersRolesService;

@SpringBootApplication
public class AuthenticationStdApplication {

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(AuthenticationStdApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}

	// ******************* ++++++ *****************

	@Autowired
	private UserService usersService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private UsersRolesService usersRolesService;

	//@Override
	public void run(String... args) throws Exception {
		
		if (usersService.findAllUsers().isEmpty() && usersService.findUserByUsername("admin") == null) {
			// Ajout user par défaut
			User u = new User();
			u.setUsername("admin");
			u.setPassword("admin");
			u.setActivated(true);
			usersService.saveUser(u);

			// Ajout Role par défaut
			Role r0 = new Role();
			Role r1 = new Role();
			Role r2 = new Role();
			r0.setRole("ADMIN");
			r0.setDescription("Super Admin");
			roleService.saveRole(r0);
			r1.setRole("DG");
			r1.setDescription("Directeur");
			roleService.saveRole(r1);
			r2.setRole("RECEP");
			r2.setDescription("Reception");
			roleService.saveRole(r2);

			// affecter role a user par defaut
			usersRolesService.addRoleToUser("admin", "ADMIN");
		}

	}

}


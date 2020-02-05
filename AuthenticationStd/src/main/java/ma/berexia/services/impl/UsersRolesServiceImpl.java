package ma.berexia.services.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.berexia.entities.Role;
import ma.berexia.entities.User;
import ma.berexia.repositories.RoleRepository;
import ma.berexia.repositories.UserRepository;
import ma.berexia.services.UsersRolesService;

@Service
@Transactional
public class UsersRolesServiceImpl implements UsersRolesService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void addRoleToUser(String username, String roleName) {
		System.out.println("11111111111111111");
		Role role = roleRepository.findByRole(roleName);
		System.out.println("22222222222");
		User user = userRepository.findByUsername(username);
		System.out.println("3333333333");
		user.getRoles().add(role);
		System.out.println("444444444");
	}

	@Override
	public Collection<Role> findRoleByUsername(String username) {
		User user = userRepository.findByUsername(username);
		Collection<Role> roles = user.getRoles();
		return roles;
	}

	@Override
	public void removeRoleToUser(String username, String roleName) {
		Role role = roleRepository.findByRole(roleName);
		User user = userRepository.findByUsername(username);
		user.getRoles().remove(role);
	}

}

package ma.berexia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.berexia.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	public Role findByRole(String roleName);

	public Role findByIdRole(int idRole);

}

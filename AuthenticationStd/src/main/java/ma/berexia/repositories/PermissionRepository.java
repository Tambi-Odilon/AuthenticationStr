package ma.berexia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.berexia.entities.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {
	public Permission findByOperation(String operation);

	public Permission findByIdPermission(int idPermission);
}

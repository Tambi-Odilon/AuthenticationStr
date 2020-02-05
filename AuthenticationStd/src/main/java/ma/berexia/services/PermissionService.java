package ma.berexia.services;

import java.util.List;

import ma.berexia.entities.Permission;

public interface PermissionService {
	public Permission savePermission(Permission permission);

	public void deletePermissionByOperation(String operation);

	public void deletePermissionByIdPermission(int idPermission);

	public List<Permission> findAllPermissions();

	public Permission findPermissionByOperation(String operation);

	public Permission findPermissionByIdPermission(int idPermission);
}

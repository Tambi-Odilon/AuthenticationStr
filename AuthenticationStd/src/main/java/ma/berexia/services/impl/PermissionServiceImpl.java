package ma.berexia.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ma.berexia.entities.Permission;
import ma.berexia.repositories.PermissionRepository;
import ma.berexia.services.PermissionService;

public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionRepository permissionRepository;

	@Override
	public Permission savePermission(Permission permission) {
		return permissionRepository.save(permission);
	}

	@Override
	public List<Permission> findAllPermissions() {
		return permissionRepository.findAll();
	}

	@Override
	public Permission findPermissionByOperation(String operation) {
		return permissionRepository.findByOperation(operation);
	}

	@Override
	public void deletePermissionByOperation(String operation) {
		Permission permission = permissionRepository.findByOperation(operation);
		permissionRepository.delete(permission);
	}

	@Override
	public void deletePermissionByIdPermission(int idPermission) {
		Permission permission = permissionRepository.findByIdPermission(idPermission);
		permissionRepository.delete(permission);
	}

	@Override
	public Permission findPermissionByIdPermission(int idPermission) {
		return permissionRepository.findByIdPermission(idPermission);
	}

}

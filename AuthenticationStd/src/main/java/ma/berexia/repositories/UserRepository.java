package ma.berexia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.berexia.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUsername(String username);

	public User findByIdUser(Long idUser);
}

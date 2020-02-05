package ma.berexia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.berexia.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
	public Client findByIdEtudiant(Long idEtudiant);
}

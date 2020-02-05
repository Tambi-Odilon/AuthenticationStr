package ma.berexia.services;

import java.util.List;

import ma.berexia.entities.Client;

public interface ClientService {
	public Client save(Client e);

	public List<Client> findAll();

	public void deleteEtudiantByIdEtudiant(long idEtudiant);
}

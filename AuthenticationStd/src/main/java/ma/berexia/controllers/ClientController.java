package ma.berexia.controllers;

import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.berexia.entities.Client;
import ma.berexia.repositories.ClientRepository;
import ma.berexia.services.ClientService;

@RestController
public class ClientController {

	@Autowired
	private ClientService clientService;

	@Autowired
	private ClientRepository clientRepository;

	@GetMapping("/clients")
	public Collection<Client> getAllClients() {
		return clientService.findAll();
	}

	@PostMapping("/clients")
	public Client saveClient(@RequestBody Client e) {
		return clientService.save(e);
	}

	// @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)

	@GetMapping("/client/{id}")
	ResponseEntity<?> getGroup(@PathVariable Long id) {
		Optional<Client> client = clientRepository.findById(id);
		return client.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PutMapping("/client/{id}")
	ResponseEntity<Client> updateClient(@Valid @RequestBody Client client) {
		// log.info("Request to update group: {}", group);
		Client result = clientRepository.save(client);
		return ResponseEntity.ok().body(result);
	}

	@DeleteMapping("/client/{id}")
	public ResponseEntity<?> deleteClient(@PathVariable Long id) {
		// log.info("Request to delete group: {}", id);
		clientRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}

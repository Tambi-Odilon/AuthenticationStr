package ma.berexia.services;

import java.util.List;

import ma.berexia.entities.Forms;

public interface FormsService {
	public Forms saveForms(Forms forms);

	public void deleteFormsByType(String type);

	public void deleteFormsByIdForms(int idForms);

	public List<Forms> findAllForms();

	public Forms findFormsByType(String type);

	public Forms findFormsByIdForms(int idForms);
}

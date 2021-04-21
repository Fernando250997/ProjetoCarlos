package br.com.bank.service;

import java.util.List;

import br.com.bank.model.Client;

public interface ClientService {

	public Client getClient(String name);
	
	public List<Client> getAll();
	
	public void save(Client client) throws Exception;
	
	public Client deleteClientById(Long idClient);

	Client getClient(String email, String password);

	Client getClientByName(String email);

	Client getClientByEmail(String email);
	Client getClientById(Long id);
}

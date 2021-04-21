package br.com.bank.dao;

import java.util.List;

import br.com.bank.model.Client;

public interface ClientDao { 

	public Client getClient(String name);

	public List<Client> getAll();

	public void save(Client client) throws Exception;

	public Client getClientByEmail(String email);

	public Client getClientById(Long id);

	public Client deleteClientById(Long idClient);
	
}

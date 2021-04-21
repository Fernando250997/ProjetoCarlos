/**
 * 
 */
package br.com.bank.service;

import java.util.List;

import br.com.bank.dao.ClientDaoImpl;
import br.com.bank.model.Client;

/**
 * @author cbgomes
 *
 */
public class ClientServiceImpl implements ClientService {
	
	private ClientDaoImpl dao;
	
	public ClientServiceImpl() {
		this.dao = new ClientDaoImpl();
	}


	public Client getClient(String name) {
		
		return this.dao.getClient(name);
	}
	
	public Client getClientByName(String email) {
		
		return this.dao.getClientByEmail(email);
		
	}
	

	public List<Client> getAll() {
		return this.dao.getAll();
	}

	@Override
	public void save(Client client) throws Exception {
		this.dao.save(client);
	}

	
	public Client deleteClientById(Long idClient) {
		
		return this.dao.deleteClientById(idClient);
		
	}

	public Client getClient(String email, String password) {
		return null;
	}
	

	public Client getClientByEmail(String email) 
	{
		
		return this.dao.getClientByEmail(email);
		
	}

	
	public Client getClientById(Long id) {
		return this.dao.getClientById(id);
	}

	
}

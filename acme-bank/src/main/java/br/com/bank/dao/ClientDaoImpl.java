/**
 * 
 */
package br.com.bank.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.bank.model.Client;
import br.com.bank.util.JPAUtil1;

/**
 * @author cbgomes
 *
 */
public class ClientDaoImpl implements ClientDao {

	@Override
	public Client getClient(String name) {
		EntityManager entityManager = JPAUtil1.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		try {
			
			Client client = entityManager.createNamedQuery("Client.getByName",Client.class)
					.setParameter("name", name)
					.getSingleResult();
			
			return client;
			
		}catch (NoResultException e) {
			e.getMessage();
			entityManager.close();
		}
		
		return null;
	}
	
	@Override
	public Client getClientByEmail(String email) {
		
		EntityManager entityManager = JPAUtil1.getEntityManagerFactory().createEntityManager();
		
		entityManager.getTransaction().begin();
		
		try {                               
			Client client = entityManager.createNamedQuery("Client.getByEmail",Client.class)
					.setParameter("email", email)
					.getSingleResult();
			
			return client;
			
		}catch (NoResultException e) {
			e.getMessage();
			entityManager.close();
		}
		
		return null;
	}
	

	@Override
	public List<Client> getAll() {
        
		EntityManager entityManager = JPAUtil1.getEntityManagerFactory().createEntityManager();
		
		entityManager.getTransaction().begin();
		
		try {
			                                              
			List<Client> clients = entityManager.createNamedQuery("Client.getAll",Client.class)
					.getResultList();
			
			return clients;
			
		}catch (NoResultException e) {
			e.getMessage();
			entityManager.close();
		}
		
		return null;
	}
	
	@Override
	public Client getClientById(Long id) { 
        
		EntityManager entityManager = JPAUtil1.getEntityManagerFactory().createEntityManager();
		
		entityManager.getTransaction().begin();
		
		try {
			                                             
			Client client = entityManager.createNamedQuery("Client.getById",Client.class)
					.setParameter("id", id)
					.getSingleResult();
			
			return client;
			
		}catch (NoResultException e) {
			e.getMessage();
			entityManager.close();
		}
		
		return null;
	}

	@Override
	public void save(Client client) throws Exception 
	{
		
		if (client.getPassword().equals("")) 
		{
			
			Exception e = new Exception("Password não ficar em branco!");
			throw e;
			
		}
		
		EntityManager entityManager = JPAUtil1.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		try {
			
			if (client.getId() != null) 
			{
				
				entityManager.merge(client);
				
			} 
			else
			{
			
				Client cverificacao = this.getClientByEmail(client.getEmail());
				
				if (cverificacao == null)
				{
					
					entityManager.persist(client);
					
				} 
				else 
				{
				
					Exception e = new Exception("Cliente já existente com este e-mail! [ "+client.getEmail()+" ]");
					throw e;
				}
				
				
				
			}
			
			entityManager.getTransaction().commit();
			entityManager.close();
			
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public Client deleteClientById(Long idClient) 
	{
		
		Client client = this.getClientById(idClient);
		
		EntityManager entityManager = JPAUtil1.getEntityManagerFactory().createEntityManager();
		
		entityManager.getTransaction().begin();
		
		try {
			
			entityManager.createQuery("delete from Client where id = :id")
			  .setParameter("id",idClient )
			  .executeUpdate();			
			
			entityManager.getTransaction().commit();
			entityManager.close();
			
			return client;
			
		} catch (Exception e) {
			e.getMessage();
		}
		
		return null;
		
	}

}

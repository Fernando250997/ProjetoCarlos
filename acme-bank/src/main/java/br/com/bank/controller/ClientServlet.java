package br.com.bank.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bank.model.Client;
import br.com.bank.service.ClientServiceImpl;

@WebServlet("/clientServlet")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClientServiceImpl service;
	
	public ClientServlet() {
		this.service = new ClientServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (request.getParameter("action").equals("edit")) 
		{
			
			Long id = Long.parseLong(request.getParameter("id"));
			
			Client client = this.service.getClientById(id);
			
			RequestDispatcher rd = request.getRequestDispatcher("add_client.jsp");
			request.setAttribute("client",client);	
			request.setAttribute("edit",true);
			rd.forward(request, response);	
			
		} 
		
		if (request.getParameter("action").equals("delete")) 
		{
			
			Long id = Long.parseLong(request.getParameter("id"));
						
			Client client = this.service.deleteClientById(id);
			
			RequestDispatcher rd = request.getRequestDispatcher("success.jsp");	
			request.setAttribute("msg","Cliente "+client.getName()+" deletado!");
			rd.forward(request, response);
			
		} 
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//PEGA OS DADOS DO REQUEST
		String id    = request.getParameter("id");
		String name  = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		
		
		//MONTEI O MEU OBJETO CLIENT
		Client client = new Client();
		
		if (!id.equals("")) 
		{
			client.setId(Long.parseLong(id));
		}
		
		client.setName(name);
		client.setEmail(email);
		client.setPhone(phone);
		client.setPassword(password);
		
		
		//SALVAR O MEU CLIENT
		try
		{
			this.service.save(client);
			RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			request.setAttribute("msg","Cliente "+client.getName()+(!id.equals("") ? " foi editado " : " foi inserido ") + "com sucesso!");
			rd.forward(request, response);
		}
		catch(Exception e)
		{
			RequestDispatcher rd = request.getRequestDispatcher("add_client.jsp");
			request.setAttribute("msg",e.getMessage());
			request.setAttribute("client",client);			
			rd.forward(request, response);
		}

		
	}
	
	
}

package br.com.bank.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import br.com.bank.model.Client;
import br.com.bank.service.ClientService;
import br.com.bank.service.ClientServiceImpl;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private ClientServiceImpl service;
	
	public LoginServlet() {
		this.service = new ClientServiceImpl();
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		
		Client client = this.service.getClientByEmail(email);
		
		if (client.getPassword().equals(pass) ) 
		{			
			
			//List<Client> clients = this.service.getAll();
			
			RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			request.setAttribute("user",email);
			//request.setAttribute("clients",clients);
			rd.forward(request, response);			
			
		}else {
			
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			request.setAttribute("error", "Erro, login ou senha estão incorretos");
			rd.forward(request, response);
		}			

		
	}

}

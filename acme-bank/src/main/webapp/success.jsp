<%@page import="br.com.bank.model.Client"%>
<%@page import="br.com.bank.service.ClientServiceImpl"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Já Cadastrados</title>
  <!-- CSS only -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
  <!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</head>
<body>
<%-- <% String user = (String) request.getAttribute("user"); %>
	<div align="center">
		<p align="center">Seja bem vindo, Sr. <%=user%></p>
	</div> --%>
	
	<%-- <div align="center">
		<c:if test="${user != null}">
			<p>Seja bem vindo, Sr. <strong>${user}</strong>  </p>
		</c:if>
	</div>
	
	
	<div align="center">
		<c:if test="${client != null}">
			<p>Nome<strong>${client.name}</strong>  </p>
			<p>E-mail<strong>${client.email}</strong>  </p>
			<p>Phone<strong>${client.phone}</strong>  </p>
		</c:if>
	</div>--%>
	
	<% 
	  
	  ClientServiceImpl service = new ClientServiceImpl();
	  List<Client> clients = service.getAll();	  
	
	%>
	<div align="center"> <h2>Já Cadastrados</h2> </div>
	<c:if test="${msg != null}">	   
	   <div align="center"> <p><strong>${msg}</strong></p> </div>			
	</c:if>
	<br>
	<br>
	
	<br>	
	<div style="width:80%;margin: 0 auto;" >
	<a href="login.jsp">Logout</a>
	    <table class="table .table-dark">
	           <thead class="thead-dark">
	            <tr> 
	                <th scope="col">(Id)</th>
		            <th scope="col">(Name)</th>
		            <th scope="col">(E-mail)</th>
		            <th scope="col">(Phone)</th>
		
               </tr>
               </thead>
               <tbody>
			<c:forEach var="c" items="<%=clients%>">
		        <tr>
		            <th scope="row"><c:out value="${c.id}" /></th>
		            <td><c:out value="${c.name}"/></td>
		            <td><c:out value="${c.email}"/></td>
		            <td><c:out value="${c.phone}"/></td>
		            <td><a href="clientServlet?action=edit&id=${c.id}" >Edit</a></td>
		            <td><a href="clientServlet?action=delete&id=${c.id}" >Delete</a></td>
		        </tr>
		    </c:forEach>
		    </tbody>
	    </table>
	
	</div>
</body>
</html>
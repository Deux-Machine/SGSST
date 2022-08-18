<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<jsp:include page="cabecera.jsp"/>
<h3>${titulo}</h3>
<form:form method="POST" action="/crear_usuario" modelAttribute="usuario" >
		
		
		<c:if test="${editar}">
			<form:hidden path="id"/>
		</c:if>
		
		
		<labe>Username</labe>
		<form:input type="text" path="username" class="form-control"/>
		<form:errors path="username"  style="color:red"></form:errors>
		
		<br/>
		
		<labe>Password</labe>
		<form:input type="password" path="password" class="form-control"/>
		<form:errors path="password"  style="color:red"></form:errors>
		
		<labe>Rol</labe>
		<form:select  path="roles" class="form-select">
		
			<form:option value="">-- Seleccionar</form:option>
			<form:option value="Consulta">Consultas</form:option>
			<form:option value="Auxiliar">Auxiliar</form:option>
			<form:option value="Admin">Administrador</form:option>
		</form:select>
		<form:errors path="roles"  style="color:red"></form:errors>
		<br/>


		<form:hidden path="empUnoaUno"/>



<button type="submit" class="btn btn-primary">Enviar</button>

</form:form>


<jsp:include page="pie.jsp"/>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="cabecera.jsp"/>

<center><h3>Reporte Estado de Cuentas</h3></center>

<br/>
<hr/>
<form action="/reporteCuentas" method="POST">
<div class="container">
<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1" >Fecha Inicial</span>
<input type="date" name="fechaIn" class="form-control"/>
</div>
<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1" >Fecha Final</span>
<input type="date" name="fechaFin" class="form-control"/>
</div>
</div>
<br/>
<center><button type="submit" class="btn btn-primary">Enviar</button></center>
</form>



<jsp:include page="pie.jsp"/>